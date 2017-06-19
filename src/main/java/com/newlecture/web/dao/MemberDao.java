package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Member;

public interface MemberDao {
	Member get(String id);
	
	List<Member> getList(String query);
	List<Member> getList(String query, String pwd, String name);
	List<Member> getList();
	
	int add(Member member);

	int add(String code, String title, String content, int hit);
	int pointUp();
}