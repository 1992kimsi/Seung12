package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class MyBatisMemberDao implements MemberDao{

   @Autowired
   private SqlSession sqlSession;

   @Override
   public List<Member> getList() {
      return getList("","","");
   }

   @Override
   public List<Member> getList(String query) {
      return getList(query,"","");
   }

   @Override
   public List<Member> getList(String query, String pwd, String name) {
      MemberDao memberDao;
      memberDao = sqlSession.getMapper(MemberDao.class);
      return memberDao.getList(query, pwd, name);
   }

   @Override
   public int add(Member member) {
      MemberDao memberDao;
      memberDao = sqlSession.getMapper(MemberDao.class);
      return memberDao.add(member);
   }

   @Override
   public Member get(String id) {
      MemberDao memberDao;
      memberDao = sqlSession.getMapper(MemberDao.class);
      return memberDao.get(id);
   }
   

}