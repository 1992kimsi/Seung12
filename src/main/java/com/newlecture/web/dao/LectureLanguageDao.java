package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.LectureLanguage;


public interface LectureLanguageDao {

	//List<LectureLanguage> getList();
	List<LectureLanguage> getList(String lectureId);

	LectureLanguage get(String lectureId, String languageId);
	
	int add(LectureLanguage lectureLanguage);
	int update(LectureLanguage lectureLanguage);
	int delete(String lectureId, String languageId);
}
