<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>VIEW PAGE</h3>
	UI 코드 담당
	<hr>
	<%= request.getAttribute("getmsg") %>
	<hr>
	<%= request.getAttribute("msg") %>
	<hr>
	
	<hr>
	<!-- EL로 메시지 출력 -->
	${requestScope.msg }<br>
</body>
</html>