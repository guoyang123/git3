package com.neuedu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.neuedu.common.DBUtils;
import com.neuedu.dao.UserDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;

/**
 * UserDao接口的实现类
 * */
public class UserDaoImpl implements UserDao {

	@Override
	public int checkUserName(String username) {	
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		
		try {
			conn=DBUtils.getConnection();
			String sql="select username from user where username=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			
			rs= pst.executeQuery();
			
			if(rs.next()) {
				return 1;
			}else {
				return 0;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new UserDaoException("查询用户名出错...");
		}finally {
			try {
				DBUtils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new UserDaoException("查询用户名关闭连接出错...");
			}
		}
		
		
		
	}

	@Override
	public User findByUserNameAndPassword(String username, String password) throws UserDaoException {
		// TODO Auto-generated method stub

		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="select  id, username ,password,email,phone,question,answer,role,create_time,update_time from user where username=? and password=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs= pst.executeQuery();
			
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRole(rs.getInt("role"));
				user.setCreate_time(rs.getDate("create_time"));
				user.setUpdate_time(rs.getDate("update_time"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new UserDaoException("根据用户名和密码查询用户出错...");
		}finally {
			try {
				DBUtils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new UserDaoException("根据用户名和密码查询用户信息，关闭连接出错...");
			}
		}
		
		
		
		
		return user;
	}

	@Override
	public int updateTokenByUserId(Integer userid, String token) throws UserDaoException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		
		
		
		try {
			conn=DBUtils.getConnection();
			String sql="update user set token=? where id=? ";
			pst=conn.prepareStatement(sql);
			
			pst.setString(1, token);
			pst.setInt(2, userid);
			
			return pst.executeUpdate();
			
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new UserDaoException("更新用户token出错...");
		}finally {
			try {
				DBUtils.close(conn, pst);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new UserDaoException("更新用户token出错关闭连接出错...");
			}
		}
		
		
		
	}

	@Override
	public User findUserByToken(String token) throws UserDaoException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		User user=null;
		
		try {
			conn=DBUtils.getConnection();
			String sql="select  id, username ,password,email,phone,question,answer,role,create_time,update_time from user where token=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, token);
			
			rs= pst.executeQuery();
			
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setRole(rs.getInt("role"));
				user.setCreate_time(rs.getDate("create_time"));
				user.setUpdate_time(rs.getDate("update_time"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new UserDaoException("根据token查询用户出错...");
		}finally {
			try {
				DBUtils.close(conn, pst, rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new UserDaoException("根据token查询用户信息，关闭连接出错...");
			}
		}
		
		
		
		
		return user;
		
	
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel<User> findUserByPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addUser(User user) throws UserDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserById(Integer userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addBatchUser(List<User> users) throws UserDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> findUserByForeach(List<Integer> ids) throws UserDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
