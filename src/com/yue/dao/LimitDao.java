package com.yue.dao;

import java.util.List;

import com.yue.model.Limit;

public interface LimitDao {
	//根据ID查
	public Limit queryLimitById(String limId);
	//查询所有
	public List queryAllLimit();
	//插入
	public Integer insertLimit(Limit limit);
	//删除
	public Integer deleteLimit(String limId);
	//更新
	public Integer updateLimit(Limit limit);
}
