package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CateDao;
import com.neuedu.dao.impl.CateDaoImpl;
import com.neuedu.entity.Cate;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CateDaoException;
import com.neuedu.service.ICateService;

public class CateServiceImpl implements ICateService {

	 CateDao cateDao=new CateDaoImpl();
	@Override
	public int addCate(Cate cate) throws CateDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCateById(Integer cateid) throws CateDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCate(Cate cate) throws CateDaoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageModel<Cate> findCateByPage(Integer pageNo, Integer pageSize) throws CateDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cate findCateById(Integer cateid) throws CateDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cate> findAll() throws CateDaoException {
		// TODO Auto-generated method stub
		return cateDao.findAll();
	}

}
