package com.yue.dao;

import java.util.List;

import com.yue.model.Buy;
import com.yue.model.BuyOrder;

public interface BuyDao {
	//根据ID查
	public BuyOrder queryBuyById(String buyId,String userId);
	//分页查询所有
	public List<BuyOrder> queryAllBuyPage(String userId);
	//插入
	public int insertBuy(Buy buy);
	//更新
	public int updateBuyStatus(Buy buy);
	//更新
	public int updateBuyLogisStatus(Buy buy);
}
