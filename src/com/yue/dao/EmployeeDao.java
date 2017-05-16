package com.yue.dao;

import java.util.List;

import com.yue.model.Employee;
import com.yue.model.EmployeeSearch;

public interface EmployeeDao {
	//根据ID查询
	public EmployeeSearch queryEmployeeById(String empId);
	//根据用户名查询
	public EmployeeSearch queryEmployeeByName(Employee employee);
	//分页查询所有
	public List<EmployeeSearch> queryAllEmployeePage();
	//插入
	public int insertEmployee(Employee employee);	
	//删除
	public int deleteEmployee(String empId);
	//更新
	public int updateEmployee(Employee employee);
}
