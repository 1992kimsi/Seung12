package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Level;

public interface LevelDao {
	
	Level getLevelOfLecture(String lectureId);
	List<Level> getList();
	Level get(String id);
	int add(Level level);
	int	 update(Level level);
	int delete(String id);
	
}
