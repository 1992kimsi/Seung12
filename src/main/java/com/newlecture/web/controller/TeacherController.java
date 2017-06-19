package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.model.teacher.LectureDetailModel;
import com.newlecture.web.model.teacher.LectureModel;
import com.newlecture.web.service.TeacherService;

@Controller
@RequestMapping("/teacher/*")
public class TeacherController {
	
	@Autowired
	private TeacherService service;
	
	@RequestMapping("index")
	public String index(){
		
		return "teacher.index";
	}
	
	@RequestMapping("lecture")
	public String lecture(
			@RequestParam(value="p", defaultValue="1")Integer page, 
			@RequestParam(value="f", defaultValue="TITLE")String field, 
			@RequestParam(value="q", defaultValue="")String query, Model model){
		
		LectureModel m = service.getLectureModel(page, field, query);
		model.addAttribute("model", m);
				
		return "teacher.lecture";
	}
	
	@RequestMapping("lecture-detail")
	public String lectureDetail(
			@RequestParam(value="k", defaultValue="k")String lectureId, Model model
			){
		
		LectureDetailModel m = service.getChapterModel(lectureId);
		model.addAttribute("model", m);
		
		return "teacher.lecture-detail";
		//LectureDetailModel m = service.getLectureDetailModel(code);
		//model.addAttribute("model", m);
		
	}
}
