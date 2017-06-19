package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.NoticeFile;

public interface NoticeFileDao {
	List<NoticeFile> getList(String noticeId);
	
	int add(NoticeFile file);
	int add(String src, String noticeId);
}
