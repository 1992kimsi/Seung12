package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RootController {
	
	//스프링컨테이너 내에 Dao가 잇었다면 사용가능한 친구들
	//@Autowired
	//private CategoryDao categoryDao;
	
	@RequestMapping("/index")	
	public String index(){
		
		//return "/WEB-INF/views/index.jsp";
		return "index";
	}
	/*
	@RequestMapping(value="/upload", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String upload(@RequestParam(value = "file") MultipartFile file){
		
		System.out.println("a");
		
		return "1";
	}
	
	@RequestMapping(value="/category", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String category(String id){
		
		//List<Category> list = categoryDao.getList(id);
		//String json = new Gson().from
		
		String json = "[]";
	      
	      switch(id){
	      
	      case "1":
	         json = "[{\"id\":\"1\",\"title\":\"강서구\"},{\"id\":\"2\", \"title\":\"노원구\"}]";
	         break;
	         
	      case "2":
	         json = "[{\"id\":\"1\",\"title\":\"시흥시\"},{\"id\":\"2\", \"title\":\"용인시\"}]";
	         break;
	         
	      case "3":
	         json = "[{\"id\":\"1\",\"title\":\"강릉시\"},{\"id\":\"2\", \"title\":\"속초시\"}]";
	         break;
	      }
		
		return json;
	}*/
	
}
