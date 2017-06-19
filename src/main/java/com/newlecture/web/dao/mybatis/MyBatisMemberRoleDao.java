package com.newlecture.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.MemberRoleDao;
import com.newlecture.web.entity.MemberRole;

public class MyBatisMemberRoleDao implements MemberRoleDao {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public String getDefaultRoleById(String memberId) {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.getDefaultRoleById(memberId);
	}

	@Override
	public List<MemberRole> getRolesOfMember(String memberId) {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.getRolesOfMember(memberId);

	}

	@Override
	public List<MemberRole> getList(String memberId) {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.getList(memberId);
	}

	@Override
	public List<MemberRole> getList() {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.getList("");
	}

	@Override
	public int add(MemberRole memberRole) {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.add(memberRole);
	}

	@Override
	public int delete(MemberRole memberRole) {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.delete(memberRole);
	}

	@Override
	public int update(MemberRole memberRole) {
		MemberRoleDao memberRoleDao;
		memberRoleDao = sqlSession.getMapper(MemberRoleDao.class);
		return memberRoleDao.update(memberRole);
	}


}