package com.yue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Limit;
import com.yue.model.Page;
import com.yue.service.LimitService;
import com.yue.util.JsonResult;

@Controller
public class LimitController {
	@Autowired
	private LimitService limitService;
	
	
//	分页查询所有权限
	@RequestMapping(value="queryAllLimitPage")
	@ResponseBody
	public JsonResult<Page<Limit>> queryAllLimitPage(int currentPage, int pageSize){
		try{
			List<Limit> getLimit= limitService.queryAllLimitPage();
			Page<Limit> page = new Page<Limit>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getLimit.size());
			List<Limit> pageLimit = new ArrayList<Limit>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageLimit.add(getLimit.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageLimit);
			try{
				return new JsonResult<Page<Limit>>(page);
			}catch(Exception e){
				return new JsonResult<Page<Limit>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<Limit>>(e);
		}
		
	}
//	查询所有权限
	@RequestMapping(value="queryAllLimit")
	@ResponseBody
	public JsonResult<List<Limit>> queryAllLimit(){
		try{
			List<Limit> getLimit= limitService.queryAllLimit();
			
			try{
				return new JsonResult<List<Limit>>(getLimit);
			}catch(Exception e){
				return new JsonResult<List<Limit>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<Limit>>(e);
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
		Limit limit = new Limit();
		limit.setLimId(limId);
		limit.setLimName(limName);
		limit.setLimDesc(limDesc);
		try{
			int flag= limitService.insertLimit(limit);
			if(flag==1){
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
		Limit limit = new Limit();
		try{
			int flag= limitService.deleteLimit(limId);
			if(flag==1){
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
		Limit limit = new Limit();
		limit.setLimId(limId);
		limit.setLimName(limName);
		limit.setLimDesc(limDesc);
		try{
			int flag= limitService.updateLimit(limit);
			if(flag==1){
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
