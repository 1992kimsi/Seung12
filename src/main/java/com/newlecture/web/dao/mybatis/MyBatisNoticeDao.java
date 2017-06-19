package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class MyBatisNoticeDao implements NoticeDao {
   @Autowired
      private SqlSession sqlSession;
   
   @Override
   public String lastCode() {
      
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.lastCode();
   }

   @Override
   public NoticeView get(String code) {
      
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.get(code);
   }

   @Override
   public NoticeView getPrev(String code) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.getPrev(code);
   }

   @Override
   public NoticeView getNext(String code) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.getNext(code);
   }

   @Override
   public List<NoticeView> getList() {
    
      
      return getList(1,"TITLE","");
   }

   @Override
   public List<NoticeView> getList(int page) {
      
      
      return getList(page,"TITLE","");
   }

   @Override
   public List<NoticeView> getList(int page, String field, String query) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.getList(page, field, query);
   }

   @Override
   public int getSize() {
    
      return getSize();
   }

   @Override
   public int getSize(String field, String query) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.getSize(field, query);
   }

   @Override
   public int add(Notice notice) {
     
      return add(notice);
   }

   @Override
   public int add(String title, String content, String writer) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.add(title, content, writer);
   }

   @Override
   public int update(Notice notice) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.update(notice);
   }

   @Override
   public int update(String title, String content, String code) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.update(title, content, code);
   }

   @Override
   public int delete(String code) {
      NoticeDao noticeDao;
      noticeDao = sqlSession.getMapper(NoticeDao.class);
      
      return noticeDao.delete(code);
   }

}