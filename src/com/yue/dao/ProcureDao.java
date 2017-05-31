package com.yue.dao;

import java.util.List;


import com.yue.model.Procure;
import com.yue.model.ProcureOrder;

public interface ProcureDao {

	//插入
	public int insertProcure(Procure procure);
	//更新
	public int updateProcure(Procure procure);
	//更新
	public int updateProcureStatus(Procure procure);
	//删除
	public int deleteProcure(Procure procure);
	//根据ID查
	public ProcureOrder queryBackProcureById(String ProcureId);
	//分页查询所有
	public List<ProcureOrder> queryBackAllProcurePage();
}
