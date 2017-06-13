package com.yks.bi.web.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

@SuppressWarnings("serial")
public class GridModel implements Serializable  {
	/**
	 * 页面显示的属性
	 */
	private int total;
	private int page;
	private long records;
	private List<?> rows;
	private Map<String,Object> userdata;
	
	public GridModel(PageInfo<?> pageInfo){
		this.setPage(pageInfo.getPageNum());
		this.setRecords(pageInfo.getTotal());
		this.setTotal(pageInfo.getPages());
		this.setRows(pageInfo.getList());
	}
	
	public GridModel(PageInfo<?> pageInfo,Map<String,Object> userdata){
		this.setPage(pageInfo.getPageNum());
		this.setRecords(pageInfo.getTotal());
		this.setTotal(pageInfo.getPages());
		this.setRows(pageInfo.getList());
		this.setUserdata(userdata);
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Map<String, Object> getUserdata() {
		return userdata;
	}

	public void setUserdata(Map<String, Object> userdata) {
		this.userdata = userdata;
	}

}
