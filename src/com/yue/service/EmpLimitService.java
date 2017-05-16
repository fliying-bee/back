package com.yue.service;

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
	public int deleteEmpLimit(String empId){
    	return empLimitdao.deleteEmpLimit(empId);
    }
}
