package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.entity.Lecture;
import com.newlecture.web.entity.LectureView;

public interface LectureDao {
   
   List<LectureView> getList(int page, String field, String query);
   List<LectureView> getList(int page);
   List<LectureView> getList();   
   LectureView get(String id);

   int getSize(String field, String query);

   int add(Lecture lecture);
   int update(Lecture lecture);
   int delete(String id);
   
}