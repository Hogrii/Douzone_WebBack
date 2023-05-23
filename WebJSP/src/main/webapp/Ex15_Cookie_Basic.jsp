<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	정보(자료) 데이터 저장 >> 어디에?
	
	웹이라는 환경 관점 >> 데이터는 어디에 저장?
	웹 -> 클라이언트(개인 로컬 컴퓨터), 서버(웹 서비스가 가능한 컴퓨터 or DB)
	
	저장시 고민(기준점) : 보안(데이터의 중요성), 소멸(일시, 영속)
	-> 보안 : 클라이언트 - 서버
	-> 소멸 : 메모리, 파일, DB
	
	Client(Local PC) : 웹 브라우저
	1. Cookie(메모리 쿠키, 파일 쿠키(local 디스크에 txt 형태로 암호화하여 저장 : 소멸 시간을 갖고 있음) ***
		-> Session : 메모리 쿠키
		-> 기간 : 파일 쿠키
		-> 단점) 
	2. Local Storage(key, value) 형태 >> JSON 형태로 read, write
		-> 장점) 크기, 객체 사용(데이터 : 의미있는 데이터 저장)

	Server(웹 서버(WAS) : 메모리 + 파일(보조), DB서버)
	1. server memory : session 객체(사이트에 접속하는 [사용자]마자 고유하게 부여되는 메모리)
		-> session은 20분 지나면 사라짐 >> 마지막 행동 후 20분이라서 계속 활동하면 갱신됨
	2. server memory : application 객체(사이트에 접속하는 [모든 사용자]에게 부여되는 메모리)
	3. server 영속적 : 파일.txt(관리가 힘들다)
	4. DB server : 보안, 영속적인 데이터 관리 >> 비용 >> 클라우드
	
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 서버 쿠키 생성
		// 첫번째 : 쿠키 이름
		// 두번째 : 쿠키 값
		Cookie mycookie = new Cookie("cname", "1004"); // javax -> Apache Tomecat꺼
		
		// Cookie를 클라이언트에게 전달 : response
		response.addCookie(mycookie);
	%>
	<a href="Ex16_Cookie_Read.jsp">Cookie read</a>
</body>
</html>