package com.neuedu.consts;
/**
 * ������
 * */
public class Const {

	/**
	 * ��ǰ�û���session�е�keyֵ��
	 * */
	 public static final  String CURRENTUSER="user";
	 /**
	  * �û���cookie
	  * */
	 public static final  String USERNAME_COOKIE="username";
	 /**����cookie*/
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
