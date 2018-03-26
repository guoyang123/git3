package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.UserOrderItem;
import com.neuedu.exception.UserOrderItemDaoException;

/**
 * ������ϸDao
 * 
 * */
public interface UserOrderItemDao {

	
	/**
	 * ������Ӷ�����ϸ
	 * */
	int  addBatch(List<UserOrderItem> list) throws UserOrderItemDaoException;
	
	/**
	 * ��ȡ��������Ʒ��Ϣ
	 * */
	List<UserOrderItem> findOrderItemByOrderNo(Integer orderno) throws UserOrderItemDaoException;
}
