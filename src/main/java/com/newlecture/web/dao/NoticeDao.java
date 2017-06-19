package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeDao {
	
	String lastCode();
	
	@Select("SELECT * FROM NOTICE_VIEW	WHERE CODE=#{id}")
	NoticeView get(String id);
	
	NoticeView getPrev(String id);
	NoticeView getNext(String id);
	
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(
			@Param("page") int page,
			@Param("field") String field,
			@Param("query") String query);
	
	//@RequestMapping param : HttpServlet과 비슷하게 request객체를 이용하는것 처럼 보이지만, 
	//이 방법은 어노테이션(@)를 이용하여 데이터를 전송받는 방법.
	
	int getSize();
	int getSize(String field, String query);
	
	//add함수를 구현하는 insert부분을 이렇게 쓸수도 있다.
	//@selectKey -> 값을 가져와서 +1이나 변화를 준 후 리턴해야 할 때 사용한다.
	//@selectKey -> 한 화면에서 두가지 insert가 일어날때 두 데이터가 부모자식, FK관계일때 
	//key값을 줘서 구분하려고 사용하기도 한다.
	
	//ex) No가 추가되고 Id가 Member테이블에 추가될 때
	@SelectKey(
			statement="SELECT MAX(CAST(id AS UNSIGNED))+1 id FROM NOTICE",
			before=true,
			keyProperty="id",
			resultType=String.class)
	@Insert("INSERT INTO NOTICE( "+
			"id, "+
			"title, "+
			"writer, "+
			"content "+
			")  "+
		"VALUES( "+
		"	#{id}, "+
		"	#{title}, "+
		"	#{writer}, "+
		"	#{content} "+
		")")
	int add(Notice notice);
	int add(String title, String content, String writer);
	
	int	 update(Notice notice);
	int	 update(String title, String content, String id);
	
	int delete(String id);
}
