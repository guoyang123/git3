package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ��ҳģ��
 * */
public class PageModel<T> implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -9078403718410637563L;
	//ÿһҳ���ݼ���
	private  List<T> data;
	//�ܹ��ж���ҳ
	private  int  totalPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	@Override
	public String toString() {
		return "PageModel [data=" + data + ", totalPage=" + totalPage + "]";
	}

	
	
	
	
}
