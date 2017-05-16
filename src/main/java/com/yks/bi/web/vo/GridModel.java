package com.yks.bi.web.vo;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

public class GridModel {
	/**
	 * 页面显示的属性
	 */
	private int total;
	private int page;
	private long records;
	private List<?> rows;
	
	public GridModel(PageInfo<?> pageInfo){
		this.setPage(pageInfo.getPageNum());
		this.setRecords(pageInfo.getTotal());
		this.setTotal(pageInfo.getPages());
		this.setRows(pageInfo.getList());
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

}
