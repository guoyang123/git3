package com.neuedu.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.CartDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.vo.CartCheckedVO;
import com.neuedu.exception.CartDaoException;
import com.neuedu.service.ICartService;

/**
 * ���ﳵҵ���߼�������
 * */
public class CartServiceImpl implements ICartService {

	 CartDao cartDao=new CartDaoImpl();
	@Override
	public int addProductToCart(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		
	   //step1:productid�ǿ��ж�
		  String productid=request.getParameter("productid");
		  if(productid==null||productid.equals("")) {
			  throw new CartDaoException("��Ʒ���빺�ﳵ�����봫����Ʒid");
		  }
		
		 Integer _productid=0;
		 try {
			 _productid=Integer.parseInt(productid);
		 }catch(NumberFormatException e) {
			 e.printStackTrace();
			 throw  new CartDaoException("��Ʒ���빺�ﳵ�����봫�����������ַ�������");
		 }
		
		String quantity=request.getParameter("quantity");
		 Integer _quantity=0;
		 try {
			 _quantity=Integer.parseInt(quantity);
		 }catch(NumberFormatException e) {
			 e.printStackTrace();
			 throw  new CartDaoException("��Ʒ���빺�ﳵ�����봫�����������ַ�������");
		 }
		 
		//step2:��Ʒ�Ƿ��Ѿ����ڹ��ﳵ��
		  Cart cart=cartDao.findCartByUserIdAndProductId(userid, _productid);
		  if(cart!=null) {
			//step2.1 ���ڣ���������
			  int totalQuantity=cart.getQuantity()+_quantity;
			 return  cartDao.updateCartByUserIdAndProductId(userid, _productid, totalQuantity);
		  }else {
			//step2.2 ���
			return  cartDao.addProductIntoCartByUserIdAndProductId(userid, _productid, _quantity); 
		  }
		  
		
		
		
	}
	
	@Override
	public PageModel<Cart> findCartByPage(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		Integer _pageNo=1;
		Integer _pageSize=5;
		
		try {
		if(pageNo!=null) {
			_pageNo=Integer.parseInt(pageNo);
		}	
		if(pageSize!=null) {
			_pageSize=Integer.parseInt(pageSize);
		}
		
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("��ҳ��ȡ���ﳵ��Ʒ��PageNo����pageSize���󣡣���");
		}
		
		return cartDao.findCartByPage(userid, _pageNo, _pageSize);
		
	}

	@Override
	public int getProductTotalCount(int userid) throws CartDaoException {
		// TODO Auto-generated method stub
		return cartDao.getProductTotalCount(userid);
	}

	@Override
	public PageModel<Cart> deleteCartByProductId(Integer userid,HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		
		String productid=request.getParameter("product_id");
		if(productid==null||productid.equals("")) {
			throw new CartDaoException("ɾ�����ﳵ��Ʒ�ش���productid");
		}
		
		try {
		 int product_id=Integer.parseInt(productid);
		  cartDao.deleteCartByProductId(userid, product_id);
		  return findCartByPage(userid,request);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("ɾ�����ﳵ��Ʒ����productid��ʽ����");
		}
		
		
		
	}

	@Override
	public CartCheckedVO chekedorUncheckedProduct(Integer userid, HttpServletRequest request) {
		// TODO Auto-generated method stub
		CartCheckedVO vo=new CartCheckedVO();
		//product_id
		String product_id=request.getParameter("product_id");
		
		Integer productid=null;
		if(product_id!=null&&product_id.equals("")) {
			try {
				productid=Integer.parseInt(product_id);
			}catch(NumberFormatException e) {
				e.printStackTrace();
				throw new CartDaoException("ȫѡ/ȡ��ȫѡ ��Ʒid��������");
			}
			
		}
		
		//checked
		String checked=request.getParameter("checked");
		
		if(checked==null||checked.equals("")) {
			throw new CartDaoException("ȫѡ/ȡ��ȫѡ checked�����ش�");
		}
		
		Integer _checked=null;
		try {
			_checked=Integer.parseInt(checked);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("ȫѡ/ȡ��ȫѡ checked����ֵ����");
		}
		
		int  row=cartDao.chekedorUncheckedProduct(userid, productid, _checked);
		
		if(row>0) {
			vo.setErrno(CartCheckedVO.ERRNO_SUCCESS);
			vo.setProduct_id(productid);
			vo.setChecked(_checked);
		}
		
		return vo;
	}


	

}
