package com.neuedu.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private  static  SqlSessionFactory sqlSessionFactory=null;
	
      static {
		
    	 String config="com/neuedu/config/MyBatisConfig.xml";
  		Reader reader=null;
  		try {
  			reader=Resources.getResourceAsReader(config);
  		// 2，生成SqlSessionFactory   为SqlSession的工厂，用于建立与数据库的会话。
  			 sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
  		} catch (IOException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
		
	}
	
      /**
       * 获取SqlSessionFactory
       * */
      public  static  SqlSessionFactory  getSqlSessionFactory() {
    	  return sqlSessionFactory;
      }
      
      /**
       * 关闭sqlSession
       * */
      public  static  void  close(SqlSession sqlSession) {
    	  sqlSession.close();
      }
	
}
