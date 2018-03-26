package com.neuedu.service;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.exception.ProductDaoException;

public interface IProductService {

	/**
	 * 添加商品
	 * @param product商品对象
	 * @return  int
	 * */
	int  addProduct(HttpServletRequest request) throws ProductDaoException;
	
	/**
	 * 商品某件商品
	 * @param productid 商品id
	 * @return int 
	 * */
	int  deleteProductById(Integer productid)throws ProductDaoException;
	/**
	 * 修改商品信息
	 * @param product
	 * @return int
	 * */
	int updateProductById(Product product)throws ProductDaoException;
	
	/**
	 * 查询单个商品
	 * @param productid 商品id 
	 * @return product 商品对象
	 * */
	Product findProductById(Integer productid)throws ProductDaoException;
	/**
	 * 分页获取商品信息
	 * @param Integer pageNo
	 * @param Integer pageSize
	 * @return PageModel<Product>
	 * */
	PageModel<Product> findProductByPage(HttpServletRequest request)throws ProductDaoException;
	
	
}
