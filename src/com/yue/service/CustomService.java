package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.CustomDao;
import com.yue.model.Custom;
import com.yue.model.CustomOrder;

@Service
public class CustomService {
	@Autowired
	private CustomDao CustomDao;
	
//	public CustomOrder queryCustomById(String customId,String userId){
//    	return CustomDao.queryCustomById(customId,userId);
//    }
//	public List<CustomOrder> queryAllCustomPage(String userId){
//    	return CustomDao.queryAllCustomPage(userId);
//    }
//	public int insertCustom(Custom custom){
//    	return CustomDao.insertCustom(custom);
//    }
//	public int updateCustomStatus(Custom custom){
//    	return CustomDao.updateCustomStatus(custom);
//    }
	
	
	public int updateCustomCheck(Custom custom){
    	return CustomDao.updateCustomCheck(custom);
    }
	public int updateCustomLogisStatus(Custom custom){
    	return CustomDao.updateCustomLogisStatus(custom);
    }
	public CustomOrder queryBackCustomById(String customId){
    	return CustomDao.queryBackCustomById(customId);
    }
	public List<CustomOrder> queryBackAllCustomPage(){
    	return CustomDao.queryBackAllCustomPage();
    }
}
