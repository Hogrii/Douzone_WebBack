<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet 요청하기</title>
</head>
<body>
	<h3>요청 처리하기</h3>
	<h3>getContextPath</h3>
	<%= request.getContextPath() %>
	<hr>
	<a href="<%= request.getContextPath() %>/simple">simple 요청하기(GET)</a>
	<br>
	<a href="<%= request.getContextPath() %>/simple?type=date">날씨 요청하기(GET)</a>
	<br>
	<a href="<%= request.getContextPath() %>/simple?type=abcd">비정상 요청하기(GET)</a>
	<hr>
	<h3>FrontServletController 사용하기(게시판 요청 Command 방식으로 servlet 하나가 모두 처리)</h3>
	<a href="<%= request.getContextPath() %>/Board?cmd=boardlist">게시판 목록보기</a>
	<br>
	<a href="<%= request.getContextPath() %>/Board?cmd=boardwrite">게시판 글쓰기</a>
	<br>
	<a href="<%= request.getContextPath() %>/Board">cmd null Error 페이지</a>
	<br>
	<a href="<%= request.getContextPath() %>/Board?cmd=boarddelete">게시판 삭제하기</a>
	<br>
	<a href="<%= request.getContextPath() %>/Board?cmd=login">보안 페이지 로그인 처리</a>
	<br>
	
	<!-- 20230524 -->
	<h3>FrontServletController</h3>
	<a href="<%= request.getContextPath() %>/action.do?cmd=greeting">GET요청..</a>
	<br>
	<!-- 
		com.kosa > FrontServletController Servlet 생성 > urlPatter = /action.do > doGET() 작업
		view page > webapp > greeting.jsp
		cmd=greeting >> 1. greeting > Message 객체 생성 > function parameter로 greeting 제공
		Message 객체 저장
		view page > greeting.jsp 전송
		view page > 객체 출력
	 -->
</body>
</html>