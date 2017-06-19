	package com.newlecture.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeFile;
import com.newlecture.web.entity.NoticeView;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private NoticeFileDao noticeFileDao;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("notice")	
	/*@ResponseBody*/
	public String notice(
			@RequestParam(value="p", defaultValue="1")Integer page, 
			@RequestParam(value="f", defaultValue="TITLE")String field, 
			@RequestParam(value="q", defaultValue="")String query, Model model){
		
		//return String.format("page:%s, field:%s, query:%s\n", page,field,query);
		
		//List<NoticeView> list = noticeDao.getList();
		List<NoticeView> list = sqlSession.getMapper(NoticeDao.class).getList(page,field,query);
		model.addAttribute("list", list);
		
		//return "/WEB-INF/views/customer/notice.jsp";		
		return "customer.notice";
	}
	
	@RequestMapping("notice-detail")
	public String noticeDetail(@RequestParam("c") String code, Model model){
		
		//model.addAttribute("n", noticeDao.get(code));
		model.addAttribute("n", 
				sqlSession.getMapper(NoticeDao.class).get(code));
		
		//return "/WEB-INF/views/customer/notice-detail.jsp";
		return "customer.notice-detail";
	}
	
	@RequestMapping(value="notice-reg", method=RequestMethod.GET)
	public String noticeReg(){
		
		//return "/WEB-INF/views/customer/notice-reg.jsp";
		return "customer.notice-reg";
	}
	
	@RequestMapping(value="notice-reg", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String noticeReg(
			Notice notice, 
			@RequestParam(value = "files") List<MultipartFile> files) throws IOException{
					
			String path = context.getRealPath("/resource/upload");
			
			File d = new File(path);
			if(!d.exists())//경로가 존재하지 않는다면
				d.mkdir();
		
			byte[] buf = new byte[1024];
						
			for(MultipartFile file : files){
				if(!file.isEmpty()){
					String fileName = file.getOriginalFilename();
					InputStream fis = file.getInputStream();
					OutputStream fos = new FileOutputStream(path+File.separator+fileName);
					
					int len = 0; 
					
					while((len = fis.read(buf)) > 0)
						fos.write(buf, 0, len);
					
					fis.close();
					fos.close();
				}
			}
		
		notice.setWriterId("newlec");
		noticeDao.add(notice);
		
		for(MultipartFile file : files){
			if(!file.isEmpty()){
				String fileName = file.getOriginalFilename();
				NoticeFile f = new NoticeFile();
				f.setNoticeId(noticeDao.lastCode());
				f.setSrc(fileName);
				noticeFileDao.add(f);
			}
		}
		
		return "redirect:notice";
	}
	
	@RequestMapping("notice-del")
	public String noticeDel(@RequestParam("c") String code){
		
		// 파일 정보를 얻기
		/*File f = new File("");
		f.delete();*/
				
		// 외래키 제약 조건에 on delete CASCADE가 되어 있는 경우
		// notice 정보만 지우면 됨. 
		// 그렇지 않은 경우 notice file을 먼저 지워야 함. -외래키 제약조건 오류 발생
		noticeDao.delete(code);
		
		return "redirect:notice";
	}
	
	@RequestMapping(value="notice-edit", method=RequestMethod.GET)	
	public String noticeEdit(@RequestParam("c") String code, Model model){
		
		model.addAttribute("n", noticeDao.get(code));
		
		return "/WEB-INF/views/customer/notice-edit.jsp";
	}
	
	@RequestMapping(value="notice-edit", method=RequestMethod.POST)	
	public String noticeEdit(String title, String content, String code){
		
		Notice notice = noticeDao.get(code);
		notice.setTitle(title);
		notice.setContent(content);
				
		noticeDao.update(notice);
		
		return "redirect:notice-detail?c="+notice.getId();
	}
	
	
	
}




