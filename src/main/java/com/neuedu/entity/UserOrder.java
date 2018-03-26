package com.neuedu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * ����ʵ����
 * */
public class UserOrder  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8065725774540283848L;

	
	private Integer  id ;//'����id',
	private Long   order_no ;// '�����ţ�Ψһ����' ,
	private  Integer user_id;
	private User    user ;// '�û�id',
	private Integer    shipping_id ;//'��ַid', 
	
	private BigDecimal  payment ;// 'ʵ�ʸ�����,��λԪ,������λС��',
	private Integer    payment_type;// '֧������ 1-����֧�� 2-��������',
	private Integer   postage ;//'�˷�,��λԪ',
	private Integer   status ;//'����״̬  0-��ȡ�� 10-δ���� 20-�Ѹ��� 40-�ѷ��� 50-���׳ɹ� 60-���׹ر�',
	private Date    payment_time ;//'֧��ʱ��',
	private Date    send_time  ;// '����ʱ��',
	private Date    end_time   ;// '�������ʱ��',
	private Date    close_time   ;// '���׹ر�ʱ��',
	private Date create_time;
	private Date    update_time  ;//
	
	private List<UserOrderItem>  orderItems=null;
	
	
	public UserOrder(Integer id, Long order_no, Integer shipping_id, BigDecimal payment,
			Integer payment_type, Integer postage, Integer status, Date payment_time, Date send_time, Date end_time,
			Date close_time, Date update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
	
		this.shipping_id = shipping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.update_time = update_time;
	}
	public UserOrder() {
		super();
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
	
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getShipping_id() {
		return shipping_id;
	}
	public void setShipping_id(Integer shipping_id) {
		this.shipping_id = shipping_id;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public Integer getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}
	public Integer getPostage() {
		return postage;
	}
	public void setPostage(Integer postage) {
		this.postage = postage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getClose_time() {
		return close_time;
	}
	public void setClose_time(Date close_time) {
		this.close_time = close_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	
	public List<UserOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<UserOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", user=" + user
				+ ", shipping_id=" + shipping_id + ", payment=" + payment + ", payment_type=" + payment_type
				+ ", postage=" + postage + ", status=" + status + ", payment_time=" + payment_time + ", send_time="
				+ send_time + ", end_time=" + end_time + ", close_time=" + close_time + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", orderItems=" + orderItems + "]";
	}

	

	
	
	
	
	
	
	
}
