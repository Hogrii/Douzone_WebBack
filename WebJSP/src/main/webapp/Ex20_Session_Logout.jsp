<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 (session 객체 소멸 )
	session.invalidate(); // invalidate()는 session을 삭제해주는 것
	out.print("<script>location.href='Ex20_Session_Login.jsp'</script>");
%>
