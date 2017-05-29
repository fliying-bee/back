package com.yue.dao;

import com.yue.model.CustomDetail;

public interface CustomDetailDao {
	//插入
	public int insertCustomDetail(CustomDetail customDetail);
	//更新
	public int updateCustomDetail(CustomDetail customDetail);
	//删除
	public int deleteCustomDetail(CustomDetail customDetail);
}
