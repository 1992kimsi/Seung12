package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.LecturePlatform;


public interface LecturePlatformDao {

	List<LecturePlatform> getList();
	
	LecturePlatform get(String lectureId, String platformId);
	
	int add(LecturePlatform lecturePlatform);
	int update(LecturePlatform lecturePlatform);
	int delete(String lectureId, String platformId);
}
