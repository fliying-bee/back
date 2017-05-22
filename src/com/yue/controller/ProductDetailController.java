package com.yue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yue.model.ProductDetail;
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
//	修改权限
//	@RequestMapping(value="updateProductDetail")
//	@ResponseBody
//	public JsonResult<ProductDetail> updateProductDetail(String proDetailId, int proDetailCount,String proDetailType,String proId){
//		ProductDetail ProductDetail = new ProductDetail();
//		ProductDetail.setProDetailCount(proDetailCount);
//		ProductDetail.setProDetailType(proDetailType);
//		ProductDetail.setProDetailId(proDetailId);
//		ProductDetail.setProId(proId);
//		try{
//			int flag= ProductDetailService.updateProductDetail(ProductDetail);
//			if(flag==1){
//				return new JsonResult<ProductDetail>(ProductDetail);	
//			}else{
//				ProductDetail error = new ProductDetail();
//				JsonResult<ProductDetail> result = new JsonResult<ProductDetail>(error);
//				result.setCode("Error");
//				return result;
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			return new JsonResult<ProductDetail>(e);
//		}
//	}

}
