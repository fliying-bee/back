package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.EmpLimitDao;
import com.yue.model.EmpLimit;

@Service
public class EmpLimitService {
	@Autowired
	private EmpLimitDao empLimitdao;
	//插入
	public int insertEmpLimit(EmpLimit empLimit){
    	return empLimitdao.insertEmpLimit(empLimit);
    }
	//删除 
	public int deleteEmpLimit(EmpLimit empLimit){
    	return empLimitdao.deleteEmpLimit(empLimit);
    }
	//查询所有
	public List<EmpLimit> queryAllEmpLimitById(String empId){
    	return empLimitdao.queryAllEmpLimitById(empId);
    }
}
