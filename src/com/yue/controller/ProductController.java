package com.yue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.Product;
import com.yue.model.Page;
import com.yue.service.ProductService;
import com.yue.util.JsonResult;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
//	分页根据类型查询商品
	@RequestMapping(value="queryProductPageByType")
	@ResponseBody
	public JsonResult<Page<Product>> queryProductPageByType(int currentPage, int pageSize,String proType){
		try{
			List<Product> getProduct= productService.queryProductPageByType(proType);
			Page<Product> page = new Page<Product>();
			page.setCurrentPage(currentPage);
			page.setPageSize(pageSize);
			page.setTotalRow(getProduct.size());
			List<Product> pageProduct = new ArrayList<Product>();
			int start = (page.getCurrentPage()-1)*page.getPageSize();
			int end = start + page.getPageSize();
			for(int i=start;i<end;i++){
				try{
					pageProduct.add(getProduct.get(i));
				}catch(Exception e){
					
				}
			}
			page.setList(pageProduct);
			try{
				return new JsonResult<Page<Product>>(page);
			}catch(Exception e){
				return new JsonResult<Page<Product>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Page<Product>>(e);
		}
		
	}
	
//	根据权限编码查询商品
	@RequestMapping(value="queryProductById")
	@ResponseBody
	public JsonResult<Product> queryProductById(String proId){
		try{
			Product getProduct= productService.queryProductById(proId);
			try{
				return new JsonResult<Product>(getProduct);
			}catch(Exception e){
				return new JsonResult<Product>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Product>(e);
		}
		
	}

}
