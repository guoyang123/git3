package com.neuedu.service;

import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;

/**
 * 定义用户登录...等操作的逻辑处理
 * */
public interface IUserService {

	/**
	 * 登录业务逻辑的处理
	 * @param username
	 * @param password
	 * @return user  user!=null,登录成功;否则，登录失败
	 *  
	 * */
	public  User  doLogin(String username,String password) throws UserDaoException;
	
	/**
	 * 根据userid更新用户的token信息
	 * @param userid
	 * @param token
	 * @return int  >0,更新成功；否则，更新失败
	 * */
	public  int  updateTokenByUserId(Integer userid,String token) throws UserDaoException;
	
	
	/**
	 * 根据token查询用户信息
	 * @param token 用户token
	 * @return User
	 * */
	public User findUserByToken(String token) throws UserDaoException;
	
}
