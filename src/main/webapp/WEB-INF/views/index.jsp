<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- device-width-> 기기의 너비, 숫자를 써도 되는데 그럴땐 (보여질 실제 너비를 쓰면댐, 노출될 너비를 지정한다), initial-scale=(비율) -->
<meta name="viewport" content="width=device-width, initial-scale=0.5">
</head>
<body>
	<header>
		<a href="../index.html">메인 페이지</a>
		<c:if test="${empty sessionScope.id}">
		<a href="joinus/login">로그인</a>
		</c:if>
		<c:if test="${not empty sessionScope.id}">
		<a href="joinus/logout">${sessionScope.id}님 로그아웃</a>
		</c:if>		
		<a href="">회원가입</a>
		<a href="customer/notice">고객센터</a>
	</header>
	<h1>홈페이지 환영</h1>
	
</body>
</html>