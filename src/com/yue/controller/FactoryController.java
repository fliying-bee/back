package com.yue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Factory;
import com.yue.model.Page;
import com.yue.service.FactoryService;
import com.yue.util.JsonResult;

@Controller
public class FactoryController {
	@Autowired
	private FactoryService factoryService;
	
	
//	分页查询所有权限
	@RequestMapping(value="queryAllFactoryPage")
	@ResponseBody
	public JsonResult<Page<Factory>> queryAllFactoryPage(int currentPage, int pageSize){
		try{
			List<Factory> getFactory= factoryService.queryAllFactoryPage();
			Page<Factory> page = new Page<Factory>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getFactory.size());
			List<Factory> pageFactory = new ArrayList<Factory>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageFactory.add(getFactory.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageFactory);
			try{
				return new JsonResult<Page<Factory>>(page);
			}catch(Exception e){
				return new JsonResult<Page<Factory>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<Factory>>(e);
		}
		
	}
//	查询所有权限
	@RequestMapping(value="queryAllFactory")
	@ResponseBody
	public JsonResult<List<Factory>> queryAllFactory(){
		try{
			List<Factory> getFactory= factoryService.queryAllFactory();
			
			try{
				return new JsonResult<List<Factory>>(getFactory);
			}catch(Exception e){
				return new JsonResult<List<Factory>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<Factory>>(e);
		}
		
	}
//	根据权限编码查询权限
	@RequestMapping(value="queryFactoryById")
	@ResponseBody
	public JsonResult<Factory> queryFactoryById(String facId){
		try{
			Factory getFactory= factoryService.queryFactoryById(facId);
			try{
				return new JsonResult<Factory>(getFactory);
			}catch(Exception e){
				return new JsonResult<Factory>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Factory>(e);
		}
		
	}
	
//	插入权限
	@RequestMapping(value="insertFactory")
	@ResponseBody
	public JsonResult<Factory> insertFactory(String facId,String facName,String facAddr,String facTel){
		Factory factory = new Factory();
		factory.setFacId(facId);
		factory.setFacName(facName);
		factory.setFacAddr(facAddr);
		factory.setFacTel(facTel);
		System.out.print(facName+"-----");
		try{
			int flag= factoryService.insertFactory(factory);
			if(flag==1){
				return new JsonResult<Factory>(factory);	
			}else{
				Factory error = new Factory();
				JsonResult<Factory> result = new JsonResult<Factory>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Factory>(e);
		}
		
	}
//	删除权限
	@RequestMapping(value="deleteFactory")
	@ResponseBody
	public JsonResult<Factory> deleteFactory(String facId){
		Factory factory = new Factory();
		try{
			int flag= factoryService.deleteFactory(facId);
			if(flag==1){
				return new JsonResult<Factory>(factory);	
			}else{
				Factory error = new Factory();
				JsonResult<Factory> result = new JsonResult<Factory>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Factory>(e);
		}
		
	}
//	修改权限
	@RequestMapping(value="updateFactory")
	@ResponseBody
	public JsonResult<Factory> updateFactory(String facId, String facName, String facAddr, String facTel){
		Factory factory = new Factory();
		factory.setFacId(facId);
		factory.setFacName(facName);
		factory.setFacAddr(facAddr);
		factory.setFacTel(facTel);
		try{
			int flag= factoryService.updateFactory(factory);
			if(flag==1){
				return new JsonResult<Factory>(factory);	
			}else{
				Factory error = new Factory();
				JsonResult<Factory> result = new JsonResult<Factory>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Factory>(e);
		}
	}
}
