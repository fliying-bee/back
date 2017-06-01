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

import com.yue.model.Procure;
import com.yue.model.ProcureOrder;
import com.yue.model.Page;

import com.yue.service.ProcureService;
import com.yue.util.JsonResult;

@Controller
public class ProcureController {
	@Autowired
	private ProcureService ProcureService;
	
//	插入
	@RequestMapping(value="insertProcure")
	@ResponseBody
	public JsonResult<Procure> insertProcure(String procureId,String empId,String facId){
		Procure procure = new Procure();
		procure.setProcureId(procureId);
		procure.setEmpId(empId);
		procure.setFacId(facId);
		//获取当前日期
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String retStrFormatNowDate = sdFormatter.format(nowTime);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date procureTime = new Date(format.parse(retStrFormatNowDate).getTime());
			procure.setProcureTime(procureTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		procure.setProcureStatus("notpay");
		procure.setProcureCount(0);
		procure.setProcurePriceSum(0);
		try{
			int flag= ProcureService.insertProcure(procure);
			if(flag==1){
				return new JsonResult<Procure>(procure);	
			}else{
				Procure error = new Procure();
				JsonResult<Procure> result = new JsonResult<Procure>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Procure>(e);
		}
		
	}


	//后台分页查询所有单
	@RequestMapping(value="queryBackAllProcurePage")
	@ResponseBody
	public JsonResult<Page<ProcureOrder>> queryBackAllProcurePage(int currentPage, int pageSize){
		try{
			List<ProcureOrder> getProcure= ProcureService.queryBackAllProcurePage();
			Page<ProcureOrder> page = new Page<ProcureOrder>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getProcure.size());
			List<ProcureOrder> pageProcure = new ArrayList<ProcureOrder>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageProcure.add(getProcure.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageProcure);
			try{
				return new JsonResult<Page<ProcureOrder>>(page);
			}catch(Exception e){
				return new JsonResult<Page<ProcureOrder>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<ProcureOrder>>(e);
		}
		
	}
//	后台根据购买单编码查询购买单
	@RequestMapping(value="queryBackProcureById")
	@ResponseBody
	public JsonResult<ProcureOrder> queryBackProcureById(String procureId){
		try{
			ProcureOrder getProcure= ProcureService.queryBackProcureById(procureId);
			try{
				return new JsonResult<ProcureOrder>(getProcure);
			}catch(Exception e){
				return new JsonResult<ProcureOrder>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProcureOrder>(e);
		}
		
	}
//	后台根据购买单编码查询购买单
	@RequestMapping(value="queryProcureById")
	@ResponseBody
	public JsonResult<ProcureOrder> queryProcureById(String procureId){
		try{
			ProcureOrder getProcure= ProcureService.queryProcureById(procureId);
			try{
				return new JsonResult<ProcureOrder>(getProcure);
			}catch(Exception e){
				return new JsonResult<ProcureOrder>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProcureOrder>(e);
		}
		
	}
//	修改付款状态
	@RequestMapping(value="updateProcureStatus")
	@ResponseBody
	public JsonResult<Procure> updateProcureStatus(String procureId, String procureStatus){
		Procure procure = new Procure();
		procure.setProcureId(procureId);
		procure.setProcureStatus(procureStatus);
		try{
			int flag= ProcureService.updateProcureStatus(procure);
			if(flag==1){
				return new JsonResult<Procure>(procure);	
			}else{
				Procure error = new Procure();
				JsonResult<Procure> result = new JsonResult<Procure>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Procure>(e);
		}
	}
//	增加商品库存
	@RequestMapping(value="addProcureCount")
	@ResponseBody
	public JsonResult<ProcureOrder> addProductCount(String procureId, int proCount, float proPrice){		
		try{
			ProcureOrder procureOrder = ProcureService.queryProcureById(procureId);
			int oldCount = procureOrder.getProcureCount();
			float oldPrice = procureOrder.getProcurePriceSum();
			procureOrder.setProcureCount(oldCount+proCount);
			procureOrder.setProcurePriceSum(oldPrice+proPrice);
			try{
				int flag= ProcureService.updateProcure(procureOrder);
				if(flag==1){
					return new JsonResult<ProcureOrder>(procureOrder);	
				}else{
					ProcureOrder error = new ProcureOrder();
					JsonResult<ProcureOrder> result = new JsonResult<ProcureOrder>(error);
					result.setCode("Error");
					return result;
				}
			}catch(Exception e){
				e.printStackTrace();
				return new JsonResult<ProcureOrder>(e);
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProcureOrder>(e);
		}
		
	}
}



