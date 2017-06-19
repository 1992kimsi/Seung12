package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.PlatformDao;
import com.newlecture.web.entity.Platform;

public class MyBatisPlatformDao implements PlatformDao{

   @Autowired
   private SqlSession sqlSession;
      
   @Override
   public List<Platform> getList(int page, String field, String query) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.getList(page, field, query);
   }

   @Override
   public List<Platform> getList(int page) {
      // TODO Auto-generated method stub
      return getList(page, "TITLE", "");
   }
   
   @Override
   public List<Platform> getList() {
            
      return getList(1, "TITLE", "");
   }

   @Override
   public Platform get(String id) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.get(id);
   }

   @Override
   public int add(Platform platform) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.add(platform);
   }

   @Override
   public int update(Platform platform) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.update(platform);
   }

   @Override
   public int delete(String id) {
      PlatformDao platformDao;
      platformDao = sqlSession.getMapper(PlatformDao.class);
      
      return platformDao.delete(id);
   }


}