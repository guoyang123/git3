package com.neuedu.consts;

public enum ProductStatusEnum {

	PRODUCT_ONLINE(1,"在售"),
	PRODUCT_OFFLINE(2,"已下架"),
	PRODUCT_DELETE(3,"已删除"),
	;
	  
	private int status;
	private String msg;
	private ProductStatusEnum(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	 
	
	
}
