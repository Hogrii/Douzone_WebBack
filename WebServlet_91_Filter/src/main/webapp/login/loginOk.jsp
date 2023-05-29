<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// request.setCharacterEncoding("UTF-8");
	/*
		1. 한글처리
		2. 데이터 받기
		
		한글 처리(모든 페이지에 적용 된다면? >> 공통 관심)
		공통 관심(보조 관심)을 분리 >> 한 곳에서 통합 관리 >> WAS >> filter
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	한글명 : ${param.kor }<br>
	영문명 : ${param.eng }
</body>
</html>