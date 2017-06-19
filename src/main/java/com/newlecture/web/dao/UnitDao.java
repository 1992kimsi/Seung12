package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Language;
import com.newlecture.web.entity.Unit;

public interface UnitDao {
	List<Unit> getListOfUnit(String chapterId);

	List<Unit> getList(int page, String field, String query);
	List<Unit> getList(int page);	
	List<Unit> getList();
	Language get(String id);
	
	int add(Unit unit);
	int	update(Unit unit);	
	int delete(String id);
	
	
}
