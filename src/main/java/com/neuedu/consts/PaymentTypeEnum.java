package com.neuedu.consts;

public enum PaymentTypeEnum {

	 ONLINE(1,"在线支付"),
	 OFFLINE(2,"货到付款");
	
	private int type;
	private String msg;
	private PaymentTypeEnum(int status, String msg) {
		this.type = status;
		this.msg = msg;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	 
	
}
