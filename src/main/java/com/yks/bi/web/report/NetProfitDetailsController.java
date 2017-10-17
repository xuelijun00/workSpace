package com.yks.bi.web.report;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yks.bi.common.excelutil.CSVParseUtil;
import com.yks.bi.common.excelutil.ExcelUtil;
import com.yks.bi.dto.excel.DailyOutSkuReprotsExcel;
import com.yks.bi.dto.report.DailyOutSkuReprots;
import com.yks.bi.service.report.INetProfitDetailsService;
import com.yks.bi.web.vo.ErrorLogVo;
import com.yks.bi.web.vo.FilterDto;
import com.yks.bi.web.vo.GridModel;
import com.yks.bi.web.vo.MessageVo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 净利润详情
 * @author Administrator
 */
@RestController
@RequestMapping("/report")
public class NetProfitDetailsController {
	
	@Autowired
	private INetProfitDetailsService NetProfit;

	/**
	 * 净利润详情
	 * @param key
	 * @param filter
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/profit_details/grid")
	public GridModel selectAccountAchievementServiceGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots> list = NetProfit.selectAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}
	
	/**
	 * 查询平台
	 * @return
	 */
	@RequestMapping("/profit_details/platform")
	public List<String> selectPlatform() {
		return NetProfit.selectPlatform();
	}
	
	/**
	 * 查询账号
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/account")
	public List<String> selectAccount(String platform) {
		return NetProfit.selectAccount(platform);
	}
	/**
	 * 查询主站点
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/zhuzhandian")
	public List<String> selectZhuzhandian(String platform) {
		return NetProfit.selectZhuzhandian(platform);
	}
	
	@RequestMapping("/profit_details/chart")
	public List<DailyOutSkuReprots> selectProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectProfit(key);
	}
	
	@RequestMapping(value="/profit_details/newPlatform/grid")
	public GridModel selectNewPlatformGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots> list = NetProfit.selectNewPlatformAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping("/profit_details/newPlatform/chart")
	public List<DailyOutSkuReprots> selectNewPlatformProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectNewPlatformProfit(key);
	}

	/**
	 * 查询新平台的平台
	 * @return
	 */
	@RequestMapping("/profit_details/newPlatform/platform")
	public List<String> selectNewPlatform() {
		return NetProfit.selectNewPlatform();
	}

	/**
	 * 查询新平台的账号
	 * @return
	 */
	@RequestMapping("/profit_details/newPlatform/account")
	public List<String> selectNewPlatformAccount(String platform) {
		return NetProfit.selectNewPlatformAccount(platform);
	}

	/**
	 * 查询新平台主站点
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/newPlatform/zhuzhandian")
	public List<String> selectNewPlatformZhuzhandian(String platform) {
		return NetProfit.selectNewPlatformZhuzhandian(platform);
	}
	
	@RequestMapping(value="/profit_details/newEgg/grid")
	public GridModel selectNewEggformGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		List<DailyOutSkuReprots> list = NetProfit.selectNewEggAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping("/profit_details/newEgg/chart")
	public List<DailyOutSkuReprots> selectNewEggProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectNewEggProfit(key);
	}

	/**
	 * 查询新蛋的账号
	 * @return
	 */
	@RequestMapping("/profit_details/newEgg/account")
	public List<String> selectNewEggAccount(String platform) {
		return NetProfit.selectNewEggAccount(platform);
	}
	
	/**
	 * 查询新蛋主站点
	 * @param platform
	 * @return
	 */
	@RequestMapping("/profit_details/newEgg/zhuzhandian")
	public List<String> selectNewEggZhuzhandian(String platform) {
		return NetProfit.selectNewEggZhuzhandian(platform);
	}
	
