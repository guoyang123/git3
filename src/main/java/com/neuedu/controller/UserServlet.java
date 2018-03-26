package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.consts.Const;
import com.neuedu.entity.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置字符编码
	
		 response.setContentType("text/html;charset=UTF-8");
		 //创建回话
		HttpSession session= request.getSession();
		
		 
		/*session.setMaxInactiveInterval(5);*/
		if(session.isNew()) {
			System.out.println("这是一个新的回话");
		}else {
			System.out.println("这是一个已经存在的回话");
		}
		System.out.println("创建时间=="+session.getCreationTime());
		System.out.println("回话id="+session.getId());
		System.out.println("最后一次访问回话的时间="+session.getLastAccessedTime());
		System.out.println("回话超时时间="+session.getMaxInactiveInterval());
		 
		 //获取表单参数
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 if(password!=null) {
			 password=MD5Utils.GetMD5Code(password);
		 }
		 //调用service层的doLogin()
		 IUserService userService= new UserServiceImpl();
		 User user=userService.doLogin(username, password);
		 if(user!=null) {//登录成功   /user/mng/home.jsp
			 
			 //令牌
			 String  token=MD5Utils.GetMD5Code(user.getName()+user.getPassword());
			 Cookie  token_cookie=new Cookie(Const.TOKEN_COOKIE,token);
			 token_cookie.setMaxAge(7*24*3600);
			 token_cookie.setPath(request.getContextPath());
			 response.addCookie(token_cookie);
			 userService.updateTokenByUserId(user.getId(), token);
		
			 //重定向
			session.setAttribute(Const.CURRENTUSER, user);
			
			System.out.println(request.getContextPath());
			 
			 response.sendRedirect("http://localhost:8080/Business/mng/home.jsp");
			
		 }else {//登录失败
			 request.getRequestDispatcher("fail.jsp").forward(request, response);
		 }		 
	}

}
