package com.yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.CustomDetailDao;
import com.yue.model.CustomDetail;

@Service
public class CustomDetailService {
	@Autowired
	private CustomDetailDao customDetailDao;
	
	public int insertCustomDetail(CustomDetail customDetail){
    	return customDetailDao.insertCustomDetail(customDetail);
    }
	public int deleteCustomDetail(CustomDetail customDetail){
    	return customDetailDao.deleteCustomDetail(customDetail);
    }
	public int updateCustomDetail(CustomDetail customDetail){
    	return customDetailDao.updateCustomDetail(customDetail);
    }
}
