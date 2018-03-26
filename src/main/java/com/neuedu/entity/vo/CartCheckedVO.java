package com.neuedu.entity.vo;

import java.io.Serializable;

public class CartCheckedVO  implements Serializable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 2032865742071290132L;
	/**
	 * erron 1:成功
	 *       0:出错了
	 * */
	
	public  static  final  Integer ERRNO_SUCCESS=1;
	public  static  final  Integer ERRNO_FAIL=0;
	
	private Integer errno;
	/**错误信息*/
	private  String message;
	
	//商品id
	 private  Integer product_id;
	 //是否选中 1:选中 0：未选中
	 private Integer checked;
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	
	public Integer getErrno() {
		return errno;
	}
	public void setErrno(Integer errno) {
		this.errno = errno;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "CartCheckedVO [product_id=" + product_id + ", checked=" + checked + "]";
	}
	
	 
	 
	 
	 
}
