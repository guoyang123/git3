package com.neuedu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neuedu.common.MyBatisUtils;
import com.neuedu.dao.UserOrderDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.exception.OrderDaoException;

public class OrderDaoImpl implements UserOrderDao {

	@Override
	public int addOrder(UserOrder userOrder) throws OrderDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession  session=factory.openSession(false);
		
		int row=session.insert("com.neuedu.entity.UserOrder.addOrder", userOrder);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public PageModel<UserOrder> findUserOrderByPage(Integer userid, Integer pageNo, Integer pageSize)
			throws OrderDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession  session=factory.openSession(false);
		//获取总的记录数
		Integer totalcount=session.selectOne("com.neuedu.entity.UserOrder.findTotalCount", userid);
	
		//分页获取数据
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pagesize", pageSize);
		List<UserOrder> orders=session.selectList("com.neuedu.entity.UserOrder.findUserOrderByPage", map);
		
		PageModel<UserOrder> pageModel=new PageModel<UserOrder>();
		int  totalPage=(totalcount%pageSize==0?totalcount/pageSize:totalcount/pageSize+1);
		pageModel.setTotalPage(totalPage);
		pageModel.setData(orders);
		
		return pageModel;
	}

	@Override
	public UserOrder findUserOrderDetailByOrderNo(Long orderno) throws OrderDaoException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession  session=factory.openSession(false);
		UserOrder userOrder=session.selectOne("com.neuedu.entity.UserOrder.findUserOrderDetailByOrderNo", orderno);
		session.close();
		
		return userOrder;
	}

	@Override
	public int updateOrderStatusByOrderNo(Long orderno) throws OrderDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

}
