package com.yue.dao;

import java.util.List;

import com.yue.model.Buy;

public interface BuyDao {
	//根据ID查
	public Buy queryBuyById(String buyId);
	//分页查询所有
	public List<Buy> queryAllBuyPage();
	//插入
	public int insertBuy(Buy buy);
	//更新
	public int updateBuyStatus(Buy buy);
	//更新
	public int updateBuyLogisStatus(Buy buy);
}
