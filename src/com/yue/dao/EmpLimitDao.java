package com.yue.dao;

import java.util.List;

import com.yue.model.EmpLimit;

public interface EmpLimitDao {
	//插入
	public int insertEmpLimit(EmpLimit empLimit);
	//删除 
	public int deleteEmpLimit(EmpLimit empLimit);
	//查询所有
	public List<EmpLimit> queryAllEmpLimitById(String empId);
}
