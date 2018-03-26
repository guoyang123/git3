package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.exception.ProductDaoException;

/**
 * ��ƷCRUD
 * */
public interface ProductDao {

	/**
	 * �����Ʒ
	 * @param product��Ʒ����
	 * @return  int
	 * */
	int  addProduct(Product product) throws ProductDaoException;
	
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
	PageModel<Product> findProductByPage(Integer pageNo,Integer pageSize)throws ProductDaoException;
	
	/**
	 * ������Ʒ���id��ѯ��Ʒ�����û�����Id,���ѯ���е���Ʒ
	 * 
	 * */
	List<Product> searchProduct(Integer category_id) throws ProductDaoException;
	
	/**
	 * ������Ʒid��ѯ��Ʒ���
	 * */
	Long  getProductStock(Integer product_id) throws ProductDaoException;
	
	
	/**
	 * 
	 * ������Ʒ���
	 * */
	
	int  reduceProductStock(Integer product_id,Integer quantity) throws ProductDaoException;
	
}
