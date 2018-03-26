package com.neuedu.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/el")
public class ELServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setAttribute("name", "req_zhangsan");
		
		HttpSession session=req.getSession();
		
		session.setAttribute("name", "session_zhangsan");
		
		ServletContext application=this.getServletContext();
		application.setAttribute("name", "application_zhangsan");
		
		req.getRequestDispatcher("el.jsp").forward(req, resp);
	}
}
