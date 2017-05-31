package com.yue.controller;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Rent;
import com.yue.model.RentOrder;
import com.yue.model.Page;
import com.yue.service.RentService;
import com.yue.util.JsonResult;

@Controller
public class RentController {
	@Autowired
	private RentService RentService;
	
	
//	分页查询用户的所有租赁单
	@RequestMapping(value="queryAllRentPage")
	@ResponseBody
	public JsonResult<Page<RentOrder>> queryAllRentPage(int currentPage, int pageSize, String userId){
		try{
			List<RentOrder> getRent= RentService.queryAllRentPage(userId);
			Page<RentOrder> page = new Page<RentOrder>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getRent.size());
			List<RentOrder> pageBuy = new ArrayList<RentOrder>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageBuy.add(getRent.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageBuy);
			try{
				return new JsonResult<Page<RentOrder>>(page);
			}catch(Exception e){
				return new JsonResult<Page<RentOrder>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<RentOrder>>(e);
		}
		
	}

//	根据租赁单编码与用户查询租赁单
	@RequestMapping(value="queryRentById")
	@ResponseBody
	public JsonResult<RentOrder> queryRentById(String rentId, String userId){
		try{
			RentOrder getBuy= RentService.queryRentById(rentId,userId);
			try{
				return new JsonResult<RentOrder>(getBuy);
			}catch(Exception e){
				return new JsonResult<RentOrder>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<RentOrder>(e);
		}
		
	}
	
//	插入租赁单
	@RequestMapping(value="insertRent")
	@ResponseBody
	public JsonResult<Rent> insertBuy(String rentId,float rentPriceSum,String userId, String rentAddr, int rentTime){
		Rent rent = new Rent();
		rent.setRentId(rentId);
		rent.setRentPriceSum(rentPriceSum);
		rent.setUserId(userId);
		rent.setRentAddr(rentAddr);
		rent.setRentTime(rentTime);
		//获取当前日期
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date RentOrderTime = new Date(format.parse(retStrFormatNowDate).getTime());
			rent.setRentOrderTime(RentOrderTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rent.setRentStatus("notpay");
		rent.setLogisStatus("snotsend");
		
		try{
			int flag= RentService.insertRent(rent);
			if(flag==1){
				return new JsonResult<Rent>(rent);	
			}else{
				Rent error = new Rent();
				JsonResult<Rent> result = new JsonResult<Rent>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Rent>(e);
		}
		
	}

//	修改租赁单付款状态
	@RequestMapping(value="updateRentStatus")
	@ResponseBody
	public JsonResult<Rent> updateBuyStatus(String rentId, String rentStatus){
		Rent rent = new Rent();
		rent.setRentId(rentId);
		rent.setRentStatus(rentStatus);
		try{
			int flag= RentService.updateRentStatus(rent);
			if(flag==1){
				return new JsonResult<Rent>(rent);	
			}else{
				Rent error = new Rent();
				JsonResult<Rent> result = new JsonResult<Rent>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Rent>(e);
		}
	}
//	修改租赁单发货状态
	@RequestMapping(value="updateRentLogisStatus")
	@ResponseBody
	public JsonResult<Rent> updateRentLogisStatus(String rentId,String logisStatus){
		Rent rent = new Rent();
		rent.setRentId(rentId);
		rent.setLogisStatus(logisStatus);
		try{
			
			int flag= RentService.updateRentLogisStatus(rent);
			if(flag==1){
				return new JsonResult<Rent>(rent);	
			}else{
				Rent error = new Rent();
				JsonResult<Rent> result = new JsonResult<Rent>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Rent>(e);
		}
	}
	
	//后台分页查询所有租赁单
	@RequestMapping(value="queryBackAllRentPage")
	@ResponseBody
	public JsonResult<Page<RentOrder>> queryBackAllRentPage(int currentPage, int pageSize){
		try{
			List<RentOrder> getRent= RentService.queryBackAllRentPage();
			Page<RentOrder> page = new Page<RentOrder>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getRent.size());
			List<RentOrder> pageRent = new ArrayList<RentOrder>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageRent.add(getRent.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageRent);
			try{
				return new JsonResult<Page<RentOrder>>(page);
			}catch(Exception e){
				return new JsonResult<Page<RentOrder>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<RentOrder>>(e);
		}
		
	}
//	后台根据租赁单编码查询租赁单
	@RequestMapping(value="queryBackRentById")
	@ResponseBody
	public JsonResult<RentOrder> queryBackRentById(String rentId){
		try{
			RentOrder getRent= RentService.queryBackRentById(rentId);
			try{
				return new JsonResult<RentOrder>(getRent);
			}catch(Exception e){
				return new JsonResult<RentOrder>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<RentOrder>(e);
		}
		
	}
}



