package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.LimitDao;
import com.yue.model.Limit;

@Service
public class LimitService {
	@Autowired
	private LimitDao limitDao;
	public Limit queryLimitById(String limId){
    	return limitDao.queryLimitById(limId);
    }
	public List<Limit> queryAllLimitPage(){
    	return limitDao.queryAllLimitPage();
    }
	public List<Limit> queryAllLimit(){
    	return limitDao.queryAllLimit();
    }
	public int insertLimit(Limit limit){
    	return limitDao.insertLimit(limit);
    }
	public int deleteLimit(String limId){
    	return limitDao.deleteLimit(limId);
    }
	public int updateLimit(Limit limit){
    	return limitDao.updateLimit(limit);
    }
}
