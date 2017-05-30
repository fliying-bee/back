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
//	插入权限
	@RequestMapping(value="insertProduct")
	@ResponseBody
	public JsonResult<Product> insertProduct(String proId,String proName,float proBuyPrice,String proDesc,float proSalePrice,float proSellPrice,String proPicPath,String proType){
		Product product = new Product();
		product.setProBuyPrice(proBuyPrice);
		product.setProCount(0);
		product.setProDesc(proDesc);
		product.setProId(proId);
		product.setProName(proName);
		product.setProPicPath(proPicPath);
		product.setProSalePrice(proSalePrice);
		product.setProSellPrice(proSellPrice);
		product.setProType(proType);
		try{
			int flag= productService.insertProduct(product);
			if(flag==1){
				return new JsonResult<Product>(product);	
			}else{
				Product error = new Product();
				JsonResult<Product> result = new JsonResult<Product>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Product>(e);
		}
		
	}
//	修改商品
	@RequestMapping(value="updateProduct")
	@ResponseBody
	public JsonResult<Product> updateProduct(String proId,String proName,float proBuyPrice,int proCount,String proDesc,float proSalePrice,float proSellPrice,String proPicPath,String proType){
		Product product = new Product();
		product.setProBuyPrice(proBuyPrice);
		product.setProCount(proCount);
		product.setProDesc(proDesc);
		product.setProId(proId);
		product.setProName(proName);
		product.setProPicPath(proPicPath);
		product.setProSalePrice(proSalePrice);
		product.setProSellPrice(proSellPrice);
		product.setProType(proType);
		try{
			int flag= productService.updateProduct(product);
			if(flag==1){
				return new JsonResult<Product>(product);	
			}else{
				Product error = new Product();
				JsonResult<Product> result = new JsonResult<Product>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<Product>(e);
		}
	}
	
//	修改商品库存
	@RequestMapping(value="updateProductCount")
	@ResponseBody
	public JsonResult<Product> updateProductCount(String proId, int proCount){		
		try{
			Product product = productService.queryProductById(proId);
			int oldCount = product.getProCount();
			product.setProCount(oldCount-proCount);
			try{
				int flag= productService.updateProduct(product);
				if(flag==1){
					return new JsonResult<Product>(product);	
				}else{
					Product error = new Product();
					JsonResult<Product> result = new JsonResult<Product>(error);
					result.setCode("Error");
					return result;
				}
			}catch(Exception e){
				e.printStackTrace();
				return new JsonResult<Product>(e);
			}
		}catch(Exception e){
			return new JsonResult<Product>(e);
		}
		
	}

}
