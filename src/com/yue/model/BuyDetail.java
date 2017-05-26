package com.yue.model;

public class BuyDetail {
	private String buyId;
	private String proDetailId;
	private String proId;
	private String buyDetailType;
	private int buyDetailCount;
	private Product product;
	
	public String getProDetailId() {
		return proDetailId;
	}
	public void setProDetailId(String proDetailId) {
		this.proDetailId = proDetailId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getBuyId() {
		return buyId;
	}
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getBuyDetailType() {
		return buyDetailType;
	}
	public void setBuyDetailType(String buyDetailType) {
		this.buyDetailType = buyDetailType;
	}
	public int getBuyDetailCount() {
		return buyDetailCount;
	}
	public void setBuyDetailCount(int buyDetailCount) {
		this.buyDetailCount = buyDetailCount;
	}
	
}
