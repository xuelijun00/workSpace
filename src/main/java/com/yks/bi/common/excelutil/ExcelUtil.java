package com.yks.bi.common.excelutil;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ReflectionUtils;

public class ExcelUtil {
	
	private static Logger log = Logger.getLogger(ExcelUtil.class);
	
	/**
	 * 根据execl数据类型返回数据
	 * @param cell
	 * @param formula  计算公式
	 * @return
	 */
	public static Object getCellData(Cell cell, FormulaEvaluator formula) {
	    if(cell == null) {
	        return "";
	    }
	    switch (cell.getCellType()) {
		    case Cell.CELL_TYPE_STRING:
		        //return cell.getRichStringCellValue().getString();
		    	return cell.getStringCellValue();
		    case Cell.CELL_TYPE_NUMERIC:
		        if (DateUtil.isCellDateFormatted(cell)) {
		            return cell.getDateCellValue();
		        } else {
		        	DecimalFormat df = new DecimalFormat("0");
		            return df.format(cell.getNumericCellValue());
		        }
		    case Cell.CELL_TYPE_BOOLEAN:
		        return cell.getBooleanCellValue();
		    case Cell.CELL_TYPE_FORMULA:
		        return formula.evaluate(cell).getNumberValue();
		    default:
		        return "";
	    }
	}
	/**
	 * 读取excel时检查版本，是否能创建对象，工作簿
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static Workbook create(InputStream inp) throws Exception{
		if(inp == null){
			log.error("要解析excel的文件空");
			throw new Exception("要解析excel的文件空");
		}
		return WorkbookFactory.create(inp);
	}
	
	/**
	 * 获取bean中的set方法
	 * 并按照 字母排序
	 * @param cls
	 * @return
	 */
	public static Map<Integer,String> generateColumn(Class<?> cls,String prefix,int...columnIndex){
		Method[] method = ReflectionUtils.getAllDeclaredMethods(cls);
		List<String> methodNames = new ArrayList<String>();
		for (Method method2 : method) {
			if(method2.getName().startsWith(prefix) && method2.getName().indexOf("_") > -1){
				methodNames.add(method2.getName());
			}
		}
		Collections.sort(methodNames);
		int i = 0;
		Map<Integer,String> columns = new HashMap<Integer,String>();
		for (String string : methodNames) {
			if(columnIndex.length > 0){
				columns.put(columnIndex[i], string);
			}else{
				columns.put(i, string);
			}
			i++;
		}
		log.info("生成excel列和字段对应关系");
		return columns;
	}
	
	/**
	 * 设置字段 值
	 * @param cls
	 * @param methodName
	 * @param value
	 */
	public static boolean setFileValue(Object cls,String methodName,Object value){
		//使用该方法要指定参数类型
		//Method method = ReflectionUtils.findMethod(ExcelPojo.class, "setOrdersNumber",String.class);
		Method[] method = ReflectionUtils.getAllDeclaredMethods(cls.getClass());
		for (int i = 0; i < method.length; i++) {
			if(method[i].getName().equals(methodName)){
				Class<?>[] paramTypes = method[i].getParameterTypes();
				try{
					if("java.lang.Integer".equals(paramTypes[0].getName())){
						value = Integer.parseInt(value.toString().replaceAll(",", ""));
					}else if("java.lang.Float".equals(paramTypes[0].getName())){
						value = Float.parseFloat(value.toString().replaceAll(",", ""));
					}else if("java.lang.Double".equals(paramTypes[0].getName())){
						value = Double.parseDouble(value.toString().replaceAll(",", ""));
					}
				}catch(Exception ex){
					log.error("设置value值失败,类型不能转换,methodName:" + methodName + " value:" + value);
					return false;
				}
				ReflectionUtils.invokeMethod(method[i], cls, value);
				break;
			}
		}
		return true;
	}
	/**
	 * 获取值
	 * @param cls
	 * @param methodName
	 * @param value
	 * @return
	 */
	public static Object getFileValue(Object cls,String methodName){
		//使用该方法要指定参数类型
		//Method method = ReflectionUtils.findMethod(ExcelPojo.class, "setOrdersNumber",String.class);
		Method[] method = ReflectionUtils.getAllDeclaredMethods(cls.getClass());
		for (int i = 0; i < method.length; i++) {
			if(method[i].getName().equals(methodName)){
				return ReflectionUtils.invokeMethod(method[i], cls);
			}
		}
		return "";
	}
	/**
	 * 实例化对象
	 * @param class1
	 * @return
	 * @throws Exception
	 */
	public static Object newInstance(Class<?> class1) throws Exception{
		Constructor<?> constructor = class1.getConstructor();
		return constructor.newInstance();
	}
	
	/**
	 * 解析excel
	 * @param file 要解析的文件
	 * @param column 关系映射，excel的第几列对应 字段名set方法
	 * @param cls bean类
	 * @return
	 * @throws Exception
	 */
	public static List<Object> parseExcel(InputStream is,Map<Integer,String> column,Class<?> cls) throws Exception{
		Workbook workBook = create(is);
		List<Object> data = new ArrayList<Object>();
		Sheet sheet = workBook.getSheetAt(0);
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			Object obj = newInstance(cls);
			Iterator<Integer> iterator = column.keySet().iterator();
			boolean bo = false;
			while(iterator.hasNext()){
				Integer integer = iterator.next();
				Object value = getCellData(sheet.getRow(i).getCell(integer),null);
				bo = setFileValue(obj,column.get(integer),value);
			}
			if(bo)//转换异常的数据不添加进去
				data.add(obj);
			else
				continue;
		}
		is.close();
		workBook.close();
		log.info("解析excel记录总数：" + data.size());
		return data;
	}
	/**
	 * 生成excel
	 * @param fileName
	 * @param data
	 * @throws Exception
	 */
	public static void writeExcel(String fileName,List<Object> data) throws Exception{
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet();
		Map<Integer, String> column = generateColumn(data.get(0).getClass(), "get");
		for (int i = 0; i < data.size(); i++) {
			Row row = sheet.createRow(i);
			for (Entry<Integer, String> entry : column.entrySet()) {
				String value = getFileValue(data.get(i),entry.getValue()).toString();
				row.createCell(entry.getKey()).setCellValue(value);
			}
		}
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		workBook.write(fileOutputStream);
		workBook.close();
		log.error("生成excel成功：" + fileName);
	}
	
}
