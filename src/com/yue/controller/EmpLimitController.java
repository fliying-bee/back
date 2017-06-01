package com.yue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.EmpLimit;
import com.yue.service.EmpLimitService;
import com.yue.util.JsonResult;

@Controller
public class EmpLimitController {
	@Autowired
	private EmpLimitService empLimitService;
//	查询所有权限
	@RequestMapping(value="queryAllEmpLimitById")
	@ResponseBody
	public JsonResult<List<EmpLimit>> queryAllEmpLimitById(String empId){
		try{
			List<EmpLimit> getLimit= empLimitService.queryAllEmpLimitById(empId);
			
			try{
				return new JsonResult<List<EmpLimit>>(getLimit);
			}catch(Exception e){
				return new JsonResult<List<EmpLimit>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<EmpLimit>>(e);
		}
		
	}
//	插入员工权限
	@RequestMapping(value="insertEmpLimit")
	@ResponseBody
	public JsonResult<EmpLimit> insertEmpLimit(String empId,String limId){
		EmpLimit empLimit = new EmpLimit();
		empLimit.setEmpId(empId);
		empLimit.setLimId(limId);
		try{
			int flag= empLimitService.insertEmpLimit(empLimit);
			if(flag==1){
				return new JsonResult<EmpLimit>(empLimit);	
			}else{
				EmpLimit error = new EmpLimit();
				JsonResult<EmpLimit> result = new JsonResult<EmpLimit>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<EmpLimit>(e);
		}
		
	}
	
//	删除员工权限
	@RequestMapping(value="deleteEmpLimit")
	@ResponseBody
	public JsonResult<EmpLimit> deleteEmpLimit(String empId,String limId){
		EmpLimit empLimit = new EmpLimit();
		empLimit.setEmpId(empId);
		empLimit.setLimId(limId);
		try{
			int flag= empLimitService.deleteEmpLimit(empLimit);
			if(flag==1){
				return new JsonResult<EmpLimit>(empLimit);	
			}else{
				EmpLimit error = new EmpLimit();
				JsonResult<EmpLimit> result = new JsonResult<EmpLimit>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<EmpLimit>(e);
		}
		
	}
}
