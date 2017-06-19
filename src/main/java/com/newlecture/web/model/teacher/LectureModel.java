package com.newlecture.web.model.teacher;

import java.util.List;

import com.newlecture.web.entity.LectureView;

public class LectureModel {

   private List<LectureView> lectures;
   private int totalPageCount;
   
   public List<LectureView> getLectures() {
      return lectures;
   }

   public void setLectures(List<LectureView> lectures) {
      this.lectures = lectures;
   }

   public int getTotalPageCount() {
      return totalPageCount;
   }

   public void setTotalPageCount(int totalPageCount) {
      this.totalPageCount = totalPageCount;
   }   
   
}