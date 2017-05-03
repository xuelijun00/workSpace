package com.yks.bi.web.vo;

import java.util.List;

import com.github.pagehelper.Page;

public class GridModel {
	/**
	 * 页面显示的属性
	 */
	private int total;
	private int page;
	private long records;
	private List<?> rows;
	/**
	 * 过滤属性
	 */
	private String sidx;
	private String sord;
	private String[] searchField;
	private String[] searchString;
	private String[] searchOper;

	public GridModel getGridModel(Page<?> page){
		this.setPage(page.getPageNum());
		this.setRecords(page.getTotal());
		this.setTotal(page.getPages());
		this.setRows(page.getResult());
		return this;
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

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String[] getSearchField() {
		return searchField;
	}

	public void setSearchField(String[] searchField) {
		this.searchField = searchField;
	}

	public String[] getSearchString() {
		return searchString;
	}

	public void setSearchString(String[] searchString) {
		this.searchString = searchString;
	}

	public String[] getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String[] searchOper) {
		this.searchOper = searchOper;
	}

}
