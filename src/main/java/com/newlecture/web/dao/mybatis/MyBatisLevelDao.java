package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.LevelDao;
import com.newlecture.web.entity.Level;

public class MyBatisLevelDao implements LevelDao{

   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public List<Level> getList() {
      // TODO Auto-generated method stub
      
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.getList();
   }

   @Override
   public Level get(String id) {
      // TODO Auto-generated method stub
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      
      return levelDao.get(id);
   }

   @Override
   public int add(Level level) {
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.add(level);
   }

   @Override
   public int update(Level level) {
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.update(level);
   }

   @Override
   public int delete(String id) {
      LevelDao levelDao;
      levelDao = sqlSession.getMapper(LevelDao.class);
      return levelDao.delete(id);
   }

@Override
public Level getLevelOfLecture(String lectureId) {
	LevelDao levelDao;
    levelDao = sqlSession.getMapper(LevelDao.class);
    return levelDao.getLevelOfLecture(lectureId);
}

}