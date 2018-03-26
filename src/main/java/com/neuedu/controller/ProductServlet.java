package com.neuedu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.consts.Const.ProductOperation;
import com.neuedu.consts.ProductStatusEnum;
import com.neuedu.entity.Cate;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ICateService;
import com.neuedu.service.IProductService;
import com.neuedu.service.impl.CateServiceImpl;
import com.neuedu.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/mng/product/product.do")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation=request.getParameter("operationtype");
		int operationtype=0;
		if(operation!=null) {
			operationtype=Integer.parseInt(operation);
		}
	   IProductService productService=new ProductServiceImpl();
	   ICateService cateService=new CateServiceImpl();
		if(operationtype==ProductOperation.ADDPRODUCT) {//添加商品
			//获取商品状态结集合，返回到添加商品页面
			
			List<Cate> cates=cateService.findAll();
			
			request.setAttribute("cates", cates);
			request.getRequestDispatcher("addproduct.jsp").forward(request, response);;
		}else if(operationtype==ProductOperation.DELETEPRODUCT) {//删除商品
			
		}else if(operationtype==ProductOperation.UPDATEPRODUCT) {//修改商品
			
		}else if(operationtype==ProductOperation.FINDPRODUCT) {//查询商品
			PageModel<Product> pageModel=productService.findProductByPage(request);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("product.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String operation=request.getParameter("operationtype");
		int operationtype=0;
		if(operation!=null) {
			operationtype=Integer.parseInt(operation);
		}
	   IProductService productService=new ProductServiceImpl();
		if(operationtype==ProductOperation.ADDPRODUCT) {//添加商品
			productService.addProduct(request);
			response.sendRedirect("product.do?operationtype=4");
			
		}else if(operationtype==ProductOperation.DELETEPRODUCT) {//删除商品
			
		}else if(operationtype==ProductOperation.UPDATEPRODUCT) {//修改商品
			
		}else if(operationtype==ProductOperation.FINDPRODUCT) {//查询商品
			
		}
	}

}
