<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title>으갹갹갹</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/MavenPrj/resource/css/style.css" type="text/css" rel="stylesheet">
<style>
	body{
		/* 루트의 크기 */
		font-size:12px;
	}
	
	.row{
		width:90%;
		font-size:16px; /* 부모의 크기 */
	}

	.row > div{
		box-sizing:border-box;
		float:left;
		min-height: 100px;
		background: pink;
		
		/* em:'부모'의 크기를 따르며 배수, rem:'루트'의 크기를 따르며 배수 */
		font-size: 1em;
	}
</style>
</head>
<body>
	<!-- ---------------------------------------------헤 더------------------------------------------------------------ -->
	<!-- 헤더부분 -->
	<tiles:insertAttribute name="header" />
	<!-- ---------------------------------------------비주얼------------------------------------------------------------ -->
	<!-- 비주얼 부분 -->
	<div class="title">
		믿음
	</div>
	<tiles:insertAttribute name="visual" />
	<!-- -----------------------------------------------바디---------------------------------------------------------- -->
	<div id="body">
		<!-- 섹션과 메인을 div로 묶어줌 -->
		<div class="content-container clearfix">
			<!-- 어사이드 부분 -->
			<tiles:insertAttribute name="aside" />
			
			<!-- 메인 부분 -->
			<tiles:insertAttribute name="main" />
		</div>
	</div>

	<!-- -----------------------------------------------푸터---------------------------------------------------------- -->
	<!-- 푸터부분 -->
	<tiles:insertAttribute name="footer" />
</body>
</html>