package com.neuedu.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页模型
 * */
public class PageModel<T> implements Serializable{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = -9078403718410637563L;
	//每一页数据集合
	private  List<T> data;
	//总共有多少页
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
