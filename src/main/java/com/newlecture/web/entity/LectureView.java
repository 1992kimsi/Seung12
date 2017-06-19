package com.newlecture.web.entity;

public class LectureView extends Lecture{
   
   private String levelName;
   private String memberName;

   public String getLevelName() {
      return levelName;
   }

   public void setLevelName(String levelName) {
      this.levelName = levelName;
   }

	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
}