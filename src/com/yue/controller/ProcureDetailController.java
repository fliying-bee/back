package com.yue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.ProcureDetail;
import com.yue.service.ProcureDetailService;
import com.yue.util.JsonResult;

@Controller
public class ProcureDetailController {
	@Autowired
	private ProcureDetailService procureDetailService;
//	插入
	@RequestMapping(value="insertProcureDetail")
	@ResponseBody
	public JsonResult<ProcureDetail> insertProcureDetail(String proDetailId, int procureDetailCount,String procureDetailType,String procureId,String proId){
		ProcureDetail procureDetail = new ProcureDetail();
		procureDetail.setProcureId(procureId);
		procureDetail.setProcureDetailCount(procureDetailCount);
		procureDetail.setProDetailId(proDetailId);
		procureDetail.setProcureDetailType(procureDetailType);
		procureDetail.setProId(proId);
		try{
			int flag= procureDetailService.insertProcureDetail(procureDetail);
			if(flag==1){
				return new JsonResult<ProcureDetail>(procureDetail);	
			}else{
				ProcureDetail error = new ProcureDetail();
				JsonResult<ProcureDetail> result = new JsonResult<ProcureDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProcureDetail>(e);
		}
		
	}

}
