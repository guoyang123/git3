package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CartDaoException;

/**
 * ���ﳵ����
 * */
public interface CartDao {

	/**
	 * ����userid��productid��ѯ���ﳵ��Ϣ
	 * @param userid
	 * @param productid
	 * @return Cart���ﳵ����
	 * */
	 Cart  findCartByUserIdAndProductId(Integer userid,Integer productid) throws CartDaoException;
	 /**
	  * ���¹��ﳵ����Ʒ������
	  * @param userid
	  * @param productid
	  * @param quantity ��Ʒ����
	 * @return int
	  * */
	 int updateCartByUserIdAndProductId(Integer userid,Integer productid,int quantity) throws CartDaoException;
	 /**
	  * �û�����Ʒ��ӵ����ﳵ
	  * @param userid
	  * @param productid
	  * @param quantity ��Ʒ����
	 * @return int
	  * */
	 int addProductIntoCartByUserIdAndProductId(Integer userId,Integer productId,int quantity) throws CartDaoException;
     
	 
	 /**
	  * �鿴���ﳵ����Ʒ
	  * @param userid
	  * @param pageNo
	  * @param pageSize
	  * @return pageModel<Cart>
	  * 
	  * */ 
     PageModel<Cart> findCartByPage(Integer userid,Integer pageNo,Integer pageSize) throws CartDaoException;

     
  

    /**
     * �Ƴ����ﳵĳ����Ʒ
     * */ 
     
     int  deleteCartByProductId(Integer userid,Integer productid) throws CartDaoException;
     
     
     /**
      * ѡ��ĳ����Ʒ��ȡ��ĳ����Ʒ��ȫѡ��ȡ��ȫѡ
      * @param userid
      * @param productid
      * @param checked  1:ѡ�� 0��ȡ��ѡ��
      * 
      * */
     int chekedorUncheckedProduct(Integer userid,Integer productid,int checked);
     
      
     
     /**
      * ��ѯĳ�û����ﳵ����ѡ�����Ʒ
      * */
     List<Cart> findCartListByUserid(Integer userid) throws CartDaoException;
     
     
      /**
       * 
       * ɾ���û�ѡ�еĹ��ﳵ�е���Ʒ
       * 
       * */
     int  deleteCheckedProductByUserid(Integer user_id) throws CartDaoException;
     
     /**
      * ���ﳵ����Ʒ������
      * */
     int   getProductTotalCount(int userid)throws CartDaoException;
     
     
     
     
     
}
