package com.yue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.ProductDetail;
import com.yue.service.ProductDetailService;
import com.yue.util.JsonResult;

@Controller
public class ProductDetailController {
	@Autowired
	private ProductDetailService productDetailService;
	
//	根据商品编码查询商品明细
	@RequestMapping(value="queryProductDetailByProId")
	@ResponseBody
	public JsonResult<List<ProductDetail>> queryProductDetailByProId(String proId){
		try{
			List<ProductDetail> productDetail= productDetailService.queryProductDetailByProId(proId);
			try{
				return new JsonResult<List<ProductDetail>>(productDetail);
			}catch(Exception e){
				return new JsonResult<List<ProductDetail>>(e);
			}		
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<List<ProductDetail>>(e);
		}
		
	}
//	插入权限
	@RequestMapping(value="insertProductDetail")
	@ResponseBody
	public JsonResult<ProductDetail> insertProductDetail(String proDetailId, int proDetailCount,String proDetailType,String proId){
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProDetailCount(proDetailCount);
		productDetail.setProDetailId(proDetailId);
		productDetail.setProDetailType(proDetailType);
		productDetail.setProId(proId);
		try{
			int flag= productDetailService.insertProductDetail(productDetail);
			if(flag==1){
				return new JsonResult<ProductDetail>(productDetail);	
			}else{
				ProductDetail error = new ProductDetail();
				JsonResult<ProductDetail> result = new JsonResult<ProductDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProductDetail>(e);
		}
		
	}
//	删除权限
	@RequestMapping(value="deleteProductDetail")
	@ResponseBody
	public JsonResult<ProductDetail> deleteProductDetail(String proDetailId){
		ProductDetail ProductDetail = new ProductDetail();
		try{
			int flag= productDetailService.deleteProductDetail(proDetailId);
			if(flag==1){
				return new JsonResult<ProductDetail>(ProductDetail);	
			}else{
				ProductDetail error = new ProductDetail();
				JsonResult<ProductDetail> result = new JsonResult<ProductDetail>(error);
				result.setCode("Error");
				return result;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProductDetail>(e);
		}
		
	}
//	修改商品明细
	@RequestMapping(value="updateProductDetail")
	@ResponseBody
	public JsonResult<ProductDetail> updateProductDetail(String proDetailId, int proDetailCount,String proDetailType){
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProDetailCount(proDetailCount);
		productDetail.setProDetailType(proDetailType);
		productDetail.setProDetailId(proDetailId);
		try{
			int flag= productDetailService.updateProductDetail(productDetail);
			if(flag==1){
				return new JsonResult<ProductDetail>(productDetail);	
			}else{
				ProductDetail error = new ProductDetail();
				JsonResult<ProductDetail> result = new JsonResult<ProductDetail>(error);
				result.setCode("Error");
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
			return new JsonResult<ProductDetail>(e);
		}
	}
//	修改商品库存
	@RequestMapping(value="updateProductDetailCount")
	@ResponseBody
	public JsonResult<ProductDetail> updateProductDetailCount(String proDetailId, int proDetailCount,String proDetailType){		
		ProductDetail productDetail = new ProductDetail();
		productDetail.setProDetailId(proDetailId);
		productDetail.setProDetailType(proDetailType);
		try{
			ProductDetail proDetail = productDetailService.queryProductDetailByProDetailId(proDetailId);
			int oldCount = proDetail.getProDetailCount();
			productDetail.setProDetailCount(oldCount-proDetailCount);
			try{
				int flag= productDetailService.updateProductDetail(productDetail);
				if(flag==1){
					return new JsonResult<ProductDetail>(productDetail);	
				}else{
					ProductDetail error = new ProductDetail();
					JsonResult<ProductDetail> result = new JsonResult<ProductDetail>(error);
					result.setCode("Error");
					return result;
				}
			}catch(Exception e){
				e.printStackTrace();
				return new JsonResult<ProductDetail>(e);
			}
		}catch(Exception e){
			return new JsonResult<ProductDetail>(e);
		}
		
	}

}
