package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Language;

public interface ChapterDao {
	List<Chapter> getListOfChapter(String lectureId);
	
	List<Chapter> getList(int page, String field, String query);
	List<Chapter> getList(int page);	
	List<Chapter> getList();
	Language get(String id);
	
	int add(Chapter chapter);
	int	update(Chapter chapter);
	int delete(String id);
	
}