package com.yue.dao;

import com.yue.model.BuyDetail;

public interface BuyDetailDao {
	//插入
	public int insertBuyDetail(BuyDetail buyDetail);
	//更新
	public int updateBuyDetail(BuyDetail buyDetail);
	//删除
	public int deleteBuyDetail(BuyDetail buyDetail);
}
