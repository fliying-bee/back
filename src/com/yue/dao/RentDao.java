package com.yue.dao;

import java.util.List;

import com.yue.model.Rent;
import com.yue.model.RentOrder;

public interface RentDao {
	//根据ID查
	public RentOrder queryRentById(String rentId,String userId);
	//分页查询所有
	public List<RentOrder> queryAllRentPage(String userId);
	//插入
	public int insertRent(Rent rent);
	//更新
	public int updateRentStatus(Rent rent);
	//更新
	public int updateRentLogisStatus(Rent rent);
	//根据ID查
	public RentOrder queryBackRentById(String rentId);
	//分页查询所有
	public List<RentOrder> queryBackAllRentPage();
}
