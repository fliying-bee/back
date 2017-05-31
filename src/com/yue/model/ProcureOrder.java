package com.yue.model;

import java.sql.Date;
import java.util.List;

public class ProcureOrder {
	private String procureId;
	private Date procureTime;
	private String ProcureStatus;
	private float procurePriceSum;
	private int procureCount;
	private Employee employee;
	private Factory factory;
	private List<ProcureDetail> ProcureDetail;
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public List<ProcureDetail> getProcureDetail() {
		return ProcureDetail;
	}
	public void setProcureDetail(List<ProcureDetail> procureDetail) {
		ProcureDetail = procureDetail;
	}
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
	
}
