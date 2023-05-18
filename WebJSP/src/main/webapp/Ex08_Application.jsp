<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		webproject 생성 >> Template 구조 >> WEB-INF >> web.xml 제공(웹어플리케이션 전체 환경설정)
		web.xml(서버가 시작되면 제일 먼저 loading하고 해석한 뒤 실행) >> <welcome-file>index.htm</welcome-file> : 웹 사이트 기본 페이지 설정
		
		ex) http://192.168.0.172:8090/WebJSP/ >> 엔터 >> 페이지 서비스 >> default 페이지 구성 : welcome-file

		/WebJSP >> 웹 프로젝트 이름, 가상 디렉토리, context root(문맥, 흐름, 전체)
		웹 경로(가상 경로) : http://192.168.0.172:80900/WebJSP
		>> 실경로 : C:\Douzone\Web\WebBack\WebLabs\WebJSP\src\main\webapp 폴더 자원을 서비스 하겠다
		
		서비스 자원 : html, htm, css, js, json, txt, jsp
		>> 생성하는 모든 자원은 scope
		>> a.jsp >> <% String s = "A" >> s 변수는 a.jsp 안에서만 유효
		>> b.jsp >> <% String s = "A" >> s 변수는 b.jsp 안에서만 유효
		>> c.jsp >> <% String s = "A" >> s 변수는 c.jsp 안에서만 유효
		
		a.jsp, b.jsp, c.jsp 페이지에서 공유하는 자원은 어떻게 만들까?
		>> 답은 web.xml 환경설정 >> 서버 시작 후 가장 먼저 해석되고 loading

		<context-param>
			<description>개발자 마음대로</description>
			<param-name>email</param-name>
			<param-value>kosa@kosa.or.kr</param-value>
		</context-param>
		<context-param>
			<description>기본 파일 업로드 경로</description>
			<param-name>filepath</param-name>
			<param-value>C:\Douzone\Web\WebBack\\download</param-value>  	
		</context-param>
		
		web.xml 자원에 접근하는 방법
		Application 객체(WAS 제공)
		Application >> web.xml 접근 >> 자원 read 가능
		
		WebApp 생성 >> WEB-INF 제공받는다 >> lib(jar파일)
									 >> web.xml(환경설정파일)
		WEB-INF 보안폴더 : 클라이언트가 접근하게 되면 없는 페이지(404)를 리턴(접근 불가)
		WEB-INF >> views >> member >> register.jsp 등등
						 >> admin  >> admin.jsp
		클라이언트가 직접 봐서는 안되는 페이지는 보안 폴더에 숨긴다
		include, forward 이런 방식으로.. 보여줌
	 */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Application 객체(WAS 제공)</h3>
	<%
		String param = application.getInitParameter("email");
		out.print("<h3>" + param + "</h3>");
		
		out.print("<hr>");
		
		String param2 = application.getInitParameter("filepath");
		out.print("<h3>" + param2 + "</h3>");		
	%>
</body>
</html>