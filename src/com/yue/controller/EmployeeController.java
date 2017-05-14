package com.yue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Employee;
import com.yue.model.User;
import com.yue.service.EmployeeService;
import com.yue.util.JsonResult;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	Employee employee = new Employee();
	
//	登录
	@RequestMapping(value="queryEmployeeByName")
	@ResponseBody
	public JsonResult<Employee> queryEmployeeByName(String empName,String empPassword){
		employee.setEmpName(empName);
		employee.setEmpPassword(empPassword);
		try{
			Employee getEmployee= employeeService.queryEmployeeByName(employee);
			try{
				getEmployee.setEmpPassword("**********");
				return new JsonResult<Employee>(getEmployee);
			}catch(Exception e){
				return new JsonResult<Employee>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Employee>(e);
		}
		
	}
}
