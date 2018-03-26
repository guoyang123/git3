package com.neuedu.dao;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.exception.OrderDaoException;

public interface UserOrderDao {

	/**
	 * ��Ӷ���
	 * @param UserOrder
	 * @param int
	 * */
	int  addOrder(UserOrder userOrder) throws OrderDaoException;
	
	
	
	
	/**
	 * ����List
	 * */
	
	PageModel<UserOrder> findUserOrderByPage(Integer userid,Integer pageNo,Integer pageSize) throws OrderDaoException;
	
	/**
	 * �������Ų�ѯ
	 * @param orderno �������
	 * 
	 * */
	UserOrder findUserOrderDetailByOrderNo(Long orderno) throws OrderDaoException;
	
	/**
	 * ��������
	 * @param orderno
	 * */
	int  updateOrderStatusByOrderNo(Long orderno)throws OrderDaoException;
	
	
	
}
