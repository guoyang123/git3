package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.consts.Const;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.User;
import com.neuedu.entity.UserOrder;
import com.neuedu.entity.vo.OrderVO;
import com.neuedu.exception.OrderDaoException;
import com.neuedu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/view/order.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session= request.getSession();
		Object o=session.getAttribute(Const.CURRENTUSER);
		User user=null;
		if(o!=null && o instanceof User) {
			user=(User)o;
		}
		
		if(user==null) {
			response.sendRedirect(this.getServletContext().getInitParameter("hostname")+request.getContextPath()+"/login.jsp");
		   return;
		}
		
		// 1:下单 2：分页获取订单  
		String operationtype=request.getParameter("operationtype");
		if(operationtype==null||operationtype.equals("")) {
			throw  new OrderDaoException("operationtype参数必传");
		}
		  OrderServiceImpl orderService=new OrderServiceImpl();
		if(operationtype.equals("1")) {//下单
          
			orderService.createOrder(user.getId(), request);
		}else if(operationtype.equals("2")) {//分页获取
			
			PageModel<OrderVO> pageModel=orderService.findUserOrderByPage(user.getId(), request);
			request.setAttribute("pageModel", pageModel);
			request.getRequestDispatcher("order.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
