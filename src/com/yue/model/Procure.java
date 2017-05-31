package com.yue.model;

import java.sql.Date;

public class Procure {
	private String procureId;
	private Date procureTime;
	private String ProcureStatus;
	private float procurePriceSum;
	private int procureCount;
	private String empId;
	private String facId;
	public String getProcureId() {
		return procureId;
	}
	public void setProcureId(String procureId) {
		this.procureId = procureId;
	}
	public Date getProcureTime() {
		return procureTime;
	}
	public void setProcureTime(Date procureTime) {
		this.procureTime = procureTime;
	}
	public String getProcureStatus() {
		return ProcureStatus;
	}
	public void setProcureStatus(String procureStatus) {
		ProcureStatus = procureStatus;
	}
	public float getProcurePriceSum() {
		return procurePriceSum;
	}
	public void setProcurePriceSum(float procurePriceSum) {
		this.procurePriceSum = procurePriceSum;
	}
	public int getProcureCount() {
		return procureCount;
	}
	public void setProcureCount(int procureCount) {
		this.procureCount = procureCount;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFacId() {
		return facId;
	}
	public void setFacId(String facId) {
		this.facId = facId;
	}
	
}
