package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.LectureDao;
import com.newlecture.web.entity.Lecture;
import com.newlecture.web.entity.LectureView;

public class MyBatisLectureDao implements LectureDao {
   
   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<LectureView> getList(int page, String field, String query) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.getList(page, field, query);
   }

   @Override
   public List<LectureView> getList(int page) {
      
      return getList(page, "TITLE", "");
   }

   @Override
   public List<LectureView> getList() {
      
      return getList(1, "TITLE", "");
   }

   @Override
   public LectureView get(String id) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.get(id);
   }

   @Override
   public int add(Lecture lecture) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.add(lecture);
   }

   @Override
   public int update(Lecture lecture) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.update(lecture);
   }

   @Override
   public int delete(String id) {
      LectureDao lectureDao;
      lectureDao = sqlSession.getMapper(LectureDao.class);
      return lectureDao.delete(id);
   }

	@Override
	public int getSize(String field, String query) {
		LectureDao lectureDao;
	    lectureDao = sqlSession.getMapper(LectureDao.class);
		return lectureDao.getSize(field, query);
	}

}