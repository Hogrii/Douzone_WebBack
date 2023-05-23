<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="/error/commonError.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		Error(예외 상황) >> 특정 처리 페이지 제작
		
		1. 페이지마다 설정을 통해서 예외 페이지 강제
		2. 전역적인 방법으로 웹 사이트 전체 예외 페이지 강제 >> web.xml
		
		실제 개발시에는 오류페이지를 봐도 괜찮음
		다만, 최종 배포때는 안됨
	 -->
	 <%
	 	String data = request.getParameter("name");
	 	String data2 = data.toLowerCase();
	 %>
	 전달받은 내용 : <%= data %>
</body>
</html>