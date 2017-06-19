package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.MemberRole;

public interface MemberRoleDao {
	String getDefaultRoleById(String memberId);
	List<MemberRole> getRolesOfMember(String memberId);
	List<MemberRole> getList(String string);
	List<MemberRole> getList();	
	
	int delete(MemberRole memberRole);
	int update(MemberRole memberRole);
	int add(MemberRole memberRole);
}
