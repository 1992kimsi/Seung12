package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Language;

public interface LanguageDao {
	
	List<Language> getListOfLecture(String lectureId);
	
	List<Language> getList();
	List<Language> getList(int page, String field, String query);
	List<Language> getList(int page);	
	Language get(String id);
	
	int add(Language language);
	int	update(Language language);	
	int delete(String id);
	
	
}
