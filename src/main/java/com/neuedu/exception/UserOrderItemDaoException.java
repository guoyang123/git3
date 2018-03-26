package com.neuedu.exception;

/**
 * 定义与购物车操作相关的异常；
 * 
 * */
public class UserOrderItemDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908045266647445685L;

	

	public UserOrderItemDaoException(String message) {
		super(message);
	}
	
	public UserOrderItemDaoException() {
		super();
	}
	
	
	
	
}
