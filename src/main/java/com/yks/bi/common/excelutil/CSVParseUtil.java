package com.yks.bi.common.excelutil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;

import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.web.vo.ErrorLogVo;

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
	
	/**
	 * 解析要上传到DailyOutSkuReprots表的csv
	 * @param lines
	 * @return
	 * @throws Exception 
	 */
	public static ErrorLogVo splitProfitCsv(String csvString,Map<Integer,String> column,Class<?> cls) throws Exception {
		CSVParser csvParse = CSVParser.parse(csvString, CSVFormat.DEFAULT);
		List<CSVRecord> recordList = csvParse.getRecords();
		List<Object> records = new ArrayList<Object>();
		ErrorLogVo errorLogVo = new ErrorLogVo();
        List<String> messageArray = new ArrayList<String>();
		for (int i = 1; i < recordList.size(); i++) {
			String message = "";
			String message1 = "";
			Object obj = ExcelUtil.newInstance(cls);
			for (Entry<Integer, String> entry : column.entrySet()) {
				String value = "";
				try{value = recordList.get(i).get(entry.getKey());}catch(Exception e){}
				message = ExcelUtil.setFileProfitValue(obj, entry.getValue(), value);
				if(!("设置成功".equals(message))){
					message1 += (message + ";");
				}
			}
			if(message1 != null && message1.length() > 0){
				message1 = "第" + i + "行数据校验失败," + message1;
				messageArray.add(message1);
			}
			records.add(obj);
		}
		errorLogVo.setObjectList(records);
		errorLogVo.setMessageArray(messageArray);
		return errorLogVo;
    }

}
