<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// java 코드를 쓰는 영역
	// jsp 파일에서는 우리가 원하는 모든 작업 가능(DB 연결 > 실행 > 결과 > 화면 출력) > jsp(웹에서 필요한 모든 작업 가능)
	// jsp
		// 장점 : 쉽고 빠름, 모든 개발자가 쉽게 웹을 만들 수 있게 했다
		// 단점 : 분업화가 힘듦, 유지보수가 좋지 않다 >> 관심사가 분리되어 있지 않음
	
	Date date = new Date();
	/*
		JSP 페이지 : UI(html+css+javascript) + Java(<% 스크립트릿 안에 구현)
		>> 디자인 코드 + 서버의 로직 코드 : 문제점 > 협업, 유지보수하기 어렵다
		
				Servlet(형) > 웹 전용 Java 파일 > jsp(동생)
		>> Java 웹 기반 기술이 아님 > 계산기, 그림판, 윈도우 프로그램(awt, swing) > 웹 전향(객체: request, response)
		>> Java 페이지 Web을 서비스 하자 > login.java > loginok.java(웹 객체 상속) > 웹에서 사용하는 자바 파일(Servlet)
		>> 단점 : 배우기 어렵다, 디자인 작업이 힘들다, 협업이 안된다
			>> JSP가 탄생
			>> 장점 : 웹 페이지 UI 작업을 html로 진행 >> 디자인이 좋아짐
			>> 단점 : Java 코드를 스크립트릿 안에 혼재 >> Java + UI
		
		정리) 서로의 장점을 살리자(현대적인 프로그래밍은 업무 효율을 위해 잘하는 것을 키워줌) >> MVC 패턴 도입
		>> JSP + Java + Servlet
			>> Model(DTO, DAO) >> Java
			>> View(UI) >> JSP
			>> Controller(request, response) >> Servlet
		** MVC 패턴으로 현재까지 개발이 진행되고 있음
		>> model1(JSP로 모든 요청과 응답을 처리) + Model >> 동생에게 게시판 하나 만들어 주고 싶어요 >> 개인 환경
		>> model2(Servlet을 통해 요청과 응답을 처리) + MVC >> "model2 기반의 MVC 패턴으로 프로젝트 해봤어!" >> 기업 환경
		
		서버
		html 서비스 >> 웹 서버만 있으면 됐었음(Apache)
		ex) Apache 설치 >> 특정 폴더 >> index.html, login.html, login.css >> 요청 >> http://www.it.co.kr/login.html
			>> Apache 웹 서버 >> 요청을 받아서 login.html의 존재 확인 >> 클라이언트에게 전달 >> 클라이언트 웹 브라우저가 해석하고 화면에 출력
		
		JSP or Servlet 사용
		ex) Tomcat(Apache Tomcat 설치) >> 웹 서버 + WAS >> 요청(request) >> http://www.it.co.kr/login.jsp >> 실행 파일을 찾는다
			>> 실행 파일이 없으면 JSP를 컴파일 >> class 파일을 생성 후 실행(정적 데이터 + 서버코드 실행 >> 동적 데이터(서버코드를 실행해서 만든 텍스트 데이터))
			>> 결합된 결과(클라이언트 웹 브라우저가 해석 가능한 파일)를 클라이언트에게 응답(response)

			WAS >> JSP request >> 컴파일(login.jsp.java) >> 실행(login.jsp.class) >> (정적 + 동적) 데이터 >> response
			C:\Douzone\Web\WebBack\WebLabs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WebJSP\org\apache\jsp에 class 파일 있음
			
		상식 퀴즈)
		ASP, ASPX, PHP, JSP의 공통점은?
		> 코드 노출이 안된다 >> 보안에 좋다 >> 클라이언트는 실행 결과만 갖음(text or html 형태)
		
		서버 오픈(2023 05 18 12:00)
		최초 요청자 홍길동 >> http://www.it.or.kr/default.jsp
		WAS >> 처음 실행되는지 기존에 실행 되었는지 확인
			>> 처음이기 때문에 실행파일이 없다 >> 컴파일 >> class 생성 >> 실행 >> (정적 + 동적) 데이터 결합 >> 응답
		
		두번째 요청자 김유신 >> http://www.it.or.kr/default.jsp
		WAS >> 두번째이기 때문에 실행파일이 존재 >> 실행 >> (정적 + 동적) 데이터 결합 >> 응답
		
		질문) JSP를 다시 컴파일하고 실행파일이 만들어지는 때는 언제일까?
		1. 개발자가 코드를 수정한 뒤 배포
		2. 웹서버 재시작
	 */
 %>
<%
	/*
		JSP 구성요소
		1. 선언부 : page 지시지 >> 사용언어, 인코딩, 임포트
			>> <%@ page language="java" 
			>> <%@page import=
		2. 스크립트 요소
		2.1 스크립트 릿 <% Java 코드 쓰는 영역
		2.2 표현식(출력하는 방법) : 출력하는 대상(Client 브라우저) : <%= >> response.write
		2.3 선언부(공통자원) : <%! 
	 */
%>

<%
	// Java 코드
	String name = "hello world";
%>
<%!
	// 공통함수 영역
	// page 안에서만 사용
	public int add(int i, int j) {
		return i+j;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP 실행하기</h3>
	날짜 : <%=date %> <!-- 데이터 사용 -->
	<%=name %><br>
	<%=add(100, 200) %><br>
	<%
		int result = add(1, 2);
	%>
	결과 : <%=result %>	
</body>
</html>