package com.yks.bi.common.excelutil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.SAXHelper;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.eventusermodel.XSSFReader.SheetIterator;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class XLSX2CSV {
	private static Logger log = Logger.getLogger(XLSX2CSV.class);
	
	private OPCPackage xlsxPackage;
	private int minColumns;
	private String strSource;
	
	private OutputStream output;

	/*public XLSX2CSV(OPCPackage pkg, OutputStream output, int minColumns) {
		this.xlsxPackage = pkg;
		this.output = output;
		this.minColumns = minColumns;
	}*/
	/**
	 * 
	 * @param strSource 要转换成csv的目标文件  不支持xls，只支持xlsx
	 * @param minColumns
	 * @throws Exception 
	 */
	public XLSX2CSV(String strSource, int minColumns) throws Exception{
		try {
			if(!strSource.endsWith(".xlsx")){
				throw new Exception("只支持xlsx格式转csv");
			}
			this.strSource = strSource;
			this.xlsxPackage = OPCPackage.open(strSource, PackageAccess.READ);
			this.minColumns = minColumns;
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
	}

	public void processSheet(StylesTable styles, ReadOnlySharedStringsTable strings, SheetContentsHandler sheetHandler,
			InputStream sheetInputStream) throws IOException, ParserConfigurationException, SAXException {
		DataFormatter formatter = new DataFormatter();
		InputSource sheetSource = new InputSource(sheetInputStream);

		try {
			XMLReader e = SAXHelper.newXMLReader();
			XSSFSheetXMLHandler handler = new XSSFSheetXMLHandler(styles, (CommentsTable) null, strings, sheetHandler,
					formatter, false);
			e.setContentHandler(handler);
			e.parse(sheetSource);
		} catch (ParserConfigurationException arg8) {
			throw new RuntimeException("SAX parser appears to be broken - " + arg8.getMessage());
		}
	}

	public List<String> process() throws IOException, OpenXML4JException, ParserConfigurationException, SAXException {
		ReadOnlySharedStringsTable strings = new ReadOnlySharedStringsTable(this.xlsxPackage);
		XSSFReader xssfReader = new XSSFReader(this.xlsxPackage);
		StylesTable styles = xssfReader.getStylesTable();
		SheetIterator iter = (SheetIterator) xssfReader.getSheetsData();
		
		List<String> fileNames = new ArrayList<String>();
		for (int index = 0; iter.hasNext(); ++index) {
			InputStream stream = iter.next();
			File file = new File(strSource);
			String path = file.getParent() + "/";
			String fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + index + ".csv";
			log.info("准备生成文件：" + fileName);
			fileNames.add(path + fileName);
			this.output = new FileOutputStream(path + fileName);
			this.processSheet(styles, strings, new XLSX2CSV.SheetToCSV(), stream);
			stream.close();
			log.info("生成成功");
		}
		this.xlsxPackage.close();
		this.output.close();
		return fileNames;
	}

	public static void main(String[] args) throws Exception {
		String strSource = "f:\\xiekanglin\\bi\\海外仓基础数据SQL.xlsx";
		XLSX2CSV xlsx2csv = new XLSX2CSV(strSource, -1);
		xlsx2csv.process();
	}

	private class SheetToCSV implements SheetContentsHandler {
		private boolean firstCellOfRow;
		private int currentRow;
		private int currentCol;

		private SheetToCSV() {
			this.firstCellOfRow = false;
			this.currentRow = -1;
			this.currentCol = -1;
		}

		private void outputMissingRows(int number) throws IOException {
			for (int i = 0; i < number; ++i) {
				for (int j = 0; j < XLSX2CSV.this.minColumns; ++j) {
					XLSX2CSV.this.output.write(',');
				}
				XLSX2CSV.this.output.write('\n');
			}

		}

		public void startRow(int rowNum) {
			try {
				this.outputMissingRows(rowNum - this.currentRow - 1);
			} catch (IOException e) {
				e.printStackTrace();
			}
			this.firstCellOfRow = true;
			this.currentRow = rowNum;
			this.currentCol = -1;
		}

		public void endRow(int rowNum) {
			try {
				for (int i = this.currentCol; i < XLSX2CSV.this.minColumns; ++i) {
						XLSX2CSV.this.output.write(',');
				}
				XLSX2CSV.this.output.write('\n');
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void cell(String cellReference, String formattedValue, XSSFComment comment) {
			try {
				if (this.firstCellOfRow) {
					this.firstCellOfRow = false;
				} else {
					XLSX2CSV.this.output.write(',');
				}
				short thisCol = (new CellReference(cellReference)).getCol();
				int missedCols = thisCol - this.currentCol - 1;
	
				for (int e = 0; e < missedCols; ++e) {
					XLSX2CSV.this.output.write(',');
				}
	
				this.currentCol = thisCol;
				if(formattedValue.indexOf("\"") > -1){
					formattedValue = formattedValue.replace("\"", "\"\"");
				}
				try {
					Double.parseDouble(formattedValue);
					XLSX2CSV.this.output.write(formattedValue.getBytes());
				} catch (NumberFormatException arg6) {
					XLSX2CSV.this.output.write('\"');
					XLSX2CSV.this.output.write(formattedValue.getBytes());
					XLSX2CSV.this.output.write('\"');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void headerFooter(String text, boolean isHeader, String tagName) {
		}
	}
}
