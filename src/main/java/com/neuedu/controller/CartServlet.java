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
	 * --��������  1 ��ӵ����ﳵ
	 *          2 �鿴���ﳵ
	 *          3 ���޸Ĺ��ﳵ��Ʒ����
	 *          4 ɾ�����ﳵ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String callback=request.getParameter("callback");
		//��������
		response.setHeader("Access-Control-Allow-Origin", "*");
		//step1:�ӻػ��л�ȡ�û���Ϣ
		 HttpSession session=request.getSession();
		
		 Object o=session.getAttribute(Const.CURRENTUSER);
		 User user=null;
		 if(o!=null && o instanceof User) {
			 user=(User)o;
		 }
		if(user==null) {//step2:�������û���Ϣ����Ҫ��¼
		    //response.sendRedirect(this.getServletContext().getInitParameter("hostname")+request.getContextPath()+"/login.jsp");
			CartVO vo=new CartVO();
			vo.setErrno(CartVO.CART__UNLOGIN);
			vo.setMessage("δ��¼�����¼");
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			 response.getWriter().write(callback+"("+json+")");
			
			return;
		}
		
        String operation=request.getParameter("operationtype");
		
		if(operation==null) {
			throw  new CartDaoException("�����ﳵ���ݱ��봫��oprationtype����");
		}
		
		
		ICartService cartSerivce=new CartServiceImpl();
	
		
		if(operation.equals("1")) {//���
			
			addProductToCart(request,response,cartSerivce,user);
			
		}else if(operation.equals("2")) {//��ѯ
			
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
		}else if(operation.equals("3")) {//��ȡ���ﳵ����Ʒ��������
			int totalCount=cartSerivce.getProductTotalCount(user.getId());
			String json="{\"totalCount\":"+totalCount+"}";
			response.getWriter().write(callback+"("+json+")");
		}else if(operation.equals("4")) {//ɾ�����ﳵ��ĳ����Ʒ
			
			
			PageModel<Cart> carts=cartSerivce.deleteCartByProductId(user.getId(),request);
			Gson gson=new Gson();
			String json=gson.toJson(carts);
			System.out.println(json);
			response.getWriter().write(callback+"("+json+")");
		}else if(operation.equals("5")) {//ȫѡ��ȡ��ȫѡ
			
			CartCheckedVO vo=cartSerivce.chekedorUncheckedProduct(user.getId(),request);
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			System.out.println(json);
			response.getWriter().write(callback+"("+json+")");
			
		}
		
	
	
	}
	/**
	 * ��Ʒ��ӹ��ﳵ
	 * */
	public  void  addProductToCart(HttpServletRequest request,HttpServletResponse response,ICartService cartSerivce,User user) throws IOException {
		//step1:�ӻػ��л�ȡ�û���Ϣ
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
