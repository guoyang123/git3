package com.neuedu.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neuedu.common.MyBatisUtils;
import com.neuedu.dao.UserOrderItemDao;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.exception.UserOrderItemDaoException;

/**
 * ¶©µ¥Ã÷Ï¸CRUD
 * */
public class UserOrderItemDaoImpl implements UserOrderItemDao {

	@Override
	public int addBatch(List<UserOrderItem> list) throws UserOrderItemDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		int row=session.insert("com.neuedu.entity.UserOrderItem.addBatch", list);
		session.commit();
		session.close();
		return row;
	}

	@Override
	public List<UserOrderItem> findOrderItemByOrderNo(Integer orderno) throws UserOrderItemDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
