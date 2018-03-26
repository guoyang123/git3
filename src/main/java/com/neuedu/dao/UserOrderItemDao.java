package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;
import com.neuedu.exception.UserOrderItemDaoException;

/**
 * 订单明细Dao
 * 
 * */
public interface UserOrderItemDao {

	
	/**
	 * 批量添加订单明细
	 * */
	int  addBatch(List<UserOrderItem> list) throws UserOrderItemDaoException;
	
	/**
	 * 获取订单的商品信息
	 * */
	List<UserOrderItem> findOrderItemByOrderNo(Integer orderno) throws UserOrderItemDaoException;
}
