package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.RentDao;
import com.yue.model.Rent;
import com.yue.model.RentOrder;

@Service
public class RentService {
	@Autowired
	private RentDao RentDao;
	
	public RentOrder queryRentById(String rentId,String userId){
    	return RentDao.queryRentById(rentId,userId);
    }
	public List<RentOrder> queryAllRentPage(String userId){
    	return RentDao.queryAllRentPage(userId);
    }
	public int insertRent(Rent rent){
    	return RentDao.insertRent(rent);
    }
	public int updateRentStatus(Rent rent){
    	return RentDao.updateRentStatus(rent);
    }
	public int updateRentLogisStatus(Rent rent){
//		System.out.print(buyId+"+++!!!!!!!!++"+logisStatus);
    	return RentDao.updateRentLogisStatus(rent);
    }
	public RentOrder queryBackRentById(String rentId){
    	return RentDao.queryBackRentById(rentId);
    }
	public List<RentOrder> queryBackAllRentPage(){
    	return RentDao.queryBackAllRentPage();
    }
}
