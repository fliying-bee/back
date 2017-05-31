package com.yue.dao;

import com.yue.model.ProcureDetail;

public interface ProcureDetailDao {
	//插入
	public int insertProcureDetail(ProcureDetail ProcureDetail);
	//更新
	public int updateProcureDetail(ProcureDetail ProcureDetail);
	//删除
	public int deleteProcureDetail(ProcureDetail ProcureDetail);
}
