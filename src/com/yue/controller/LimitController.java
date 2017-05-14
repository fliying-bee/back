package com.yue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Employee;
import com.yue.model.Limit;
import com.yue.model.User;
import com.yue.service.LimitService;
import com.yue.util.JsonResult;

@Controller
public class LimitController {
	@Autowired
	private LimitService limitService;
	Limit limit = new Limit();
	
//	查询所有权限
	@RequestMapping(value="queryAllLimit")
	@ResponseBody
	public JsonResult<List> queryAllLimit(){
		try{
			List getLimit= limitService.queryAllLimit();
			try{
				return new JsonResult<List>(getLimit);
			}catch(Exception e){
				return new JsonResult<List>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List>(e);
		}
		
	}
//	根据权限编码查询权限
	@RequestMapping(value="queryLimitById")
	@ResponseBody
	public JsonResult<Limit> queryLimitById(String limId){
		try{
			Limit getLimit= limitService.queryLimitById(limId);
			try{
				return new JsonResult<Limit>(getLimit);
			}catch(Exception e){
				return new JsonResult<Limit>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Limit>(e);
		}
		
	}
	
//	插入权限
	@RequestMapping(value="insertLimit")
	@ResponseBody
	public JsonResult<Limit> insertLimit(String limId,String limName,String limDesc){
		limit.setLimId(limId);
		limit.setLimName(limName);
		limit.setLimDesc(limDesc);
		try{
			Integer setLimit= limitService.insertLimit(limit);
			if(setLimit==1){
				return new JsonResult<Limit>(limit);	
			}else{
				Limit error = new Limit();
				JsonResult<Limit> result = new JsonResult<Limit>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Limit>(e);
		}
		
	}
//	删除权限
	@RequestMapping(value="deleteLimit")
	@ResponseBody
	public JsonResult<Limit> deleteLimit(String limId){
		try{
			Integer setLimit= limitService.deleteLimit(limId);
			if(setLimit==1){
				return new JsonResult<Limit>(limit);	
			}else{
				Limit error = new Limit();
				JsonResult<Limit> result = new JsonResult<Limit>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Limit>(e);
		}
		
	}
//	修改权限
	@RequestMapping(value="updateLimit")
	@ResponseBody
	public JsonResult<Limit> updateLimit(String limId, String limName, String limDesc){
		limit.setLimId(limId);
		limit.setLimName(limName);
		limit.setLimDesc(limDesc);
		try{
			Integer setLimit= limitService.updateLimit(limit);
			if(setLimit==1){
				return new JsonResult<Limit>(limit);	
			}else{
				Limit error = new Limit();
				JsonResult<Limit> result = new JsonResult<Limit>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Limit>(e);
		}
	}
}
