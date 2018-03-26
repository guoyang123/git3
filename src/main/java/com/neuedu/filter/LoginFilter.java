package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.consts.Const;
import com.neuedu.entity.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/mng/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

    private void init() {
		// TODO Auto-generated method stub

	}
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest)_request;
		HttpServletResponse response=(HttpServletResponse)_response;
		HttpSession session=request.getSession();
		//step1://判断用户token是否存在	
		 String token=null;
			Cookie[] cookies=request.getCookies();
			if(cookies!=null) {
				for(Cookie c:cookies) {
					if(c.getName().equals(Const.TOKEN_COOKIE)) {
						token=c.getValue();
					}
					
				}
			}
			
		 if(token!=null) {
			 
			 //调用service层的findUserByToken()
			 IUserService userService= new UserServiceImpl();
			 User user=userService.findUserByToken(token);
			 if(user!=null) {
			    session.setAttribute(Const.CURRENTUSER, user);
			    chain.doFilter(request, response);			   
			 }else {
				response.sendRedirect("http://localhost:8080/Business/login.jsp"); 
			 }
		 }else {
			 response.sendRedirect("http://localhost:8080/Business/login.jsp"); 
		 }
			
		 
		
		
		//step2:存在，获取用户名和密码，校验
		
		//stp3:不存在，跳转到登录页面
		
		
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
