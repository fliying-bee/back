package com.yue.controller;

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
	public JsonResult<EmpLimit> deleteEmpLimit(String empId){
		EmpLimit empLimit = new EmpLimit();
		try{
			int flag= empLimitService.deleteEmpLimit(empId);
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
