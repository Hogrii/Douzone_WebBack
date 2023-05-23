<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		1. 메모리 쿠키(브라우저) : client가 강제로 지우지 않으면 브라우저가 닫히기 전까지 유효
			-> 소멸타입 : getMaxAge() >> -1 = session
		2. 파일쿠키(소멸시간을 가지고 있음) : client가 강제로 지우지 않으면 정해진 시간까지 유효(2050년 12월 12일)
			-> setMaxAge(60) >> 60초
			-> 30일 : (60*60*24*30) >> setMaxAge(60*60*24*30)
	 -->
	 
	 <%
	 	Cookie co = new Cookie("kosa", "hong");
	 	co.setMaxAge(30*24*60*60); // 30일
	 	response.addCookie(co);
	 %>
</body>
</html>