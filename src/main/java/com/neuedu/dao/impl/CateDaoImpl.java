package com.neuedu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.neuedu.common.MyBatisUtils;
import com.neuedu.dao.CateDao;
import com.neuedu.entity.Cate;
import com.neuedu.entity.PageModel;
import com.neuedu.exception.CateDaoException;

public class CateDaoImpl implements CateDao {

	@Override
	public int addCate(Cate cate) {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.insert("com.neuedu.entity.Cate.addCate", cate);
	     session.close();
		return result;
	}

	@Override
	public int deleteCateById(Integer cateid) throws CateDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.insert("com.neuedu.entity.Cate.deleteCateById", cateid);
	     session.close();
		return result;
	}

	@Override
	public int updateCate(Cate cate) throws CateDaoException {
		// TODO Auto-generated method stub
		
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		int result=session.update("com.neuedu.entity.Cate.updateCate", cate);
	     session.close();
		return result;
	}
	

	@Override
	public PageModel<Cate> findCateByPage(Integer pageNo, Integer pageSize) throws CateDaoException {
		// TODO Auto-generated method stub

		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		
		Integer totalcount=session.selectOne("com.neuedu.entity.Cate.findTotalCount");
	     Map<String,Integer> map=new HashMap<String,Integer>();
	     map.put("offSet", (pageNo-1)*pageSize);
	     map.put("pageSize",pageSize);
		 List<Cate> list=session.selectList("com.neuedu.entity.Cate.findCateByPage", map);
    
		 PageModel<Cate> pageModel=new PageModel<>();
		 pageModel.setTotalPage(((totalcount%pageSize)==0?totalcount/pageSize:(totalcount/pageSize)+1));
		 pageModel.setData(list);
		 return pageModel;
	}

	@Override
	public Cate findCateById(Integer cateid) throws CateDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession(true);
		Cate cate=session.selectOne("com.neuedu.entity.Cate.findCateById",cateid);
		session.close();
		return cate;
	}

	
	@Override 
	public List<Cate> findAll() throws CateDaoException {
		// TODO Auto-generated method stub
		SqlSessionFactory factory=MyBatisUtils.getSqlSessionFactory();
		SqlSession session=factory.openSession();
		List<Cate> cates=session.selectList("com.neuedu.entity.Cate.findAll");
		session.close();
		return cates;
	}
	
}
