<%@page import="kr.or.kosa.dto.Emp"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  <!-- c는 uri에 접근할 수 있는 변수명이 되겠다 -->
<%
	Emp e = new Emp(2000, "kosauser");

	Map<String, String> hp = new HashMap<>();
	hp.put("data", "1004");
	
	request.setAttribute("emp", e); // EL 사용가능
									// >> EL은 자바 객체에 대해 직접적인 접근이 불가하기 때문에 request, session을 이용해야한다
	// 권장 방법
	request.setAttribute("vhp", hp);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>기존 방식</h3>
	<%= e %><br>
	<%= e.getEmpno() %><br>
	<%= e.getEname() %><br>
	
	<h3>EL</h3>
	EL() : 자바 객체 출력(자바 객체에 대해서 직접 접근 불가) : ${e}<br>
	EL() : ${e.getEmpno()}<br>
	
	<h3>해결사</h3>
	1. 방법 : request 객체 또는 session 객체에 담는다 >> good<br>
	EL : ${requestScope.emp }<br> <!-- requestScope를 이용해 requset에서 객체를 가져온다 -->
	EL : ${requestScope.emp.empno }<br>
	EL : ${requestScope.emp.ename }<br>
	
	2. 방법(JSTL)<br>
	2.1 JSTL : jar 추가
	2.2 taglib를 통해 자원을 추가(namespace 명시) >> 사용은 prefix 이름으로 한다
	<!-- 
		JSTL 이란?
		JSP Standard Tag Library의 약자로 JSP 표준 라이브러리이다.
		: JSP에서 자주 사용하는 기능(반복문과 조건문, 데이터 표현 등)을 미리 구현해 놓은 커스텀 태그 라이브러리 모음이다.
		: JSTL은 EL을 사용하여 표현한다.
		Apache 재단에서 진행하는 custom tag library 프로젝트
		– 스크립트 릿으로 작성해야할 로직을 태그로 대신 처리 가능
		– apache에서 다운받아 lib에 추가.
	-->
	<h3>JSTL(core) : 변수, 제어문(자바코드 없이 사용) : 서버에서 실행</h3>
	<c:set var="m" value="<%= e %>"></c:set><br> <!-- c:set은 변수를 만드는 함수 -->
	JSTL을 사용해서 변수 m을 생성(EL을 사용해서 접근이 가능하다) : ${m}<br>
	${m.getEmpno()}<br> <!-- 자바 객체에 대해 접근이 불가하지만 JSTL을 사용해서 만든 객체에는 접근이 가능하다-->
	
	<!-- get를 직접 사용하는 것은 권장하지 않는다 -->
	EL출력(m.memberfield명 : 자동으로 getter 함수 호출) : ${m.empno }<br>
	EL출력(m.memberfield명 : 자동으로 getter 함수 호출) : ${m.ename }<br>
	
	<!-- 
		EL 출력목적 : request, session에 담긴 값을 출력
		JSTL : EL을 도와 변수, 제어구조 출력을 돕는다
	 -->
	
	<c:set var="username" value="${m.ename}" />
	변수값 출력 : ${username }<br>
	
	<hr>
	<h3>JSTL 변수 만들고 scope 정의하기</h3>
	<c:set var="job" value="농구선수" scope="request" />
	당신의 직업은 : ${job }<br>
	만약 include, forward를 한다면 해당 페이지에서도 job이라는 값을 출력할 수 있다
	
	<br><br>
	<c:set var="job2" value="야구선수" />
	값 출력 : ${job2 }<br><br>
	
	잘쓰지는 않음(재미로 보기)<br>
	<c:remove var="job2" />
	변수가 없어도 예외가 발생하지 않는다 >> 값이 안나올 뿐 : ${job2}
	<hr>
	JAVA API 활용 객체(또는 내가 직접 만든 객체)는 EL 접근이 안된다 : ${hp }
	1. 권장방법 : request, session에 담는다<br>
	2. JSTL prefix:set 사용
	<hr>
	<c:set var="vhp" value="<%= hp %>" />
	hp 객체(JSTL) : ${vhp }<br>
	hp 객체(JSTL) : ${vhp.data }<br>
	hp 객체(Scope) : ${requestScope.vhp }<br>
	hp 객체(Scope) : ${requestScope.vhp.data }<br>	
</body>
</html>
