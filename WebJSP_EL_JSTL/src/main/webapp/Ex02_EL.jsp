<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// EL은 <%= write를 대체 목적으로 사용
	
	Date today = new Date();
	request.setAttribute("day", today);
	session.setAttribute("day2", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 화면 출력(서버쪽 자원)</h3>
	EL : ${requestScope.day }<br>
	EL : ${sessionScope.day2 }<br>
	EL : data1 : ${day }<br> <!-- day는 어떤 객체에 담겨있는거야..? (session? request? 판단하기가 힘들다) -->
	EL : data2 : ${day2 }<br>
</body>
</html>