package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.BuyDao;
import com.yue.model.Buy;
import com.yue.model.BuyOrder;

@Service
public class BuyService {
	@Autowired
	private BuyDao BuyDao;
	
	public BuyOrder queryBuyById(String buyId,String userId){
    	return BuyDao.queryBuyById(buyId,userId);
    }
	public List<BuyOrder> queryAllBuyPage(String userId){
    	return BuyDao.queryAllBuyPage(userId);
    }
	public int insertBuy(Buy buy){
    	return BuyDao.insertBuy(buy);
    }
	public int updateBuyStatus(Buy buy){
    	return BuyDao.updateBuyStatus(buy);
    }
	public int updateBuyLogisStatus(Buy buy){
//		System.out.print(buyId+"+++!!!!!!!!++"+logisStatus);
    	return BuyDao.updateBuyLogisStatus(buy);
    }
	public BuyOrder queryBackBuyById(String buyId){
    	return BuyDao.queryBackBuyById(buyId);
    }
	public List<BuyOrder> queryBackAllBuyPage(){
    	return BuyDao.queryBackAllBuyPage();
    }
}
