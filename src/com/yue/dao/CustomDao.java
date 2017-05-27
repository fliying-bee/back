package com.yue.dao;

import java.util.List;

import com.yue.model.Custom;
import com.yue.model.CustomOrder;

public interface CustomDao {
//	//根据ID查
//	public CustomOrder queryCustomById(String customId,String userId);
//	//分页查询所有
//	public List<CustomOrder> queryAllCustomPage(String userId);
//	//插入
//	public int insertCustom(Custom custom);
//	//更新
//	public int updateCustomStatus(Custom custom);
	
	//更新
	public int updateCustomCheck(Custom custom);
	//更新
	public int updateCustomLogisStatus(Custom custom);
	//根据ID查
	public CustomOrder queryBackCustomById(String customId);
	//分页查询所有
	public List<CustomOrder> queryBackAllCustomPage();
}
