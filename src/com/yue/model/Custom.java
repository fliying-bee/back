package com.yue.model;

import java.sql.Date;

public class Custom {
	private String customId ;		/*定制单编码*/
	private Date customOrderTime;	/*定制时间*/
	private String customStatus;	/*定制单状态  已付款  未付款*/
	private String logisStatus;		/*物流状态  未发货  已发货   已收货*/
	private String customCheck;		/*定制单审核状态  已审核  未审核*/
	private Float customPrice;		/*定制单价格*/
	private String userId;			/*用户编码*/
	private String customAddr;		/*收货地址*/
	public String getCustomId() {
		return customId;
	}
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	public Date getCustomOrderTime() {
		return customOrderTime;
	}
	public void setCustomOrderTime(Date customOrderTime) {
		this.customOrderTime = customOrderTime;
	}
	public String getCustomStatus() {
		return customStatus;
	}
	public void setCustomStatus(String customStatus) {
		this.customStatus = customStatus;
	}
	public String getLogisStatus() {
		return logisStatus;
	}
	public void setLogisStatus(String logisStatus) {
		this.logisStatus = logisStatus;
	}
	public String getCustomCheck() {
		return customCheck;
	}
	public void setCustomCheck(String customCheck) {
		this.customCheck = customCheck;
	}
	public Float getCustomPrice() {
		return customPrice;
	}
	public void setCustomPrice(Float customPrice) {
		this.customPrice = customPrice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustomAddr() {
		return customAddr;
	}
	public void setCustomAddr(String customAddr) {
		this.customAddr = customAddr;
	}
}