	/**
	 * 用于“walmart发货订单净利”页面
	 * 净利润详情
	 * @param key
	 * @param filter
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/profit_details/walmart/grid")
	public GridModel selectWalmartAllGrid(DailyOutSkuReprots key,FilterDto filter) throws ParseException {
		PageHelper.startPage(filter.getPage(), filter.getRows(), true);
		PageHelper.orderBy(StringUtils.isNotEmpty(filter.getSidx())?filter.getSidx() + " " + filter.getSord():"");

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}		

		List<DailyOutSkuReprots> list = NetProfit.selectWalmartAll(key);
    	PageInfo<?> pageInfo = new PageInfo<>(list);
        return new GridModel(pageInfo);
	}

	@RequestMapping("/profit_details/walmart/chart")
	public List<DailyOutSkuReprots> selectWalmartProfitChart(DailyOutSkuReprots key) {

		if (key.getSku() != null && key.getSku().length() > 0) {
			String [] skuArray = key.getSku().split(",");
			key.setSku("'" + StringUtils.join(skuArray, "','") + "'");
		}

		PageHelper.orderBy("report_date");
		return NetProfit.selectWalmartProfit(key);
	}

	/**
	 * 用于“walmart发货订单净利”页面
	 * 查询账号
	 * @return
	 */
	@RequestMapping("/profit_details/walmart/account")
	public List<String> selectWalmartAccount() {
		return NetProfit.selectWalmartAccount();
	}

	/**
	 * 净利批量上传更新
	 * @return
	 */
	@RequestMapping(value ="/profit_details/update", method = RequestMethod.POST)
	public MessageVo profitUpdate(@RequestParam(value="file", required=false) CommonsMultipartFile file) {
		long d1 = System.currentTimeMillis();
        try{
            String csvString = IOUtils.toString(file.getInputStream(), "GBK");

            //判断文件是否为空
            if(csvString == null || csvString.trim().length() <= 0){
                return new MessageVo(HttpStatus.SC_BAD_REQUEST,"不能上传空文件");
            }

            //解析csv文件
            Map<Integer,String> column = ExcelUtil.generateColumn(DailyOutSkuReprotsExcel.class,"set");
    		ErrorLogVo errorLogVo = CSVParseUtil.splitProfitCsv(csvString, column, DailyOutSkuReprotsExcel.class);
    		List<Object> list = errorLogVo.getObjectList();

    		//判断文件中数据是否为空
    		if(list.size() <= 0 || CollectionUtils.isEmpty(list)){
    			return new MessageVo(HttpStatus.SC_BAD_REQUEST,"不能上传空文件");
    		}

    		//验证数据的有效性
    		List<String> messageArray= errorLogVo.getMessageArray();
    		List<String> keyIsNullArray = new ArrayList<String>();
    		if(messageArray.size() <= 0){
    			//验证正确则遍历更新数据
    			List<DailyOutSkuReprots> dosrList = DailyOutSkuReprotsExcel.objToDto(list);
    			for(int i=0; i < dosrList.size(); i++){
    				//验证主键是否为空
    				String keyIsNull = "";
    				if(dosrList.get(i).getErpOrdersId() == null){
    					keyIsNull = "erp_orders_id为必填项;";
    				}
    				if(dosrList.get(i).getPlatform() == null){
    					keyIsNull += "platform为必填项;";
    				}
    				if(dosrList.get(i).getSalesAccount() == null){
    					keyIsNull += "sales_account为必填项;";
    				}
    				if(dosrList.get(i).getSku() == null){
    					keyIsNull += "sku为必填项;";
    				}
    				if(dosrList.get(i).getReportDate() == null){
    					keyIsNull += "report_date为必填项;";
    				}
    				if(keyIsNull.length() > 0){
    					keyIsNull ="第" + (i+2) + "行上传失败，有必填项为空--" + keyIsNull;
    					keyIsNullArray.add(keyIsNull);
    					continue;
    				}

    				NetProfit.updateSelective(dosrList.get(i));
    			}
    			if(keyIsNullArray.size() > 0){
    				keyIsNullArray.add("表格中存在不规则数据行：上传失败：" + keyIsNullArray.size() + "行，上传成功" + (dosrList.size() - keyIsNullArray.size())+ "行");
    				return new MessageVo(HttpStatus.SC_BAD_REQUEST,null,keyIsNullArray);
    			}else{
    				return new MessageVo(HttpStatus.SC_OK,"上传成功,总数：" + dosrList.size());
    			}
    		}else{
    			//验证失败则返回信息
    			return new MessageVo(HttpStatus.SC_BAD_REQUEST,null,messageArray);
    		}
        }catch(Exception e){
            e.printStackTrace();
            return new MessageVo(HttpStatus.SC_BAD_REQUEST,e.getMessage());
        }
	}
}
