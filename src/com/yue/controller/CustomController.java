package com.yue.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Custom;
import com.yue.model.CustomOrder;
import com.yue.model.Page;
import com.yue.service.CustomService;
import com.yue.util.JsonResult;

@Controller
public class CustomController {
	@Autowired
	private CustomService CustomService;
	
//	修改定制单审核状态
	@RequestMapping(value="updateCustomCheck")
	@ResponseBody
	public JsonResult<Custom> updateCustomCheck(String customId,String customCheck){
		Custom custom = new Custom();
		custom.setCustomId(customId);
		custom.setCustomCheck(customCheck);
		try{
			
			int flag= CustomService.updateCustomCheck(custom);
			if(flag==1){
				return new JsonResult<Custom>(custom);	
			}else{
				Custom error = new Custom();
				JsonResult<Custom> result = new JsonResult<Custom>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Custom>(e);
		}
	}	

//	修改购买单发货状态
	@RequestMapping(value="updateCustomLogisStatus")
	@ResponseBody
	public JsonResult<Custom> updateCustomLogisStatus(String customId,String logisStatus){
		Custom custom = new Custom();
		custom.setCustomId(customId);
		custom.setLogisStatus(logisStatus);
		try{
			
			int flag= CustomService.updateCustomLogisStatus(custom);
			if(flag==1){
				return new JsonResult<Custom>(custom);	
			}else{
				Custom error = new Custom();
				JsonResult<Custom> result = new JsonResult<Custom>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Custom>(e);
		}
	}
	
	//后台分页查询所有购买单
	@RequestMapping(value="queryBackAllCustomPage")
	@ResponseBody
	public JsonResult<Page<CustomOrder>> queryBackAllCustomPage(int currentPage, int pageSize){
		try{
			List<CustomOrder> getCustom= CustomService.queryBackAllCustomPage();
			Page<CustomOrder> page = new Page<CustomOrder>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getCustom.size());
			List<CustomOrder> pageCustom = new ArrayList<CustomOrder>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageCustom.add(getCustom.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageCustom);
			try{
				return new JsonResult<Page<CustomOrder>>(page);
			}catch(Exception e){
				return new JsonResult<Page<CustomOrder>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<CustomOrder>>(e);
		}
		
	}
//	后台根据购买单编码查询购买单
	@RequestMapping(value="queryBackCustomById")
	@ResponseBody
	public JsonResult<CustomOrder> queryBackCustomById(String customId){
		try{
			CustomOrder getCustom= CustomService.queryBackCustomById(customId);
			try{
				return new JsonResult<CustomOrder>(getCustom);
			}catch(Exception e){
				return new JsonResult<CustomOrder>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<CustomOrder>(e);
		}
		
	}
}



