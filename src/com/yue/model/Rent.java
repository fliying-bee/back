package com.yue.model;

import java.sql.Date;

public class Rent {
	private String rentId;	      /*租赁单编码*/ 
	private Date rentOrderTime;   /*租赁日期*/ 
	private int rentTime;         /*租赁时间  上限7天*/ 
	private String rentStatus;    /*租赁单状态   已付款  未付款*/
	private String logisStatus;   /*物流状态 商家未发货 商家已发货 用户已收货 用户已发货 商家已收货*/
	private Float rentPriceSum;	  /*租赁单总价*/ 
	private String userId;		  /*用户编码*/
	private String rentAddr;	  /*收货地址*/
	
	public String getRentId() {
		return rentId;
	}
	public void setRentId(String rentId) {
		this.rentId = rentId;
	}
	public Date getRentOrderTime() {
		return rentOrderTime;
	}
	public void setRentOrderTime(Date rentOrderTime) {
		this.rentOrderTime = rentOrderTime;
	}
	public int getRentTime() {
		return rentTime;
	}
	public void setRentTime(int rentTime) {
		this.rentTime = rentTime;
	}
	public String getRentStatus() {
		return rentStatus;
	}
	public void setRentStatus(String rentStatus) {
		this.rentStatus = rentStatus;
	}
	public String getLogisStatus() {
		return logisStatus;
	}
	public void setLogisStatus(String logisStatus) {
		this.logisStatus = logisStatus;
	}
	public Float getRentPriceSum() {
		return rentPriceSum;
	}
	public void setRentPriceSum(Float rentPriceSum) {
		this.rentPriceSum = rentPriceSum;
	}
	public String getRentAddr() {
		return rentAddr;
	}
	public void setRentAddr(String rentAddr) {
		this.rentAddr = rentAddr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
