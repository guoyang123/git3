package com.neuedu.consts;
/**
 * 常量类
 * */
public class Const {

	/**
	 * 当前用户在session中的key值。
	 * */
	 public static final  String CURRENTUSER="user";
	 /**
	  * 用户名cookie
	  * */
	 public static final  String USERNAME_COOKIE="username";
	 /**密码cookie*/
	 public static final  String PASSWORD_COOKIE="password";
	
	 /**token*/
	 public static final  String TOKEN_COOKIE="token";
	
	 
	public interface ProductOperation{
		 int  ADDPRODUCT=1;
		 int  UPDATEPRODUCT=2;
		 int  DELETEPRODUCT=3;
		 int  FINDPRODUCT=4;
	 }
	 
}
