package com.yue.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Draft;
import com.yue.model.Page;
import com.yue.service.DraftService;
import com.yue.util.JsonResult;

@Controller
public class DraftController {
	@Autowired
	private DraftService DraftService;
	
	
//	分页查询
	@RequestMapping(value="queryBackAllDraftPage")
	@ResponseBody
	public JsonResult<Page<Draft>> queryBackAllDraftPage(int currentPage, int pageSize){
		try{
			List<Draft> getDraft= DraftService.queryBackAllDraftPage();
			Page<Draft> page = new Page<Draft>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getDraft.size());
			List<Draft> pageDraft = new ArrayList<Draft>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageDraft.add(getDraft.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageDraft);
			try{
				return new JsonResult<Page<Draft>>(page);
			}catch(Exception e){
				return new JsonResult<Page<Draft>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<Draft>>(e);
		}
		
	}

//	根据编码查询
	@RequestMapping(value="queryBackDraftById")
	@ResponseBody
	public JsonResult<Draft> queryBackDraftById(String draId){
		try{
			Draft getDraft= DraftService.queryBackDraftById(draId);
			try{
				return new JsonResult<Draft>(getDraft);
			}catch(Exception e){
				return new JsonResult<Draft>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Draft>(e);
		}
		
	}

//	修改定制单审核状态
//	@RequestMapping(value="updateDraftCheck")
//	@ResponseBody
//	public JsonResult<Draft> updateDraftCheck(String draId,String draCheck){
//		Draft draft = new Draft();
//		draft.setDraId(draId);
//		draft.setDraCheck(draCheck);
//		try{
//			
//			int flag= DraftService.updateDraftCheck(draft);
//			if(flag==1){
//				return new JsonResult<Draft>(draft);	
//			}else{
//				Draft error = new Draft();
//				JsonResult<Draft> result = new JsonResult<Draft>(error);
//				result.setCode("Error");
//				return result;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			return new JsonResult<Draft>(e);
//		}
//	}	

}
