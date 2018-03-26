package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.service.ICartService;
import com.neuedu.service.impl.CartServiceImpl;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/json.do")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//跨域设置
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		System.out.println("==================JsonServlet========");
		PrintWriter pw=response.getWriter(); //10s
		// {"name":"zhangsan","age":20}
		String person="{\"name\":\"zhang\",\"age\":20}";
		
		ICartService cartService=new CartServiceImpl();
		
		PageModel<Cart> carts=cartService.findCartByPage(2, request);
		//对象转json字符串
		Gson gson=new Gson();
		String  result=gson.toJson(carts);
		
		
		/*System.out.println(result);
		result="{\"url\":\"http://127.0.0.1:8020/Js_01/test.html\"}";*/
		String callback=request.getParameter("callback");
		pw.write(callback+"("+result+")");
		
		//response.sendRedirect("http://127.0.0.1:8020/Js_01/test.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
