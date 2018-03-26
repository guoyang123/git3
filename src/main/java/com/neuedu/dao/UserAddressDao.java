package com.neuedu.dao;

import com.neuedu.entity.Address;
import com.neuedu.entity.PageModel;

/**
 * �û���ַ����
 * */
public interface UserAddressDao {

	/**
	 * ����û��ջ���ַ
	 * @param userid �û�id
	 * @param address ��ַ����
	 * @return int
	 * */
	int  addAddress(Integer userid,Address address);
	/**
	 * ɾ���û���ַ
	 * @param userid �û�Id
	 * @param id ��ַid
	 * @return int
	 * */
	int deleteAddressByUserid(Integer userid,Integer id);
	/**
	 * �û��޸��ջ���ַ
	 * @param userid
	 * @param address ��Ҫ�޸ĵ�address
	 * */
	int  updateUserAddressByUserid(Integer userid,Address address);
	/**
	 * ��ѯ�û��ջ���ַ����ҳ��ѯ
	 * */
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
}
