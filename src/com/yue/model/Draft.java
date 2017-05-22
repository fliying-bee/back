package com.yue.model;

public class Draft {
	private String draId;		/*稿件编码*/ 
	private String draName;		/*稿件名*/
	private String draCheck;	/*稿件审核状态  已审核  未审核*/ 
	private String drAuthor;	/*稿件作者*/ 
	private float draPrice;		/*稿件价格*/ 
	private String draDesc;		/*稿件描述*/
	private String draPicPath;	/*稿件图片路径*/
	private String userId;		/*用户编码*/
	private String empId;		/*员工编码*/
	private String customId;	/*定制单编码*/
	public String getDraId() {
		return draId;
	}
	public void setDraId(String draId) {
		this.draId = draId;
	}
	public String getDraName() {
		return draName;
	}
	public void setDraName(String draName) {
		this.draName = draName;
	}
	public String getDraCheck() {
		return draCheck;
	}
	public void setDraCheck(String draCheck) {
		this.draCheck = draCheck;
	}
	public String getDrAuthor() {
		return drAuthor;
	}
	public void setDrAuthor(String drAuthor) {
		this.drAuthor = drAuthor;
	}
	public float getDraPrice() {
		return draPrice;
	}
	public void setDraPrice(float draPrice) {
		this.draPrice = draPrice;
	}
	public String getDraDesc() {
		return draDesc;
	}
	public void setDraDesc(String draDesc) {
		this.draDesc = draDesc;
	}
	public String getDraPicPath() {
		return draPicPath;
	}
	public void setDraPicPath(String draPicPath) {
		this.draPicPath = draPicPath;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	} 
}
