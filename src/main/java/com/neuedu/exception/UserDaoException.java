package com.neuedu.exception;

/**
 * �������û�������ص��쳣��
 * �û���¼��ע�ᡢ�һ����롢�˳���¼...
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
