package com.yue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yue.dao.ProductDao;
import com.yue.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	//根据Id查询
	public Product queryProductById(String proId){
    	return productDao.queryProductById(proId);
    }
    //分页根据类型查询
    public List<Product> queryProductPageByType(String proType){
    	return productDao.queryProductPageByType(proType);
    }
    //插入
    public int insertProduct(Product product){
    	return productDao.insertProduct(product);
    }
    //删除
  	public int deleteProduct(String proId){
    	return productDao.deleteProduct(proId);
    }
  	//更新
  	public int updateProduct(Product product){
    	return productDao.updateProduct(product);
    }
  //查询
  	public List<Product> queryProduct(){
      	return productDao.queryProduct();
      }
   
}
