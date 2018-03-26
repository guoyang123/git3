package com.neuedu.service;

import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;

/**
 * �����û���¼...�Ȳ������߼�����
 * */
public interface IUserService {

	/**
	 * ��¼ҵ���߼��Ĵ���
	 * @param username
	 * @param password
	 * @return user  user!=null,��¼�ɹ�;���򣬵�¼ʧ��
	 *  
	 * */
	public  User  doLogin(String username,String password) throws UserDaoException;
	
	/**
	 * ����userid�����û���token��Ϣ
	 * @param userid
	 * @param token
	 * @return int  >0,���³ɹ������򣬸���ʧ��
	 * */
	public  int  updateTokenByUserId(Integer userid,String token) throws UserDaoException;
	
	
	/**
	 * ����token��ѯ�û���Ϣ
	 * @param token �û�token
	 * @return User
	 * */
	public User findUserByToken(String token) throws UserDaoException;
	
}
