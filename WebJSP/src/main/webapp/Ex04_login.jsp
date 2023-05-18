<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1. 한글처리
		2. 데이터 받기
		3. 로직처리(비지니스) >> DB 작업 >> 암호화 작업 >> 요구사항 정의

		내장객체(WAS : 톰켓)를 가지고 있는 자원
		1. request
		2. response
		3. session
		4. application
		5. out(출력 담당 객체)
	 */
	 
	request.setCharacterEncoding("UTF-8");
		
	String id = request.getParameter("id");
	
	// 비즈니스 로직
	// MemberDao dao = new MemberDao();
	// MemberDto dto = dao.getEmpListById(id);
	// 화면 출력
	
	// 1. 클라이언트가 서버에 요청(request)
	// 2. 서버에 들어온 요청 한 페이지당 한개의 요청 객체 생성
	// 3. 요청은 클라이언트의 다양한 정보를 담는다
	
	// request 객체가 가지는 다양한 자원 살펴보기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	입력값 : <%= id %><hr>
	접속한 클라이언트 IP : <%= request.getRemoteAddr() %><hr> <!-- 클라이언트 IP 정보 -->
	서버 인코딩 : <%= request.getCharacterEncoding() %><hr> <!-- UTF-8로 바꿨으니까 당연히 UTF-8이 뜰걸? -->
	포트 : <%= request.getServerPort() %><hr> <!-- 현재 Port 번호 -->
	<!-- getContextPath() : 사이트명, 가상 디렉토리, 홈 디렉토리, default 웹 경로 -->
	파일 업로드(자료실) : <%= request.getContextPath() %>
</body>
</html>