package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Platform;

public interface PlatformDao {
	
	List<Platform> getList();
	List<Platform> getList(int page);
	List<Platform> getList(int page, String field, String query);
	Platform get(String id);
	
	int add(Platform platform);
	int	 update(Platform platform);	
	int delete(String id);
}
