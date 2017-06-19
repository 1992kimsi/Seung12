package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.ChapterDao;
import com.newlecture.web.dao.LanguageDao;
import com.newlecture.web.dao.LectureDao;
import com.newlecture.web.dao.LectureLanguageDao;
import com.newlecture.web.dao.LecturePlatformDao;
import com.newlecture.web.dao.LevelDao;
import com.newlecture.web.dao.UnitDao;
import com.newlecture.web.entity.Chapter;
import com.newlecture.web.entity.Language;
import com.newlecture.web.entity.Lecture;
import com.newlecture.web.entity.LectureView;
import com.newlecture.web.entity.Unit;
import com.newlecture.web.model.teacher.LectureDetailModel;
import com.newlecture.web.model.teacher.LectureModel;

public class TeacherService {
   @Autowired
   private LectureDao lectureDao;
   
   @Autowired
   private LectureLanguageDao lectureLanguageDao;
   
   @Autowired
   private LanguageDao languageDao;
   
   @Autowired
   private LecturePlatformDao lecturePlatformDao;
   
   @Autowired
   private LevelDao levelDao;
   
   @Autowired
   private ChapterDao chapterDao;
   
   @Autowired
   private UnitDao unitDao;
   
   public LectureModel getLectureModel(
         int page, String field, String query){
      
      LectureModel model = new LectureModel();
      
      List<LectureView> lectures = lectureDao.getList(page, field, query);
      int size = lectureDao.getSize(field, query);
      
      model.setLectures(lectures);
      model.setTotalPageCount(size);
      
      for(Lecture lec : lectures){
         //lec.setMember(?);
         
         lec.setLevel(levelDao.getLevelOfLecture(lec.getId()));
         /*List<LectureLanguage> langs = lectureLanguageDao.getList(lec.getCode());
         lec.setLanguages(langs);*/
         List<Language> langs = languageDao.getListOfLecture(lec.getId());
         lec.setLanguages(langs);
                  
         //langs.get(0).getLanguageCode()
         //lec.setPlatforms(platforms);
      }
      return model;
   }
   
   public LectureDetailModel getChapterModel(String lectureId){
	   LectureDetailModel model = new LectureDetailModel();
	   Lecture lecture = lectureDao.get(lectureId);
	   
	   model.setLecture(lecture);
	   List<Chapter> chapters = chapterDao.getListOfChapter(lectureId);
	   
	   model.setChapters(chapters);
	   
	   for(Chapter chapter : chapters){
		   List<Unit> units = unitDao.getListOfUnit(chapter.getId());
		   chapter.setUnits(units);
	   }
	   
	   return model;
   }
   
}













