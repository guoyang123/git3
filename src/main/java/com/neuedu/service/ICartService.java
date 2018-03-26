package com.neuedu.service;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.vo.CartCheckedVO;
import com.neuedu.exception.CartDaoException;

public interface ICartService {

	
	/**
	 * 购物车中添加商品
	 * @param userid
	 * @param productid
	 * @param quantity 商品数量
	 * */
	int  addProductToCart(Integer userid,HttpServletRequest request) throws CartDaoException;
	
	
	/**
	 * 
	 * 分页查询购物车数据
	 * */
	
	PageModel<Cart> findCartByPage(Integer userid,HttpServletRequest request)throws CartDaoException;
	
	/**
     * 求购物车中商品的数量
     * */
    int   getProductTotalCount(int userid)throws CartDaoException;
    
    /**
     * 移除购物车某个商品
    * */ 
    
    PageModel<Cart>  deleteCartByProductId(Integer userid,HttpServletRequest request) throws CartDaoException;
    
    /**
     * 选中某个商品、取消某个商品、全选、取消全选
     * @param userid
     * @param productid
     * @param checked  1:选中 0：取消选中
     * 
     * */
    CartCheckedVO chekedorUncheckedProduct(Integer userid, HttpServletRequest request);
    
    
    
	
}
