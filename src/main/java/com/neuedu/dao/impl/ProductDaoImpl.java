package com.neuedu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.neuedu.common.MyBatisUtils;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cate;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.exception.ProductDaoException;

public class ProductDaoImpl implements ProductDao {

	@Override
	public int addProduct(Product product) throws ProductDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.insert("com.neuedu.entity.Product.addProduct", product);
	     session.close();
		return result;
	}

	@Override
	public int deleteProductById(Integer productid) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		
		int result=session.insert("com.neuedu.entity.Product.deleteProductById", productid);
	     session.close();
		return result;
	}

	@Override
	public int updateProductById(Product product) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.update("com.neuedu.entity.Product.updateProduct", product);
	     session.close();
		return result;
	}

	@Override
	public Product findProductById(Integer productid) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Product pro=session.selectOne("com.neuedu.entity.Product.findProductById",productid);
		session.close();
		return pro;
	}

	@Override
	public PageModel<Product> findProductByPage(Integer pageNo, Integer pageSize) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		
		Integer totalcount=session.selectOne("com.neuedu.entity.Product.findTotalCount");
	     Map<String,Integer> map=new HashMap<String,Integer>();
	     map.put("offSet", (pageNo-1)*pageSize);
	     map.put("pageSize",pageSize);
		List<Product> list=session.selectList("com.neuedu.entity.Product.findProductByPage", map);
    
		 PageModel<Product> pageModel=new PageModel<>();
		 pageModel.setTotalPage(((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1));
		 pageModel.setData(list);
		return pageModel;
	}

	@Override
	public List<Product> searchProduct(Integer category_id) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Map<String,Integer> map=new HashMap<String,Integer>();
		//map.put("category_id", category_id);
	  List<Product> list=session.selectList("com.neuedu.entity.Product.searchProduct", category_id);
		
		
		session.close();
		
		return list;
	}

	@Override
	public Long getProductStock(Integer product_id) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		Long row=(Long)session.selectOne("com.neuedu.entity.Product.getProductStock",product_id);
		session.close();
		return row;
	}

	@Override
	public int reduceProductStock(Integer product_id, Integer quantity) throws ProductDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("quantity", quantity);
		map.put("productid", product_id);
		int row=session.update("com.neuedu.entity.Product.reduceProductStock", map);
		session.commit();
		session.close();
		
		return row;
	}

}
