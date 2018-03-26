package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CartDaoException;

/**
 * 购物车管理
 * */
public interface CartDao {

	/**
	 * 根据userid和productid查询购物车信息
	 * @param userid
	 * @param productid
	 * @return Cart购物车对象
	 * */
	 Cart  findCartByUserIdAndProductId(Integer userid,Integer productid) throws CartDaoException;
	 /**
	  * 更新购物车中商品的数量
	  * @param userid
	  * @param productid
	  * @param quantity 商品数量
	 * @return int
	  * */
	 int updateCartByUserIdAndProductId(Integer userid,Integer productid,int quantity) throws CartDaoException;
	 /**
	  * 用户将商品添加到购物车
	  * @param userid
	  * @param productid
	  * @param quantity 商品数量
	 * @return int
	  * */
	 int addProductIntoCartByUserIdAndProductId(Integer userId,Integer productId,int quantity) throws CartDaoException;
     
	 
	 /**
	  * 查看购物车的商品
	  * @param userid
	  * @param pageNo
	  * @param pageSize
	  * @return pageModel<Cart>
	  * 
	  * */ 
     PageModel<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize) throws CartDaoException;

     
  

    /**
     * 移除购物车某个商品
     * */ 
     
     int  deleteCartByProductId(Integer userid,Integer productid) throws CartDaoException;
     
     
     /**
      * 选中某个商品、取消某个商品、全选、取消全选
      * @param userid
      * @param productid
      * @param checked  1:选中 0：取消选中
      * 
      * */
     int chekedorUncheckedProduct(Integer userid,Integer productid,int checked);
     
      
     
     /**
      * 查询某用户购物车中已选择的商品
      * */
     List<Cart> findCartListByUserid(Integer userid) throws CartDaoException;
     
     
      /**
       * 
       * 删除用户选中的购物车中的商品
       * 
       * */
     int  deleteCheckedProductByUserid(Integer user_id) throws CartDaoException;
     
     /**
      * 求购物车中商品的数量
      * */
     int   getProductTotalCount(int userid)throws CartDaoException;
     
     
     
     
     
}
