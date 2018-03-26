package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;

/**
 * 用户登录、注册等操作
 * */
public interface UserDao {
    /**
     * 检查用户名是否存在
     * @param username
     * @return int  >0代表查询出该用户  <=0 用户不存在
     * */
	int  checkUserName(String username);
	/**
	 * 根据用户名和密码查询用户
	 * @param username
	 * @param password
	 * @return User  user不为null时，查询成功;否则，查询失败，用户名或密码错误;
	 * 
	 * */
	User findByUserNameAndPassword(String username,String password) throws UserDaoException;
	
	
	
	/**
	 * 更新用户token
	 * */
	int  updateTokenByUserId(Integer userid,String token) throws UserDaoException;
	/**
	 * 根据用户token查询用户信息
	 * @param  token 用户token
	 * @return user
	 * */
	User  findUserByToken(String token) throws UserDaoException;
	
	
	/**
	 * 查询所有用户
	 * */
	List<User> findAllUser() throws UserDaoException;
	
	/**
	 * 分页查询
	 * @param pageNo 页码
	 * @param pageSize 
	 * @return  PageModel
	 * */
	PageModel<User> findUserByPage(Integer pageNo,Integer pageSize) throws UserDaoException;
	
	/**
	 * 添加用户
	 * */
	int  addUser(User user) throws UserDaoException;
	
	
	/**
	 * 删除用户
	 * */
	int  deleteUserById(Integer userid)throws UserDaoException;
	/**
	 * 批量插入用户信息
	 * */
	int  addBatchUser(List<User> users) throws UserDaoException; 
	
	
	List<User>  findUserByForeach(List<Integer> ids) throws UserDaoException;
}
