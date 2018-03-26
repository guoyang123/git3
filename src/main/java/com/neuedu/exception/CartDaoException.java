package com.neuedu.exception;

/**
 * 定义与购物车操作相关的异常；
 * 
 * */
public class CartDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908045266647445685L;

	

	public CartDaoException(String message) {
		super(message);
	}
	
	public CartDaoException() {
		super();
	}
	
	
	
	
}
