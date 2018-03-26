package com.neuedu.exception;

/**
 * 定义与用户操作相关的异常；
 * 用户登录、注册、找回密码、退出登录...
 * */
public class UserDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908045266647445685L;

	

	public UserDaoException(String message) {
		super(message);
	}
	
	public UserDaoException() {
		super();
	}
	
	
	
	
}
