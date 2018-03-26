package com.neuedu.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.vo.OrderVO;
import com.neuedu.exception.OrderDaoException;


public interface IOrderService {

	
	/**
	 * 用户下单
	 * @param user_id
	 * @param HttpServletRequest 获取配送地址
	 * */
	Order  createOrder(Integer user_id,HttpServletRequest request) throws OrderDaoException;
	
	/**
	 * 分页查询订单
	 * 
	 * */
	PageModel<OrderVO> findUserOrderByPage(Integer userid,HttpServletRequest request) throws OrderDaoException;
	
}
