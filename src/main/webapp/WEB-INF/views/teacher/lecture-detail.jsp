<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<main>
   <h2>강좌 내용</h2>
   <div>
	title 		: ${model.lecture.title } </br>
	forWho 		: ${model.lecture.forWho } </br>
	bookTitle	: ${model.lecture.bookTitle } </br>
	writerId	: ${model.lecture.writerId } </br>
   </div>

   <div>
   		<div>
   			<span>강의 제목</span> <span>강의 내용</span>
   		</div>
   		<c:forEach var="chapter" items="${model.chapters }">
   			<span>${chapter.title }</span> </br>
   			<c:forEach var="unit" items="${chapter.units }">
   				<span>${unit.title }</span> 
   				<span>${unit.duration }</span> </br>
   			</c:forEach>
   		</c:forEach>
   </div>
</main>