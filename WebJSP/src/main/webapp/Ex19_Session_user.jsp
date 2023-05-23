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
		session 객체(자원 가지고 놀기)
		
		1. session 객체(사용자마다 부여되는 고유한 객체)
		  >> 접속하는 사용자에 구분(sessionID)
		  >> 접속한 사용자마다 다른 정보를 관리(고유하게 부여되는 session 객체를 통해서 관리)
		  >> session.setAttribute()
		  ex) 로그인한 사용자 ID를 서버에서 가지고 다니고 싶다
		    session.setAttribute("id", request.getParameter("userid"));
		
		접속자가 3명
		
		김유신 >> 서버(session 객체 생성) >> 고유한 key 생성(식별값) >> 사용자 id 저장
		-> session 객체 >> id, kim
		이순신 >> ..
		-> session 객체 >> id, lee
		... 
	 -->
	 <h3>세션 정보</h3>
	 sessionID : <%= session.getId() %>
	 <hr>
	 <%
	 	String userid = request.getParameter("userid");
	 	// Point : 필요에 따라 session 객체에 저장하고 필요시 사용하면 된다
	 	session.setAttribute("id", userid); // 서버에 저장
	 %>
	 
	 <h3>내가 저장한 세션값이 필요할 때</h3>
	 <%
	 	String id = (String)session.getAttribute("id"); // Object로 반환하기 때문에 다운캐스팅 필수
	 	out.print("당신의 ID는 " + id + "입니다 ^^");
	 %>
	 <!-- 
	 	request 객체 유효범위 : 요청한 페이지에서 사용 가능, 단) include, forward가 있으면 해당 페이지에서 사용 가능
	 	session 객체 유효범위 : webApp 안에 있는 모든 페이지
	  -->
</body>
</html>