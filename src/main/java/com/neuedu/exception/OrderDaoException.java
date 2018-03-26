package com.neuedu.exception;

/**
 * 定义与购物车操作相关的异常；
 * 
 * */
public class OrderDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908045266647445685L;

	

	public OrderDaoException(String message) {
		super(message);
	}
	
	public OrderDaoException() {
		super();
	}
	
	
	
	
}
