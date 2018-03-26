package com.neuedu.entity.vo;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;

public class CartVO {

	
	public     static final  int  CART_SUCCESS=1;
	public     static final  int  CART__UNLOGIN=0;
	
	private int errno;
	private String  message;
	private  PageModel<Cart> pageModel;
	public int getErrno() {
		return errno;
	}
	public void setErrno(int errno) {
		this.errno = errno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PageModel<Cart> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Cart> pageModel) {
		this.pageModel = pageModel;
	}
	
	
	
}
