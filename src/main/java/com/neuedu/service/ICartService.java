package com.neuedu.service;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.vo.CartCheckedVO;
import com.neuedu.exception.CartDaoException;

public interface ICartService {

	
	/**
	 * ���ﳵ�������Ʒ
	 * @param userid
	 * @param productid
	 * @param quantity ��Ʒ����
	 * */
	int  addProductToCart(Integer userid,HttpServletRequest request) throws CartDaoException;
	
	
	/**
	 * 
	 * ��ҳ��ѯ���ﳵ����
	 * */
	
	PageModel<Cart> findCartByPage(Integer userid,HttpServletRequest request)throws CartDaoException;
	
	/**
     * ���ﳵ����Ʒ������
     * */
    int   getProductTotalCount(int userid)throws CartDaoException;
    
    /**
     * �Ƴ����ﳵĳ����Ʒ
    * */ 
    
    PageModel<Cart>  deleteCartByProductId(Integer userid,HttpServletRequest request) throws CartDaoException;
    
    /**
     * ѡ��ĳ����Ʒ��ȡ��ĳ����Ʒ��ȫѡ��ȡ��ȫѡ
     * @param userid
     * @param productid
     * @param checked  1:ѡ�� 0��ȡ��ѡ��
     * 
     * */
    CartCheckedVO chekedorUncheckedProduct(Integer userid, HttpServletRequest request);
    
    
    
	
}
