package com.yue.dao;

import java.util.List;

import com.yue.model.Factory;

public interface FactoryDao {
	//根据ID查
	public Factory queryFactoryById(String facId);
	//分页查询所有
	public List<Factory> queryAllFactoryPage();
	//查询所有
	public List<Factory> queryAllFactory();
	//插入
	public int insertFactory(Factory factory);
	//删除
	public int deleteFactory(String factory);
	//更新
	public int updateFactory(Factory factory);
}
