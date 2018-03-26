package com.neuedu.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.core.config.Order;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.vo.OrderVO;
import com.neuedu.exception.OrderDaoException;


public interface IOrderService {

	
	/**
	 * �û��µ�
	 * @param user_id
	 * @param HttpServletRequest ��ȡ���͵�ַ
	 * */
	Order  createOrder(Integer user_id,HttpServletRequest request) throws OrderDaoException;
	
	/**
	 * ��ҳ��ѯ����
	 * 
	 * */
	PageModel<OrderVO> findUserOrderByPage(Integer userid,HttpServletRequest request) throws OrderDaoException;
	
}
