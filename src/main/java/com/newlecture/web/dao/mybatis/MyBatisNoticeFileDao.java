package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.entity.NoticeFile;

public class MyBatisNoticeFileDao implements NoticeFileDao{

   @Autowired
   private SqlSession sqlSession;
   
   @Override
   public List<NoticeFile> getList(String noticeCode) {
      
      NoticeFileDao noticeFileDao;
      noticeFileDao = sqlSession.getMapper(NoticeFileDao.class);
      
      return noticeFileDao.getList(noticeCode);
   }

   @Override
   public int add(NoticeFile file) {
      NoticeFileDao noticeFileDao;
      noticeFileDao = sqlSession.getMapper(NoticeFileDao.class);
      
      return noticeFileDao.add(file);
   }

   @Override
   public int add(String src, String noticeCode) {
      NoticeFileDao noticeFileDao;
      noticeFileDao = sqlSession.getMapper(NoticeFileDao.class);
      
      return noticeFileDao.add(src, noticeCode);
   }

   
}