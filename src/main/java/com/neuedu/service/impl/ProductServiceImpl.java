package com.neuedu.service.impl;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import com.neuedu.dao.ProductDao;
import com.neuedu.dao.impl.ProductDaoImpl;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.exception.ProductDaoException;
import com.neuedu.service.IProductService;
/**
 * 商品业务逻辑处理类
 * */
public class ProductServiceImpl implements IProductService {

	ProductDao productDao=new ProductDaoImpl();
	
	@Override
	public int addProduct(HttpServletRequest request) throws ProductDaoException {
		// TODO Auto-generated method stub
		String category_id=request.getParameter("category_id");
		String name=request.getParameter("name");
		String subtitle=request.getParameter("subtitle");
		String main_image=request.getParameter("main_image");
		String detail=request.getParameter("detail");
		String price=request.getParameter("price");
		String stock=request.getParameter("stock");
		String status=request.getParameter("status");
		
		Product product=new Product(Integer.parseInt(category_id),
				name,subtitle,main_image,detail,new BigDecimal(price),
				Integer.parseInt(stock),Integer.parseInt(status));
		
	
		
		
		return productDao.addProduct(product);
	}

	@Override
	public int deleteProductById(Integer productid) throws ProductDaoException {
		// TODO Auto-generated method stub
		return productDao.deleteProductById(productid);
	}

	@Override
	public int updateProductById(Product product) throws ProductDaoException {
		// TODO Auto-generated method stub
		return productDao.updateProductById(product);
	}

	@Override
	public Product findProductById(Integer productid) throws ProductDaoException {
		// TODO Auto-generated method stub
		return productDao.findProductById(productid);
	}

	@Override
	public PageModel<Product> findProductByPage(HttpServletRequest request) throws ProductDaoException {
		// TODO Auto-generated method stub
		String pageNo=request.getParameter("pageNo");
		String pageSize=request.getParameter("pageSize");
		if(pageNo==null) {
			pageNo="1";
		}
		if(pageSize==null) {
			pageSize="10";
		}
		
		Integer _pageNo=Integer.parseInt(pageNo);
		Integer _pageSize=Integer.parseInt(pageSize);
		
		return productDao.findProductByPage(_pageNo, _pageSize);
	}

}
