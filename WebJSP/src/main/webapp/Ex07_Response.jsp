<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	웹 환경
	
	Client -> Server(요청된 정보를 request 객체를 통해 얻어서 사용)
		(request)
	
	Server -> Client(서버에서 생성된 결과를 클라이언트(웹 브라우저)에게 전달) >> text, html, css, script
		(response)
	
	내장객체
	request
	resonse
	session
	application
	out 등등.. >> Apache Tomcat Server가 가지고 있음 >> javax. 로 시작
	
	response
	1. 표현식(출력) %=
	2. 페이지 이동(response.sendRedirect())
	response.sendRedirect("이동할 주소") >> 해석의 주체가 서버(랜더링)
	*** javascript 페이지 이동 >> location.href="이동할 주소" ***
	*** 웹 브라우저에서 F5(새로고침)의 의미 : 서버로부터 새로운(갱신된) 페이지를 받는다는 의미
	
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	1. 일반적인 출력 담당 : <%= 100+200+300 %><br>
	2. sendRedirect
	<%
		// response.sendRedirect("Ex01_index.jsp");
	%>
	
	<script>
		location.href="Ex01_index.jsp"
	</script>
</body>
</html>