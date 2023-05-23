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
		서버에 접속한 클라이언트가 도메인별로 가지고 있는 쿠키 기록 읽기
	 -->
	<%
		// 모든 쿠키(domain) 가져오기
		Cookie[] cs = request.getCookies();
	if(cs != null || cs.length > 0) {
		for(Cookie c : cs) {
			out.print("c.getName : " + c.getName() + "<br>");
			out.print("c.getValue : " + c.getValue() + "<br>");
			out.print("c.getMaxAge : " + c.getMaxAge() + "<br>"); // 소멸시간이 없다(메모리 쿠키(session에 종속되어 있음)) >> -1 출력
			out.print("c.getDomain : " + c.getDomain() + "<br>");
		}
	}
	%>
</body>
</html>