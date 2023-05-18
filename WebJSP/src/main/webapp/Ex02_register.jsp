<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1. 클라이언트에서 전송된 데이터 받기
		1.1 Tomcat(내장 객체) : 클라이언트가 요청을 보내면 요청한 건에 대해 서버는 request 객체를 자동으로 생성
		>> HttpServletRequest request = new HttpServletRequest();
		1.2 자동 생성된 request 객체는 클라이언트의 다양한 정보를 담고 있다 : 다양한 정보(입력 데이터 + ip + 브라우저 정보)
		1.3 request 요청 객체에서 필요한 자원을 불러내면 된다
		
		GET >> jsp?userid=jhlee&pwd=1004&hobby=a&hobby=b&hobby=c
		POST >> jsp(http 숨겨서 ..)
	 */
	
	// post 전송에 대해
	request.setCharacterEncoding("UTF-8");
	 
	String uid = request.getParameter("userid");
	String pwd = request.getParameter("pwd");
	
	// hobby > input 태그의 name이 동일
	// getParameterValues를 이용해 배열로 받는다
	String[] hobby = request.getParameterValues("hobby");
	
	/*
		한글처리
		전송방식
		
		get방식(한글깨짐)
		>> Tomcat9 버전부터 get 방식 >> 한글 처리 자동 지원
		
		post방식(한글깨짐) http://localhost:8090/WebJSP/Ex02_register.jsp
		>> 별도의 한글 깨짐 방지 처리
		>> request 안에 있는 자원에 UTF-8로 인코딩 처리
		>> request에서 데이터를 꺼내기 전에 처리해주면 된다
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 서버에서 클라이언트에게 응답을 줄 수 있음 -->
	ID : <%=uid %><br>
	PWD : <%=pwd %><br>
	hobby :
	<%
		for(String str : hobby) {
	%>
		<b><%=str%></b>
	<%		
		}
	%>
</body>
</html>