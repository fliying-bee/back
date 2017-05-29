package com.yue.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
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
//	分页查询用户的所有租赁单
	@RequestMapping(value="queryAllCustomPage")
	@ResponseBody
	public JsonResult<Page<CustomOrder>> queryAllCustomPage(int currentPage, int pageSize, String userId){
		try{
			List<CustomOrder> getCustom= CustomService.queryAllCustomPage(userId);
			Page<CustomOrder> page = new Page<CustomOrder>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getCustom.size());
			List<CustomOrder> pageBuy = new ArrayList<CustomOrder>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageBuy.add(getCustom.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageBuy);
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

//	根据租赁单编码与用户查询租赁单
	@RequestMapping(value="queryCustomById")
	@ResponseBody
	public JsonResult<CustomOrder> queryCustomById(String CustomId, String userId){
		try{
			CustomOrder getBuy= CustomService.queryCustomById(CustomId,userId);
			try{
				return new JsonResult<CustomOrder>(getBuy);
			}catch(Exception e){
				return new JsonResult<CustomOrder>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<CustomOrder>(e);
		}
		
	}
	
//	插入租赁单
	@RequestMapping(value="insertCustom")
	@ResponseBody
	public JsonResult<Custom> insertBuy(String customId,float customPriceSum,String userId, String customAddr, String customMsg){
		Custom custom = new Custom();
		custom.setCustomId(customId);
		custom.setCustomPriceSum(customPriceSum);
		custom.setUserId(userId);
		custom.setCustomAddr(customAddr);
		custom.setCustomMsg(customMsg);
		//获取当前日期
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date CustomOrderTime = new Date(format.parse(retStrFormatNowDate).getTime());
			custom.setCustomOrderTime(CustomOrderTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		custom.setCustomStatus("notpay");
		custom.setLogisStatus("notsend");
		custom.setCustomCheck("notcheck");
		
		try{
			int flag= CustomService.insertCustom(custom);
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

//	修改租赁单付款状态
	@RequestMapping(value="updateCustomStatus")
	@ResponseBody
	public JsonResult<Custom> updateBuyStatus(String customId, String customStatus){
		Custom custom = new Custom();
		custom.setCustomId(customId);
		custom.setCustomStatus(customStatus);
		try{
			int flag= CustomService.updateCustomStatus(custom);
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
}



