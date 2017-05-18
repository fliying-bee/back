package com.yue.model;

import java.sql.Date;

public class Buy {
	private String buyId;
	private Date buyOrderTime;
	private String buyStatus;
	private String logisStatus;
	private int buyPriceSum;
	private String userId;
	public String getBuyId() {
		return buyId;
	}
	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}
	public Date getBuyOrderTime() {
		return buyOrderTime;
	}
	public void setBuyOrderTime(Date buyOrderTime) {
		this.buyOrderTime = buyOrderTime;
	}
	public String getBuyStatus() {
		return buyStatus;
	}
	public void setBuyStatus(String buyStatus) {
		this.buyStatus = buyStatus;
	}
	public String getLogisStatus() {
		return logisStatus;
	}
	public void setLogisStatus(String logisStatus) {
		this.logisStatus = logisStatus;
	}
	public int getBuyPriceSum() {
		return buyPriceSum;
	}
	public void setBuyPriceSum(int buyPriceSum) {
		this.buyPriceSum = buyPriceSum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
