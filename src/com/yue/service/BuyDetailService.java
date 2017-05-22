package com.yue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.BuyDetailDao;
import com.yue.model.BuyDetail;

@Service
public class BuyDetailService {
	@Autowired
	private BuyDetailDao BuyDetailDao;
	
	public int insertBuyDetail(BuyDetail buyDetail){
    	return BuyDetailDao.insertBuyDetail(buyDetail);
    }
	public int deleteBuyDetail(String buyId,String proId){
    	return BuyDetailDao.deleteBuyDetail(buyId,proId);
    }
	public int updateBuyDetail(BuyDetail buyDetail){
    	return BuyDetailDao.updateBuyDetail(buyDetail);
    }
}
