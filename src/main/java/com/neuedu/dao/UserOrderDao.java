package com.neuedu.dao;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.exception.OrderDaoException;

public interface UserOrderDao {

	/**
	 * 添加订单
	 * @param UserOrder
	 * @param int
	 * */
	int  addOrder(UserOrder userOrder) throws OrderDaoException;
	
	
	
	
	/**
	 * 订单List
	 * */
	
	PageModel<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer pageSize) throws OrderDaoException;
	
	/**
	 * 按订单号查询
	 * @param orderno 订单编号
	 * 
	 * */
	UserOrder findUserOrderDetailByOrderNo(Long orderno) throws OrderDaoException;
	
	/**
	 * 订单发货
	 * @param orderno
	 * */
	int  updateOrderStatusByOrderNo(Long orderno)throws OrderDaoException;
	
	
	
}
