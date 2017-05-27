package com.yue.model;

public class CustomDetail {
	private String customId;		/*定制单编码*/ 
	private String proId;			/*商品编码*/
	private String customDetailType;	/*商品型号*/
	private int customDetailCount;		/*商品数量*/
	private String proDetailId;
	private Product product;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProDetailId() {
		return proDetailId;
	}
	public void setProDetailId(String proDetailId) {
		this.proDetailId = proDetailId;
	}
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
	public String getCustomDetailType() {
		return customDetailType;
	}
	public void setCustomDetailType(String customDetailType) {
		this.customDetailType = customDetailType;
	}
	public int getCustomDetailCount() {
		return customDetailCount;
	}
	public void setCustomDetailCount(int customDetailCount) {
		this.customDetailCount = customDetailCount;
	}
	
}
