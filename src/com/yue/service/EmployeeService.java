package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.EmployeeDao;
import com.yue.model.Employee;
import com.yue.model.EmployeeSearch;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeedao;
	//根据用户名查询
    public EmployeeSearch queryEmployeeByName(Employee employee){
    	return employeedao.queryEmployeeByName(employee);
    }
    //分页查询所有
    public List<EmployeeSearch> queryAllEmployeePage(){
    	return employeedao.queryAllEmployeePage();
    }
    //插入
    public int insertEmployee(Employee employee){
    	return employeedao.insertEmployee(employee);
    }
    //删除
  	public int deleteEmployee(String empId){
    	return employeedao.deleteEmployee(empId);
    }
  	//更新
  	public int updateEmployee(Employee employee){
    	return employeedao.updateEmployee(employee);
    }
   
}
