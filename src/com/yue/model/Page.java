package com.yue.model;

import java.util.List;

public class Page<P> {
    private int currentPage=1;
    private int pageSize=10;
    private int totalPage;
    private int totalRow;
    private List<P> list;
    
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
		setTotalPage((getTotalRow() % pageSize) == 0 ? (getTotalRow() / pageSize)
				 : (getTotalRow() / pageSize + 1));
				 
	}
	public List<P> getList() {
		return list;
	}
	public void setList(List<P> list) {
		this.list = list;
	}
	
    
	
    
    
}
