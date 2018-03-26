package com.neuedu.exception;

/**
 * 定义与商品类别操作相关的异常；
 * 
 * */
public class CateDaoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4908045266647445685L;

	

	public CateDaoException(String message) {
		super(message);
	}
	
	public CateDaoException() {
		super();
	}
	
	
	
	
}
