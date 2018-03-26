package com.neuedu.dao;

import com.neuedu.entity.Address;
import com.neuedu.entity.PageModel;

/**
 * 用户地址管理
 * */
public interface UserAddressDao {

	/**
	 * 添加用户收货地址
	 * @param userid 用户id
	 * @param address 地址对象
	 * @return int
	 * */
	int  addAddress(Integer userid,Address address);
	/**
	 * 删除用户地址
	 * @param userid 用户Id
	 * @param id 地址id
	 * @return int
	 * */
	int deleteAddressByUserid(Integer userid,Integer id);
	/**
	 * 用户修改收货地址
	 * @param userid
	 * @param address 需要修改的address
	 * */
	int  updateUserAddressByUserid(Integer userid,Address address);
	/**
	 * 查询用户收货地址，分页查询
	 * */
	PageModel<Address> findUserAddress(Integer pageNo,Integer pageSize,Integer userid);
}
