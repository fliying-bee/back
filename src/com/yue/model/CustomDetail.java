package com.yue.model;

public class CustomDetail {
	private String customId;		/*定制单编码*/ 
	private String proId;			/*商品编码*/
	private String cusDetailType;	/*商品型号*/
	private int cusDetailCount;		/*商品数量*/
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getCusDetailType() {
		return cusDetailType;
	}
	public void setCusDetailType(String cusDetailType) {
		this.cusDetailType = cusDetailType;
	}
	public int getCusDetailCount() {
		return cusDetailCount;
	}
	public void setCusDetailCount(int cusDetailCount) {
		this.cusDetailCount = cusDetailCount;
	}
}
