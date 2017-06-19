package com.newlecture.web.entity;

import java.util.List;

public class Chapter {

	private String id;
	private String title;
	
	private List<Unit> units ;
	
	public List<Unit> getUnits() {
		return units;
	}
	
	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}