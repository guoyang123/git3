package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;

/**购物车实体类*/
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9111198434631125133L;
	private  int  id; //主键
	//private int user_id;//用户id
	private  User user;
	private int product_id;//商品id
	private int quantity;//商品数量
	private int checked;//是否被选择 1:已选择 0：未选中
	private Date create_time;
	private Date update_time;
	public Cart(int id, int product_id, int quantity, int checked, Date create_time, Date update_time) {
		super();
		this.id = id;
		
		this.product_id = product_id;
		this.quantity = quantity;
		this.checked = checked;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	public Cart() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getChecked() {
		return checked;
	}
	public void setChecked(int checked) {
		this.checked = checked;
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
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", product_id=" + product_id + ", quantity=" + quantity
				+ ", checked=" + checked + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	
	
	
	
	
}
