package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.BuyDao;
import com.yue.model.Buy;

@Service
public class BuyService {
	@Autowired
	private BuyDao BuyDao;
	
	public Buy queryBuyById(String buyId){
    	return BuyDao.queryBuyById(buyId);
    }
	public List<Buy> queryAllBuyPage(){
    	return BuyDao.queryAllBuyPage();
    }
	public int insertBuy(Buy buy){
    	return BuyDao.insertBuy(buy);
    }
	public int updateBuyStatus(Buy buy){
    	return BuyDao.updateBuyStatus(buy);
    }
	public int updateBuyLogisStatus(Buy buy){
    	return BuyDao.updateBuyStatus(buy);
    }
}
