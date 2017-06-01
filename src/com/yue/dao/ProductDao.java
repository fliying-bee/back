package com.yue.dao;

import java.util.List;

import com.yue.model.Product;

public interface ProductDao {
	//根据ID查询
	public Product queryProductById(String proId);
	//分页根据类型查询
	public List<Product> queryProductPageByType(String proType);
	//插入
	public int insertProduct(Product product);	
	//删除
	public int deleteProduct(String proId);
	//更新
	public int updateProduct(Product product);
	//根据ID查询
	public List<Product> queryProduct();
}
