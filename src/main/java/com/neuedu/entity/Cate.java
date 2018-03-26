package com.neuedu.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ���ʵ����
 * */
public class Cate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5160682708552853482L;
	private int  id;//����
    private int parent_id;//�����id,��parent_id=0ʱ˵���Ǹ��ڵ�,һ�����
    private String name;//��Ʒ����
    private int status;//���״̬1-����,2-�Ѿ�����
    private int sort_order;//������,ͬ��չʾ˳��,��ֵ�������Ȼ����
    private Date create_time;
    private Date update_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getSort_order() {
		return sort_order;
	}
	public void setSort_order(int sort_order) {
		this.sort_order = sort_order;
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
	@Override
	public String toString() {
		return "Cate [id=" + id + ", parent_id=" + parent_id + ", name=" + name + ", status=" + status + ", sort_order="
				+ sort_order + ", create_time=" + create_time + ", update_time=" + update_time + "]";
	}
	 
    
}
