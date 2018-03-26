package com.neuedu.exception;

/**
 * 定义与商品操作相关的异常；
 * 
 * */
public class ProductDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908045266647445685L;

	

	public ProductDaoException(String message) {
		super(message);
	}
	
	public ProductDaoException() {
		super();
	}
	
	
	
	
}
