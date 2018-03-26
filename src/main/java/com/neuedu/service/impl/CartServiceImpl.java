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
 * 购物车业务逻辑处理类
 * */
public class CartServiceImpl implements ICartService {

	 CartDao cartDao=new CartDaoImpl();
	@Override
	public int addProductToCart(Integer userid, HttpServletRequest request) throws CartDaoException {
		// TODO Auto-generated method stub
		
	   //step1:productid非空判断
		  String productid=request.getParameter("productid");
		  if(productid==null||productid.equals("")) {
			  throw new CartDaoException("商品加入购物车，必须传入商品id");
		  }
		
		 Integer _productid=0;
		 try {
			 _productid=Integer.parseInt(productid);
		 }catch(NumberFormatException e) {
			 e.printStackTrace();
			 throw  new CartDaoException("商品加入购物车，必须传入数字类型字符串参数");
		 }
		
		String quantity=request.getParameter("quantity");
		 Integer _quantity=0;
		 try {
			 _quantity=Integer.parseInt(quantity);
		 }catch(NumberFormatException e) {
			 e.printStackTrace();
			 throw  new CartDaoException("商品加入购物车，必须传入数字类型字符串参数");
		 }
		 
		//step2:商品是否已经存在购物车中
		  Cart cart=cartDao.findCartByUserIdAndProductId(userid, _productid);
		  if(cart!=null) {
			//step2.1 存在，更新数量
			  int totalQuantity=cart.getQuantity()+_quantity;
			 return  cartDao.updateCartByUserIdAndProductId(userid, _productid, totalQuantity);
		  }else {
			//step2.2 添加
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
			throw new CartDaoException("分页获取购物车商品，PageNo或者pageSize有误！！！");
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
			throw new CartDaoException("删除购物车商品必传递productid");
		}
		
		try {
		 int product_id=Integer.parseInt(productid);
		  cartDao.deleteCartByProductId(userid, product_id);
		  return findCartByPage(userid,request);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("删除购物车商品传递productid格式有误");
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
				throw new CartDaoException("全选/取消全选 商品id传递有误");
			}
			
		}
		
		//checked
		String checked=request.getParameter("checked");
		
		if(checked==null||checked.equals("")) {
			throw new CartDaoException("全选/取消全选 checked参数必传");
		}
		
		Integer _checked=null;
		try {
			_checked=Integer.parseInt(checked);
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw new CartDaoException("全选/取消全选 checked参数值有误");
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
