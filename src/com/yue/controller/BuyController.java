package com.yue.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Buy;
import com.yue.model.Page;
import com.yue.service.BuyService;
import com.yue.util.JsonResult;

@Controller
public class BuyController {
	@Autowired
	private BuyService BuyService;
	
	
//	分页查询所有购买单
	@RequestMapping(value="queryAllBuyPage")
	@ResponseBody
	public JsonResult<Page<Buy>> queryAllBuyPage(int currentPage, int pageSize){
		try{
			List<Buy> getBuy= BuyService.queryAllBuyPage();
			Page<Buy> page = new Page<Buy>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getBuy.size());
			List<Buy> pageBuy = new ArrayList<Buy>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageBuy.add(getBuy.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageBuy);
			try{
				return new JsonResult<Page<Buy>>(page);
			}catch(Exception e){
				return new JsonResult<Page<Buy>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<Buy>>(e);
		}
		
	}

//	根据购买单编码查询购买单
	@RequestMapping(value="queryBuyById")
	@ResponseBody
	public JsonResult<Buy> queryBuyById(String limId){
		try{
			Buy getBuy= BuyService.queryBuyById(limId);
			try{
				return new JsonResult<Buy>(getBuy);
			}catch(Exception e){
				return new JsonResult<Buy>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Buy>(e);
		}
		
	}
	
//	插入购买单
	@RequestMapping(value="insertBuy")
	@ResponseBody
	public JsonResult<Buy> insertBuy(String buyId,float buyPriceSum,String userId, String buyAddr){
		Buy buy = new Buy();
		buy.setBuyId(buyId);
		buy.setBuyPriceSum(buyPriceSum);
		buy.setUserId(userId);
		buy.setBuyAddr(buyAddr);
		//获取当前日期
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date buyOrderTime = new Date(format.parse(retStrFormatNowDate).getTime());
			buy.setBuyOrderTime(buyOrderTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		buy.setBuyStatus("notpay");
		buy.setLogisStatus("notsend");
		
		try{
			int flag= BuyService.insertBuy(buy);
			if(flag==1){
				return new JsonResult<Buy>(buy);	
			}else{
				Buy error = new Buy();
				JsonResult<Buy> result = new JsonResult<Buy>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Buy>(e);
		}
		
	}

//	修改购买单付款状态
	@RequestMapping(value="updateBuyStatus")
	@ResponseBody
	public JsonResult<Buy> updateBuyStatus(String buyId, String buyStatus){
		Buy buy = new Buy();
		buy.setBuyId(buyId);
		buy.setBuyStatus(buyStatus);
		try{
			int flag= BuyService.updateBuyStatus(buy);
			if(flag==1){
				return new JsonResult<Buy>(buy);	
			}else{
				Buy error = new Buy();
				JsonResult<Buy> result = new JsonResult<Buy>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Buy>(e);
		}
	}
//	修改购买单发货状态
	@RequestMapping(value="updateBuyLogisStatus")
	@ResponseBody
	public JsonResult<Buy> updateBuyLogisStatus(String buyId, String logisStatus){
		Buy buy = new Buy();
		buy.setBuyId(buyId);
		buy.setLogisStatus(logisStatus);
		try{
			int flag= BuyService.updateBuyLogisStatus(buy);
			if(flag==1){
				return new JsonResult<Buy>(buy);	
			}else{
				Buy error = new Buy();
				JsonResult<Buy> result = new JsonResult<Buy>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Buy>(e);
		}
	}
}
