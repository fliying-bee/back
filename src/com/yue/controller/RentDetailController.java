package com.yue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.RentDetail;
import com.yue.service.RentDetailService;
import com.yue.util.JsonResult;

@Controller
public class RentDetailController {
	@Autowired
	private RentDetailService rentDetailService;
	
//	插入权限
	@RequestMapping(value="insertRentDetail")
	@ResponseBody
	public JsonResult<RentDetail> insertRentDetail(String proId, String rentId, String proDetailId,int rentDetailCount,String rentDetailType){
		RentDetail rentDetail = new RentDetail();
		rentDetail.setRentDetailCount(rentDetailCount);
		rentDetail.setRentDetailType(rentDetailType);
		rentDetail.setProDetailId(proDetailId);
		rentDetail.setRentId(rentId);
		rentDetail.setProId(proId);
		try{
			int flag= rentDetailService.insertRentDetail(rentDetail);
			if(flag==1){
				return new JsonResult<RentDetail>(rentDetail);	
			}else{
				RentDetail error = new RentDetail();
				JsonResult<RentDetail> result = new JsonResult<RentDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<RentDetail>(e);
		}
		
	}
//	删除权限
	@RequestMapping(value="deleteRentDetail")
	@ResponseBody
	public JsonResult<RentDetail> deleteRentDetail(String rentId, String proDetailId){
		RentDetail rentDetail = new RentDetail();
		rentDetail.setRentId(rentId);
		rentDetail.setProDetailId(proDetailId);
		try{
			int flag= rentDetailService.deleteRentDetail(rentDetail);
			if(flag==1){
				return new JsonResult<RentDetail>(rentDetail);	
			}else{
				RentDetail error = new RentDetail();
				JsonResult<RentDetail> result = new JsonResult<RentDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<RentDetail>(e);
		}
		
	}
//	修改权限
	@RequestMapping(value="updateRentDetail")
	@ResponseBody
	public JsonResult<RentDetail> updateRentDetail(String rentId,String proDetailId, String proId,int rentDetailCount,String rentDetailType){
		RentDetail rentDetail = new RentDetail();
		rentDetail.setRentDetailCount(rentDetailCount);
		rentDetail.setRentDetailType(rentDetailType);
		rentDetail.setProDetailId(proDetailId);
		rentDetail.setRentId(rentId);
		rentDetail.setProId(proId);
		try{
			int flag= rentDetailService.updateRentDetail(rentDetail);
			if(flag==1){
				return new JsonResult<RentDetail>(rentDetail);	
			}else{
				RentDetail error = new RentDetail();
				JsonResult<RentDetail> result = new JsonResult<RentDetail>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<RentDetail>(e);
		}
	}
}
