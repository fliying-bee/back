package com.yue.model;

import java.sql.Date;
import java.util.List;

public class BuyOrder {
	private String buyId;
	private Date buyOrderTime;
	private String buyStatus;
	private String logisStatus;
	private float buyPriceSum;
	private String userId;
	private String buyAddr;
	private List<BuyDetail> BuyDetail;
	public List<BuyDetail> getBuyDetail() {
		return BuyDetail;
	}
	public void setBuyDetail(List<BuyDetail> buyDetail) {
		BuyDetail = buyDetail;
	}
	public String getBuyAddr() {
		return buyAddr;
	}
	public void setBuyAddr(String buyAddr) {
		this.buyAddr = buyAddr;
	}
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
	public float getBuyPriceSum() {
		return buyPriceSum;
	}
	public void setBuyPriceSum(float buyPriceSum) {
		this.buyPriceSum = buyPriceSum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
