package com.yue.model;

public class ProcureDetail {
	private String procureId;
	private String proDetailId;
	private String proId;
	private String procureDetailType;
	private int    procureDetailCount;
	private Product product;
	public String getProcureId() {
		return procureId;
	}
	public void setProcureId(String procureId) {
		this.procureId = procureId;
	}
	public String getProDetailId() {
		return proDetailId;
	}
	public void setProDetailId(String proDetailId) {
		this.proDetailId = proDetailId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProcureDetailType() {
		return procureDetailType;
	}
	public void setProcureDetailType(String procureDetailType) {
		this.procureDetailType = procureDetailType;
	}
	public int getProcureDetailCount() {
		return procureDetailCount;
	}
	public void setProcureDetailCount(int procureDetailCount) {
		this.procureDetailCount = procureDetailCount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}	
}
