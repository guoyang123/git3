package com.neuedu.service;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.exception.ProductDaoException;

public interface IProductService {

	/**
	 * �����Ʒ
	 * @param product��Ʒ����
	 * @return  int
	 * */
	int  addProduct(HttpServletRequest request) throws ProductDaoException;
	
	/**
	 * ��Ʒĳ����Ʒ
	 * @param productid ��Ʒid
	 * @return int 
	 * */
	int  deleteProductById(Integer productid)throws ProductDaoException;
	/**
	 * �޸���Ʒ��Ϣ
	 * @param product
	 * @return int
	 * */
	int updateProductById(Product product)throws ProductDaoException;
	
	/**
	 * ��ѯ������Ʒ
	 * @param productid ��Ʒid 
	 * @return product ��Ʒ����
	 * */
	Product findProductById(Integer productid)throws ProductDaoException;
	/**
	 * ��ҳ��ȡ��Ʒ��Ϣ
	 * @param Integer pageNo
	 * @param Integer pageSize
	 * @return PageModel<Product>
	 * */
	PageModel<Product> findProductByPage(HttpServletRequest request)throws ProductDaoException;
	
	
}
