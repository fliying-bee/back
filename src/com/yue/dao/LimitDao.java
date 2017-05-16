package com.yue.dao;

import java.util.List;

import com.yue.model.Limit;

public interface LimitDao {
	//根据ID查
	public Limit queryLimitById(String limId);
	//分页查询所有
	public List<Limit> queryAllLimitPage();
	//查询所有
	public List<Limit> queryAllLimit();
	//插入
	public int insertLimit(Limit limit);
	//删除
	public int deleteLimit(String limId);
	//更新
	public int updateLimit(Limit limit);
}
