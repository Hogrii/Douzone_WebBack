<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection Pool 사용하기</title>
</head>
<body>
	<%
		// JNDI
		Context context = new InitialContext();
		// 현재 [프로젝트]에서 특정 이름을 가진 객체를 검색(이름기반 검색)
		
		// looup 함수 안에 정해진 형식의 이름을 제공
		// 형식 : java:comp/env/ + 이름(우리는 context.xml에 /jdbc/oracle이라고 정함)
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle"); // 튜브 가게 도착(반드시 다 놀고 반환하자)
		
		// 튜브를 주세요
		Connection conn = null;
		conn = ds.getConnection();
		out.print("db 연결여부 : " + conn.isClosed() + "<br>"); // false
		
		// 놀아요
		// 집가고 싶어요
		// 반환
		conn.close(); // 자원 해제가 아니가 connection pool에 반환
		out.print("db 연결여부 : " + conn.isClosed() + "<br>"); // true
		
		// Pool 객체의 scope >> method 단위 >> 사용하고 반환
	%>

</body>
</html>