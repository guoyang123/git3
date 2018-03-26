package com.neuedu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neuedu.common.MyBatisUtils;
import com.neuedu.dao.UserDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;

public class UserDaoByMybatisImp implements UserDao {

	
	@Override
	public int checkUserName(String username) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Object o=session.selectOne("com.neuedu.entity.User.checkUserName",username);
		if(o instanceof Integer) {
			return (Integer)o;
		}
		return 0;
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,String> map=new HashMap<String,String>();
		map.put("username", username);
		map.put("password",password );
		Object o=session.selectOne("com.neuedu.entity.User.findUserByUserNameAndPassword", map);
		if(o instanceof User) {
			return (User)o;
		}
		return null;
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("token", token);
		map.put("userid",userid );
		int result= session.update("com.neuedu.entity.User.updateTokenByUserId", map);
	//	session.commit();
		MyBatisUtils.close(session);
		return result;
		
		
	}

	@Override
	public User findUserByToken(String token) throws UserDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Object o=session.selectOne("com.neuedu.entity.User.findUserByToken", token);
		if(o instanceof User) {
			return (User)o;
		}
		return null;
	
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<User> list=session.selectList("com.neuedu.entity.User.findAllUser");
		return list;
	}

	@Override
	public PageModel<User> findUserByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		//step1:查询总的记录数-->计算总共多少页
		int totalcount=(Integer)session.selectOne("com.neuedu.entity.User.findTotalCount");
		
		//step2:查询某页面的数据
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pageSize", pageSize);
		List<User> users=session.selectList("com.neuedu.entity.User.findUserbyPage", map);
		
		
		PageModel<User> pageModel=new PageModel<User>();
		pageModel.setTotalPage(((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1));
		pageModel.setData(users);
		
		return pageModel;
	}

	@Override
	public int addUser(User user) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		int  result=session.insert("com.neuedu.entity.User.addUser", user);
		
		session.commit();
		return result;
	}

	@Override
	public int deleteUserById(Integer userid) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int  result=session.delete("com.neuedu.entity.User.deleteByUserid", userid);
		session.close();
		return  result; 
	}

	@Override
	public int addBatchUser(List<User> users) throws UserDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		int  result=session.insert("com.neuedu.entity.User.addBatchUser", users);
		
		session.commit();
		return result;
		
		
	}

	@Override
	public List<User> findUserByForeach(List<Integer> ids) throws UserDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<User> users=session.selectList("com.neuedu.entity.User.findUserByForeach", ids);
		session.close();
		return users;
	}
	
	



	
}
