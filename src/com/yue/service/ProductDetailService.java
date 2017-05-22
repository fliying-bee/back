package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.ProductDetailDao;
import com.yue.model.ProductDetail;


@Service
public class ProductDetailService {
	@Autowired
	private ProductDetailDao productDetailDao;
	
	//根据proId查询
	public List<ProductDetail> queryProductDetailByProId(String proId){
    	return productDetailDao.queryProductDetailByProId(proId);
    }
    //插入
    public int insertProductDetail(ProductDetail productDetail){
    	return productDetailDao.insertProductDetail(productDetail);
    }
    //删除
  	public int deleteProductDetail(String proDetailId){
    	return productDetailDao.deleteProductDetail(proDetailId);
    }
  	//更新
  	public int updateProductDetail(ProductDetail productDetail){
    	return productDetailDao.updateProductDetail(productDetail);
    }
   
}
