package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cate;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CateDaoException;

/**
 * ���CRUD
 * */
public interface CateDao {

   /**
   * ������
   * @param cate ��Ʒ������
   * @return int
   * */
	int  addCate(Cate cate) throws CateDaoException;
	/**
	 * ɾ�����
	 * @param cateid ��Ʒ���id
	 * @return int
	 * 
	 * */
	int deleteCateById(Integer cateid) throws CateDaoException;
   
	/**
	 * �޸����
	 * @param cate��Ʒ������
	 * @return int 
	 * */
	int  updateCate(Cate cate) throws CateDaoException;
	/**
	 * ��ҳ��ѯ���
	 * @param pageNo ҳ��
	 * @param pageSize ����
	 * 
	 * */
	PageModel<Cate> findCateByPage(Integer pageNo,Integer pageSize)throws CateDaoException;
	/**
	 * ��ѯ���������Ϣ
	 * @param cateid ���id
	 * @return Cate ��Ʒ�����Ϣ
	 * */
	Cate findCateById(Integer cateid) throws CateDaoException;
	
	/**
	 * ��ѯ�������
	 * */
	List<Cate> findAll()throws CateDaoException;
	
	
}
