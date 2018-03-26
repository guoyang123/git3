package com.neuedu.entity.vo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.neuedu.consts.OrderStatusEnum;
import com.neuedu.consts.PaymentTypeEnum;
import com.neuedu.entity.User;
import com.neuedu.entity.UserOrder;

/**
 * 
 * vo -->view  Object
 * bo--->business object
 * */
public class OrderVO  {

	
	private Integer  id ;//'订单id',
	private Long   order_no ;// '订单号，唯一索引' ,
	private Integer    user_id ;// '用户id',
	private User  user;
	private Integer    shipping_id ;//'地址id', 
	private String  payment ;// '实际付款金额,单位元,保留两位小数',
	private String    payment_type;// '支付类型 1-在线支付 2-货到付款',
	private Integer   postage ;//'运费,单位元',
	private String   status ;//'订单状态  0-已取消 10-未付款 20-已付款 40-已发货 50-交易成功 60-交易关闭',
	private String    payment_time ;//'支付时间',
	private String    send_time  ;// '发货时间',
	private String    end_time   ;// '交易完成时间',
	private String    close_time   ;// '交易关闭时间',
	private String create_time;
	private String    update_time  ;//
	
	
	
	

	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Long getOrder_no() {
		return order_no;
	}




	public void setOrder_no(Long order_no) {
		this.order_no = order_no;
	}




	public Integer getUser_id() {
		return user_id;
	}




	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}




	public Integer getShipping_id() {
		return shipping_id;
	}




	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}




	public String getPayment() {
		return payment;
	}




	public void setPayment(String payment) {
		this.payment = payment;
	}




	public String getPayment_type() {
		return payment_type;
	}




	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}




	public Integer getPostage() {
		return postage;
	}




	public void setPostage(Integer postage) {
		this.postage = postage;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public String getPayment_time() {
		return payment_time;
	}




	public void setPayment_time(String payment_time) {
		this.payment_time = payment_time;
	}




	public String getSend_time() {
		return send_time;
	}




	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}




	public String getEnd_time() {
		return end_time;
	}




	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}




	public String getClose_time() {
		return close_time;
	}




	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}




	public String getCreate_time() {
		return create_time;
	}




	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}




	public String getUpdate_time() {
		return update_time;
	}




	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}



       /**将UserOrder转成OrderVO*/
	public  void   convertUserOrderToOrderVo(UserOrder userOrder) {
		
		this.id=userOrder.getId();
		this.order_no=userOrder.getOrder_no();
		this.payment=userOrder.getPayment().toString();
		 
		Integer paymenttype=userOrder.getPayment_type();
		if(paymenttype==PaymentTypeEnum.ONLINE.getType()) {//在线支付
			this.payment_type="在线支付";
		}else if(paymenttype==PaymentTypeEnum.OFFLINE.getType()){
			this.payment_type="货到付款";
		}
		
		this.postage=userOrder.getPostage();
		
		Integer status=userOrder.getStatus();
		
		if(status==OrderStatusEnum.CANCEL.getStatus()) {
			this.status="已取消";
		}else if(status==OrderStatusEnum.UNPAY.getStatus()) {
			this.status="未付款";
		}else if(status==OrderStatusEnum.PAY.getStatus()) {
			this.status="已付款";
		}else if(status==OrderStatusEnum.SEND.getStatus()) {
			this.status="已发货";
		}else if(status==OrderStatusEnum.SUCCCESS.getStatus()) {
			this.status="交易成功";
		}else if(status==OrderStatusEnum.CLOSE.getStatus()) {
			this.status="交易关闭";
		}
		
		Date create_time=userOrder.getCreate_time();
		
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.create_time=format.format(create_time.getTime());
		
		this.update_time=format.format(userOrder.getUpdate_time().getTime());
		
		this.user=userOrder.getUser();
	}
	
	
	
	
	
}
