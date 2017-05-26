package com.yue.dao;

import java.util.List;

import com.yue.model.ProductDetail;

public interface ProductDetailDao {
	//根据proId查询
	public List<ProductDetail> queryProductDetailByProId(String proId);
	//根据proId查询
	public ProductDetail queryProductDetailByProDetailId(String proDetailId);
	//插入
	public int insertProductDetail(ProductDetail productDetail);	
	//删除
	public int deleteProductDetail(String proDetailId);
	//更新
	public int updateProductDetail(ProductDetail productDetail);
}
