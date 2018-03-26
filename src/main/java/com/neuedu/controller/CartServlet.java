package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.neuedu.consts.Const;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.User;
import com.neuedu.entity.vo.CartCheckedVO;
import com.neuedu.entity.vo.CartVO;
import com.neuedu.exception.CartDaoException;
import com.neuedu.service.ICartService;
import com.neuedu.service.impl.CartServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/view/cart.do")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * opertaiontype 
	 * --操作类型  1 添加到购物车
	 *          2 查看购物车
	 *          3 ，修改购物车商品数量
	 *          4 删除购物车
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String callback=request.getParameter("callback");
		//跨域设置
		response.setHeader("Access-Control-Allow-Origin", "*");
		//step1:从回话中获取用户信息
		 HttpSession session=request.getSession();
		
		 Object o=session.getAttribute(Const.CURRENTUSER);
		 User user=null;
		 if(o!=null && o instanceof User) {
			 user=(User)o;
		 }
		if(user==null) {//step2:不存在用户信息，需要登录
		    //response.sendRedirect(this.getServletContext().getInitParameter("hostname")+request.getContextPath()+"/login.jsp");
			CartVO vo=new CartVO();
			vo.setErrno(CartVO.CART__UNLOGIN);
			vo.setMessage("未登录，请登录");
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			 response.getWriter().write(callback+"("+json+")");
			
			return;
		}
		
        String operation=request.getParameter("operationtype");
		
		if(operation==null) {
			throw  new CartDaoException("请求购物车数据必须传递oprationtype参数");
		}
		
		
		ICartService cartSerivce=new CartServiceImpl();
	
		
		if(operation.equals("1")) {//添加
			
			addProductToCart(request,response,cartSerivce,user);
			
		}else if(operation.equals("2")) {//查询
			
			PageModel<Cart> carts=cartSerivce.findCartByPage(user.getId(), request);
			
			CartVO vo=new CartVO();
			vo.setErrno(CartVO.CART_SUCCESS);
			vo.setPageModel(carts);
			
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			System.out.println(json);
			response.getWriter().write(callback+"("+json+")");
			/*request.setAttribute("pageModel", carts);
			request.getRequestDispatcher("cart.jsp").forward(request, response);*/
		}else if(operation.equals("3")) {//获取购物车中商品的总数量
			int totalCount=cartSerivce.getProductTotalCount(user.getId());
			String json="{\"totalCount\":"+totalCount+"}";
			response.getWriter().write(callback+"("+json+")");
		}else if(operation.equals("4")) {//删除购物车中某个商品
			
			
			PageModel<Cart> carts=cartSerivce.deleteCartByProductId(user.getId(),request);
			Gson gson=new Gson();
			String json=gson.toJson(carts);
			System.out.println(json);
			response.getWriter().write(callback+"("+json+")");
		}else if(operation.equals("5")) {//全选、取消全选
			
			CartCheckedVO vo=cartSerivce.chekedorUncheckedProduct(user.getId(),request);
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			System.out.println(json);
			response.getWriter().write(callback+"("+json+")");
			
		}
		
	
	
	}
	/**
	 * 商品添加购物车
	 * */
	public  void  addProductToCart(HttpServletRequest request,HttpServletResponse response,ICartService cartSerivce,User user) throws IOException {
		//step1:从回话中获取用户信息
		cartSerivce.addProductToCart(user.getId(), request);
	} 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
