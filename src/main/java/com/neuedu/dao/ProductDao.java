package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.exception.ProductDaoException;

/**
 * 商品CRUD
 * */
public interface ProductDao {

	/**
	 * 添加商品
	 * @param product商品对象
	 * @return  int
	 * */
	int  addProduct(Product product) throws ProductDaoException;
	
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
	PageModel<Product> findProductByPage(Integer pageNo,Integer pageSize)throws ProductDaoException;
	
	/**
	 * 根据商品类别id查询商品，如果没有类别Id,则查询所有的商品
	 * 
	 * */
	List<Product> searchProduct(Integer category_id) throws ProductDaoException;
	
	/**
	 * 根据商品id查询商品库存
	 * */
	Long  getProductStock(Integer product_id) throws ProductDaoException;
	
	
	/**
	 * 
	 * 减少商品库存
	 * */
	
	int  reduceProductStock(Integer product_id,Integer quantity) throws ProductDaoException;
	
}
