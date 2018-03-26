package com.neuedu.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	
	private  static  Properties ps=new Properties();
	
	static {
		
		try {
			ps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		     Class.forName(ps.getProperty("driver"));
		   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 获取链接
	 * */
	public  static  Connection  getConnection() {
		
		try {
			return  DriverManager.getConnection(ps.getProperty("url"), ps.getProperty("user"), ps.getProperty("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 关闭连接
	 * 
	 * */
	public  static  void  close(Connection conn) throws SQLException {
		conn.close();
	}
	
	public  static  void  close(Connection conn,PreparedStatement pst) throws SQLException {
		conn.close();
		pst.close();
	}
	public  static  void  close(Connection conn,PreparedStatement pst,ResultSet rs) throws SQLException {
		conn.close();
		pst.close();
		rs.close();
	}
	
	
	
}
