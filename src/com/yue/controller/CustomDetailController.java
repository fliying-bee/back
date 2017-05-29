package com.yue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.CustomDetail;
import com.yue.service.CustomDetailService;
import com.yue.util.JsonResult;

@Controller
public class CustomDetailController {
	@Autowired
	private CustomDetailService customDetailService;
	
//	插入权限
	@RequestMapping(value="insertCustomDetail")
	@ResponseBody
	public JsonResult<CustomDetail> insertCustomDetail(String proId, String customId, String proDetailId,int customDetailCount,String customDetailType){
		CustomDetail customDetail = new CustomDetail();
		customDetail.setCustomDetailCount(customDetailCount);
		customDetail.setCustomDetailType(customDetailType);
		customDetail.setProDetailId(proDetailId);
		customDetail.setCustomId(customId);
		customDetail.setProId(proId);
		try{
			int flag= customDetailService.insertCustomDetail(customDetail);
			if(flag==1){
				return new JsonResult<CustomDetail>(customDetail);	
			}else{
				CustomDetail error = new CustomDetail();
				JsonResult<CustomDetail> result = new JsonResult<CustomDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<CustomDetail>(e);
		}
		
	}
//	删除权限
	@RequestMapping(value="deleteCustomDetail")
	@ResponseBody
	public JsonResult<CustomDetail> deleteCustomDetail(String customId, String proDetailId){
		CustomDetail customDetail = new CustomDetail();
		customDetail.setCustomId(customId);
		customDetail.setProDetailId(proDetailId);
		try{
			int flag= customDetailService.deleteCustomDetail(customDetail);
			if(flag==1){
				return new JsonResult<CustomDetail>(customDetail);	
			}else{
				CustomDetail error = new CustomDetail();
				JsonResult<CustomDetail> result = new JsonResult<CustomDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<CustomDetail>(e);
		}
		
	}
//	修改权限
	@RequestMapping(value="updateCustomDetail")
	@ResponseBody
	public JsonResult<CustomDetail> updateCustomDetail(String customId,String proDetailId, String proId,int customDetailCount,String customDetailType){
		CustomDetail customDetail = new CustomDetail();
		customDetail.setCustomDetailCount(customDetailCount);
		customDetail.setCustomDetailType(customDetailType);
		customDetail.setProDetailId(proDetailId);
		customDetail.setCustomId(customId);
		customDetail.setProId(proId);
		try{
			int flag= customDetailService.updateCustomDetail(customDetail);
			if(flag==1){
				return new JsonResult<CustomDetail>(customDetail);	
			}else{
				CustomDetail error = new CustomDetail();
				JsonResult<CustomDetail> result = new JsonResult<CustomDetail>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<CustomDetail>(e);
		}
	}
}
