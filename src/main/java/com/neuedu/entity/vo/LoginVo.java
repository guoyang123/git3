package com.neuedu.entity.vo;

import java.io.Serializable;

import com.neuedu.entity.User;

/**
 *  ��¼�󽫵�¼��Ϣ����ǰ��
 * */
public class LoginVo  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8446129929821159093L;
	
	public static  final  int  LOGIN_SUCC=1;
	public static  final  int  LOGIN_FAIL=0;
	
	/**
	 * 1:�ɹ�
	 * 0:ʧ��
	 * 
	 * */
	private  int  errno;
	private  String message;//ʧ����Ϣ
	private  User user;
	
	
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
