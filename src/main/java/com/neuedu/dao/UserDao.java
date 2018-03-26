package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.User;
import com.neuedu.exception.UserDaoException;

/**
 * �û���¼��ע��Ȳ���
 * */
public interface UserDao {
    /**
     * ����û����Ƿ����
     * @param username
     * @return int  >0�����ѯ�����û�  <=0 �û�������
     * */
	int  checkUserName(String username);
	/**
	 * �����û����������ѯ�û�
	 * @param username
	 * @param password
	 * @return User  user��Ϊnullʱ����ѯ�ɹ�;���򣬲�ѯʧ�ܣ��û������������;
	 * 
	 * */
	User findByUserNameAndPassword(String username,String password) throws UserDaoException;
	
	
	
	/**
	 * �����û�token
	 * */
	int  updateTokenByUserId(Integer userid,String token) throws UserDaoException;
	/**
	 * �����û�token��ѯ�û���Ϣ
	 * @param  token �û�token
	 * @return user
	 * */
	User  findUserByToken(String token) throws UserDaoException;
	
	
	/**
	 * ��ѯ�����û�
	 * */
	List<User> findAllUser() throws UserDaoException;
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNo ҳ��
	 * @param pageSize 
	 * @return  PageModel
	 * */
	PageModel<User> findUserByPage(Integer pageNo,Integer pageSize) throws UserDaoException;
	
	/**
	 * ����û�
	 * */
	int  addUser(User user) throws UserDaoException;
	
	
	/**
	 * ɾ���û�
	 * */
	int  deleteUserById(Integer userid)throws UserDaoException;
	/**
	 * ���������û���Ϣ
	 * */
	int  addBatchUser(List<User> users) throws UserDaoException; 
	
	
	List<User>  findUserByForeach(List<Integer> ids) throws UserDaoException;
}
