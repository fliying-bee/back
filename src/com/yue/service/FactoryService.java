package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.FactoryDao;
import com.yue.model.Factory;

@Service
public class FactoryService {
	@Autowired
	private FactoryDao factoryDao;
	public Factory queryFactoryById(String facId){
    	return factoryDao.queryFactoryById(facId);
    }
	public List<Factory> queryAllFactoryPage(){
    	return factoryDao.queryAllFactoryPage();
    }
	public List<Factory> queryAllFactory(){
    	return factoryDao.queryAllFactory();
    }
	public int insertFactory(Factory factory){
    	return factoryDao.insertFactory(factory);
    }
	public int deleteFactory(String facId){
    	return factoryDao.deleteFactory(facId);
    }
	public int updateFactory(Factory factory){
    	return factoryDao.updateFactory(factory);
    }
}
