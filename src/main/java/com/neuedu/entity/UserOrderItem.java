package com.neuedu.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ������ϸʵ����
 * */
public class UserOrderItem  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7994169713227569865L;

	
	 private Integer  orderitem_id  ;
	 private Long  order_no;//'�����ţ�����' ,
	 private Integer  user_id;// '�û�id',
	 private Integer product_id;//��ƷId
	 private String  product_name;//'��Ʒ����',
	 private String   product_image ;// '��ƷͼƬ',
	 private BigDecimal  current_unit_price;// '���ɶ���ʱ����Ʒ���,��λԪ,������λС��', 
	 
	 private Integer  quantity ;// '��Ʒ����',
	 private BigDecimal  total_price ;// '��Ʒ�ܼ�,��λԪ,������λС��',
	 private Date  create_time ;//
	 private Date update_time ;//
	public UserOrderItem(Integer id, Long order_no, Integer user_id, String product_name, String product_image,
			BigDecimal current_unit_price, Integer quantity, BigDecimal total_price,
			Date create_time, Date update_time) {
		super();
		this.orderitem_id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.product_name = product_name;
		this.product_image = product_image;
		this.current_unit_price = current_unit_price;
		
		this.quantity = quantity;
		this.total_price = total_price;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public UserOrderItem() {
		super();
	}
	
	
	
	public Integer getOrderitem_id() {
		return orderitem_id;
	}
	public void setOrderitem_id(Integer orderitem_id) {
		this.orderitem_id = orderitem_id;
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	public BigDecimal getCurrent_unit_price() {
		return current_unit_price;
	}
	public void setCurrent_unit_price(BigDecimal current_unit_price) {
		this.current_unit_price = current_unit_price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal_price() {
		return total_price;
	}
	public void setTotal_price(BigDecimal total_price) {
		this.total_price = total_price;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "UserOrderItem [id=" + orderitem_id + ", order_no=" + order_no + ", user_id=" + user_id + ", product_name="
				+ product_name + ", product_image=" + product_image + ", current_unit_price=" + current_unit_price
				+  ", quantity=" + quantity + ", total_price=" + total_price + ", create_time="
				+ create_time + ", update_time=" + update_time + "]";
	}
	 
	 
	 
	 
	
}
