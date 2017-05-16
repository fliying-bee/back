package com.yue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Employee;
import com.yue.model.EmployeeSearch;
import com.yue.model.Page;
import com.yue.service.EmployeeService;
import com.yue.util.JsonResult;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	
//	登录
	@RequestMapping(value="queryEmployeeByName")
	@ResponseBody
	public JsonResult<EmployeeSearch> queryEmployeeByName(String empName,String empPassword){
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpPassword(empPassword);
		try{
			EmployeeSearch getEmployee = employeeService.queryEmployeeByName(employee);
			try{
				getEmployee.setEmpPassword("**********");
				return new JsonResult<EmployeeSearch>(getEmployee);
			}catch(Exception e){
				return new JsonResult<EmployeeSearch>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<EmployeeSearch>(e);
		}
		
	}
	
//	查询所有员工
	@RequestMapping(value="queryAllEmployeePage")
	@ResponseBody
	public JsonResult<Page<EmployeeSearch>> queryAllEmployeePage(int currentPage, int pageSize){
		try{
			List<EmployeeSearch> getEmployee= employeeService.queryAllEmployeePage();
			Page<EmployeeSearch> page = new Page<EmployeeSearch>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getEmployee.size());
			List<EmployeeSearch> employee = new ArrayList<EmployeeSearch>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					employee.add(getEmployee.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(employee);
			try{
				return new JsonResult<Page<EmployeeSearch>>(page);
			}catch(Exception e){
				return new JsonResult<Page<EmployeeSearch>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<EmployeeSearch>>(e);
		}
		
	}
//	插入员工
	@RequestMapping(value="insertEmployee")
	@ResponseBody
	public JsonResult<Employee> insertEmployee(String empId,String empName,String empPassword,String empSex,String empTel){
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setEmpPassword(empPassword);
		employee.setEmpSex(empSex);
		employee.setEmpTel(empTel);
		try{
			int flag= employeeService.insertEmployee(employee);
			if(flag==1){
				return new JsonResult<Employee>(employee);	
			}else{
				Employee error = new Employee();
				JsonResult<Employee> result = new JsonResult<Employee>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Employee>(e);
		}
		
	}

//	删除员工
	@RequestMapping(value="deleteEmployee")
	@ResponseBody
	public JsonResult<Employee> deleteEmployee(String empId){
		Employee employee = new Employee();
		try{
			int flag= employeeService.deleteEmployee(empId);
			if(flag==1){
				return new JsonResult<Employee>(employee);	
			}else{
				Employee error = new Employee();
				JsonResult<Employee> result = new JsonResult<Employee>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Employee>(e);
		}
		
	}
//	修改员工
	@RequestMapping(value="updateEmployee")
	@ResponseBody
	public JsonResult<Employee> updateEmployee(String empId,String empName,String empPassword,String empSex,String empTel){
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setEmpPassword(empPassword);
		employee.setEmpSex(empSex);
		employee.setEmpTel(empTel);
		try{
			int flag= employeeService.updateEmployee(employee);
			if(flag==1){
				return new JsonResult<Employee>(employee);	
			}else{
				Employee error = new Employee();
				JsonResult<Employee> result = new JsonResult<Employee>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Employee>(e);
		}
	}


}
