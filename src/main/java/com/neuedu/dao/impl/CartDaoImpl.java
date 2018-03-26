package com.neuedu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neuedu.common.MyBatisUtils;
import com.neuedu.dao.CartDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CartDaoException;

/**
 * 
 * 购物车实现类
 * */
public class CartDaoImpl implements CartDao {

	@Override
	public Cart findCartByUserIdAndProductId(Integer userid, Integer productid) throws CartDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer>  map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		
		Cart cart=session.selectOne("com.neuedu.entity.Cart.findCartByUserIdAndProductId", map);
		session.close();
		return cart;
	}

	@Override
	public int updateCartByUserIdAndProductId(Integer userid, Integer productid, int quantity) throws CartDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer>  map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("quantity", quantity);
		int result=session.update("com.neuedu.entity.Cart.updateCartByProductId", map);
		session.close();
		
		
		return result;
	}

	@Override
	public int addProductIntoCartByUserIdAndProductId(Integer userId, Integer productId, int quantity)
			throws CartDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer>  map=new HashMap<String,Integer>();
		map.put("userid", userId);
		map.put("productid", productId);
		map.put("quantity", quantity);
		int result=session.insert("com.neuedu.entity.Cart.addProductIntoCartByUserIdAndProductId", map);
		session.close();
		
		
		return result;
	}

	@Override
	public PageModel<Cart> findCartByPage(Integer userid, Integer pageNo, Integer pageSize) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("offset", (pageNo-1)*pageSize);
		map.put("pagesize", pageSize);
		PageModel<Cart>  pageModel=null;
		//总的记录数
		Integer totalcount=(Integer)session.selectOne("com.neuedu.entity.Cart.findTotalCount",userid);
	   if(totalcount>0) {
		   pageModel=new PageModel<Cart>();
		   List<Cart> list=session.selectList("com.neuedu.entity.Cart.findCartByPage", map); 
		   int totalPage=(totalcount%pageSize==0?totalcount/pageSize:(totalcount/pageSize)+1);
			pageModel.setTotalPage(totalPage);
			pageModel.setData(list);
	   }
		
		session.close();
		return pageModel;
	}



	@Override
	public int deleteCartByProductId(Integer userid, Integer productid) throws CartDaoException {
		// TODO Auto-generated method stub
		
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer>  map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		
		int result=session.update("com.neuedu.entity.Cart.deleteCartByProductId", map);
		session.close();
		
		
		return result;
		
	
	}

	@Override
	public int chekedorUncheckedProduct(Integer userid, Integer productid, int checked) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer>  map=new HashMap<String,Integer>();
		map.put("userid", userid);
		map.put("productid", productid);
		map.put("checked", checked);
		int result=session.update("com.neuedu.entity.Cart.chekedorUncheckedProduct", map);
		
		
		session.close();
		return result;
	}

	@Override
	public List<Cart> findCartListByUserid(Integer userid) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<Cart> carts=session.selectList("com.neuedu.entity.Cart.findCartListByUserid", userid);
		session.close();
		return carts;
	}

	@Override
	public int deleteCheckedProductByUserid(Integer user_id) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		int row=session.delete("com.neuedu.entity.Cart.deleteCheckedProductByUserid", user_id);
		session.commit();
		session.close();
		
		return row;
	}

	@Override
	public int getProductTotalCount(int userid) throws CartDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
	     
		int row=session.selectOne("com.neuedu.entity.Cart.getProductTotalCount", userid);
		 session.close();
		return row;
	}

}
