package com.neuedu.service.impl;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.UserDaoByMybatisImp;
import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;
import com.neuedu.service.IUserService;

public class UserServiceImpl implements IUserService {

	UserDao userDao=new UserDaoByMybatisImp();
	
	@Override
	public User doLogin(String username, String password) throws UserDaoException {
		// TODO Auto-generated method stub
		//step1:��ѯ�û����Ƿ����
		 int result=userDao.checkUserName(username); 
		 User user=null;
		if(result>0) {
			//step2:���û����������ѯ�û���Ϣ
			user= userDao.findByUserNameAndPassword(username, password);
			
		}else {//�û�������
			
		}
	
		return user;
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) throws UserDaoException {
		// TODO Auto-generated method stub
		return userDao.updateTokenByUserId(userid, token);
		
		
	}

	@Override
	public User findUserByToken(String token) throws UserDaoException {
		// TODO Auto-generated method stub
		return userDao.findUserByToken(token);
	}

}
