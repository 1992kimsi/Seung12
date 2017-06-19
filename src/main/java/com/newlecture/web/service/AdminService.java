package com.newlecture.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;

public class AdminService {
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	public int noticeRegPointUp(){
		
		memberDao.add("","","",0);
		memberDao.pointUp();
		
		return 0;
	}
	
}
