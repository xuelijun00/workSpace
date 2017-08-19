package com.yks.bi.common.excelutil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

public class CSVParseUtil {
	
	private static Logger log = Logger.getLogger(CSVParseUtil.class);
	/**
	 * 解析海外仓基础数据
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static File[] parseOverseasWarehouseBaseData(String strSource) throws Exception{
		/**
		 * 生成csv
		 */
		/*XLSX2CSV xlsx2csv = new XLSX2CSV(strSource, -1);
		xlsx2csv.process();*/
		
		File file = new File(strSource);
		String dir = file.getParent();
		final String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
		File csvDir = new File(dir);
		File[] files = csvDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.startsWith(fileName) && name.endsWith(".csv");
			}
		});
		if(files.length < 12){
			log.error("文件格式有误，sheet大小：" + files.length);
			throw new Exception("文件格式有误，sheet大小：" + files.length);
		}
		//返回生成的csv
		return files;
	}
	
	/**
	 * 解析csv
	 * @param file
	 * @param column
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public static List<Object> parseCSV(File file,Map<Integer,String> column,Class<?> cls) throws Exception{
		CSVParser csvParse = CSVParser.parse(file, Charset.forName("utf-8"), CSVFormat.DEFAULT);
		List<CSVRecord>  csvRecords = csvParse.getRecords();
		List<Object> records = new ArrayList<Object>();
		for (int i = 1; i < csvRecords.size(); i++) {
			Object obj = ExcelUtil.newInstance(cls);
			for (Entry<Integer, String> entry : column.entrySet()) {
				String value = "";
				try{value = csvRecords.get(i).get(entry.getKey());}catch(Exception e){}
				if(value.equals("- 0")){
					value = value.replace("- ", "");
				}
				ExcelUtil.setFileValue(obj, entry.getValue(), value);
			}
			records.add(obj);
		}
		return records;
	}
	

}
