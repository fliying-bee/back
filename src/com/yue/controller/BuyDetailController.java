package com.yue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.BuyDetail;
import com.yue.service.BuyDetailService;
import com.yue.util.JsonResult;

@Controller
public class BuyDetailController {
	@Autowired
	private BuyDetailService buyDetailService;
	
//	插入权限
	@RequestMapping(value="insertBuyDetail")
	@ResponseBody
	public JsonResult<BuyDetail> insertBuyDetail(String proId, String buyId, String proDetailId,int buyDetailCount,String buyDetailType){
		BuyDetail buyDetail = new BuyDetail();
		buyDetail.setBuyDetailCount(buyDetailCount);
		buyDetail.setBuyDetailType(buyDetailType);
		buyDetail.setProDetailId(proDetailId);
		buyDetail.setBuyId(buyId);
		buyDetail.setProId(proId);
		try{
			int flag= buyDetailService.insertBuyDetail(buyDetail);
			if(flag==1){
				return new JsonResult<BuyDetail>(buyDetail);	
			}else{
				BuyDetail error = new BuyDetail();
				JsonResult<BuyDetail> result = new JsonResult<BuyDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<BuyDetail>(e);
		}
		
	}
//	删除权限
	@RequestMapping(value="deleteBuyDetail")
	@ResponseBody
	public JsonResult<BuyDetail> deleteBuyDetail(String buyId, String proDetailId){
		BuyDetail buyDetail = new BuyDetail();
		buyDetail.setBuyId(buyId);
		buyDetail.setProDetailId(proDetailId);
		try{
			int flag= buyDetailService.deleteBuyDetail(buyDetail);
			if(flag==1){
				return new JsonResult<BuyDetail>(buyDetail);	
			}else{
				BuyDetail error = new BuyDetail();
				JsonResult<BuyDetail> result = new JsonResult<BuyDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<BuyDetail>(e);
		}
		
	}
//	修改权限
	@RequestMapping(value="updateBuyDetail")
	@ResponseBody
	public JsonResult<BuyDetail> updateBuyDetail(String buyId,String proDetailId, String proId,int buyDetailCount,String buyDetailType){
		BuyDetail buyDetail = new BuyDetail();
		buyDetail.setBuyDetailCount(buyDetailCount);
		buyDetail.setBuyDetailType(buyDetailType);
		buyDetail.setProDetailId(proDetailId);
		buyDetail.setBuyId(buyId);
		buyDetail.setProId(proId);
		try{
			int flag= buyDetailService.updateBuyDetail(buyDetail);
			if(flag==1){
				return new JsonResult<BuyDetail>(buyDetail);	
			}else{
				BuyDetail error = new BuyDetail();
				JsonResult<BuyDetail> result = new JsonResult<BuyDetail>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<BuyDetail>(e);
		}
	}
}
