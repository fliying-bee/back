package com.yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.RentDetailDao;
import com.yue.model.RentDetail;

@Service
public class RentDetailService {
	@Autowired
	private RentDetailDao RentDetailDao;
	
	public int insertRentDetail(RentDetail rentDetail){
    	return RentDetailDao.insertRentDetail(rentDetail);
    }
	public int deleteRentDetail(RentDetail rentDetail){
    	return RentDetailDao.deleteRentDetail(rentDetail);
    }
	public int updateRentDetail(RentDetail rentDetail){
    	return RentDetailDao.updateRentDetail(rentDetail);
    }
}
