package com.yue.model;

public class RentDetail {
	private String rentId;			/*租赁单编码*/ 
	private String proId;			/*商品编码*/
	private String proDetailId;			/*商品明细编码*/
	private String rentDetailType;	/*商品型号*/
	private int rentDetailCount;	/*商品数量*/
	public String getProDetailId() {
		return proDetailId;
	}
	public void setProDetailId(String proDetailId) {
		this.proDetailId = proDetailId;
	}
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getRentDetailType() {
		return rentDetailType;
	}
	public void setRentDetailType(String rentDetailType) {
		this.rentDetailType = rentDetailType;
	}
	public int getRentDetailCount() {
		return rentDetailCount;
	}
	public void setRentDetailCount(int rentDetailCount) {
		this.rentDetailCount = rentDetailCount;
	}
}
