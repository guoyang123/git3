package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cate;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CateDaoException;

/**
 * 类别CRUD
 * */
public interface CateDao {

   /**
   * 添加类别
   * @param cate 商品类别对象
   * @return int
   * */
	int  addCate(Cate cate) throws CateDaoException;
	/**
	 * 删除类别
	 * @param cateid 商品类别id
	 * @return int
	 * 
	 * */
	int deleteCateById(Integer cateid) throws CateDaoException;
   
	/**
	 * 修改类别
	 * @param cate商品类别对象
	 * @return int 
	 * */
	int  updateCate(Cate cate) throws CateDaoException;
	/**
	 * 分页查询类别
	 * @param pageNo 页码
	 * @param pageSize 数量
	 * 
	 * */
	PageModel<Cate> findCateByPage(Integer pageNo,Integer pageSize)throws CateDaoException;
	/**
	 * 查询单个类别信息
	 * @param cateid 类别id
	 * @return Cate 商品类别信息
	 * */
	Cate findCateById(Integer cateid) throws CateDaoException;
	
	/**
	 * 查询所有类别
	 * */
	List<Cate> findAll()throws CateDaoException;
	
	
}
