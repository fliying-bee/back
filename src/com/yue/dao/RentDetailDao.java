package com.yue.dao;

import com.yue.model.RentDetail;

public interface RentDetailDao {
	//插入
	public int insertRentDetail(RentDetail rentDetail);
	//更新
	public int updateRentDetail(RentDetail rentDetail);
	//删除
	public int deleteRentDetail(RentDetail rentDetail);
}
