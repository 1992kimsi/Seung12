package com.newlecture.web.model.teacher;

import java.util.List;

import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Lecture;

public class LectureDetailModel {

	private Lecture lecture;
	private List<Chapter> chapters;
	
	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
}
