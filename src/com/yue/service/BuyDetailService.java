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
	public int deleteBuyDetail(BuyDetail buyDetail){
    	return BuyDetailDao.deleteBuyDetail(buyDetail);
    }
	public int updateBuyDetail(BuyDetail buyDetail){
    	return BuyDetailDao.updateBuyDetail(buyDetail);
    }
}
