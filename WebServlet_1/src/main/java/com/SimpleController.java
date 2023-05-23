package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. SimpleController extends HttpServlet
 *   >> SimpleController는 HttpServlet 파일을 상속하고 있다.
 *   >> SimpleController.java >> 웹에 사용되는 객체를 사용가능 >> 일반 자바 파일이 아니라 웹용 자바 파일이라고 생각
 *   
 *   >> HttpServletRequest request = new HttpServletRequest();
 *   >> 라는 객체가 자동으로 생성 ..
 *   
 *   >> HttpServletResponse response = new HttpServletResponse();
 *   >> 라는 객체가 자동으로 생성 ..
 *   
 *   jsp 파일 -> 주소창 : http://....default.jsp
 *   servlet 파일 -> 주소창 : http://....default.java (x)
 *   
 *   servlet 파일 >> web.xml 파일에서 요청 주소를 설정
 *   [어떤 요청 주소]가 들어오면 SimpleController를 컴파일하고 실행?
 *   
 * web.xml
 * <servlet-name>simpleController</servlet-name>
 * <url-pattern>/simple</url-pattern>
 * 1. http://localhost:8090/WebServlet_1/simple 요청이 오면 
 * 2. <servlet-name>simpleController</servlet-name>
	  <servlet-class>com.SimpleController</servlet-class> 설정의 근거로
	  com.SimpleController.java를 컴파일하고 실행한다
   3. 다음 똑같은 요청이 들어오면 실행파일이 있을 때 실행한다
   
 * 서블릿 조건 : 일반 java 파일이 extends HttpServlet을 상속 >> 웹 요청(request), 웹 응답(response) 객체 사용 가능
 * -servlet url 요청을 바로 할 수 없음 >> 요청 >> mapping >> xml or annotation
 * 
 * 1. web.xml(옛날방식)
 * 2. @WebServlet(최신방식) >> @WebServlet("/Simple") >> xml없이도 mapping이 가능하다
 * 
 * 
 * 
 * protected void doGet() 함수
 * ex) http://localhost:8090/WebServlet_1/simple
 * 
 * protected void doPost() 함수
 * ex) http://localhost:8090/WebServlet_1/simple >> form을 만들고 method=post 지정
 * 
 * 명시적인 호출에 의해 동작
 * 
 * 2개의 함수는 어떤 사건이 발생하면 자동 호출이 되도록 설정되어 있음
 * Ex) Javascript 이벤트 >> 자동 함수 호출(onload -> 사건 발생시 핸들러 함수 자동 호출)
 * 
 * doGET(), doPOST()
 * 1. request 객체, response 객체를 가지고 데이터 처리
 */

// @WebServlet("/SimpleController")
public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SimpleController() {
        super();
        System.out.println("SimpleController 생성자 함수 실행 : 초기화");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청 : GET");
		
		// JSP에서 사용했던 방식과 동일
		// 1. 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 데이터 받기(회원가입, 게시판 글쓰기, 로그아웃)
		String type = request.getParameter("type");
		
		// 3. 로직(업무 수행) >> 서비스 수행
		Object resultobj = null;
		if(type==null || type.equals("greeting")) {
			resultobj = "hello world";
		}else if(type.equals("date")) {
			resultobj = new Date();
		}else {
			resultobj = "invalid string type";
		}
		System.out.println(resultobj);
		// MVC 패턴 흉내.. JSP가 있는 시절,,
		// 4. JSP(view) 데이터 출력을 하려면 >> servlet이 가지고 있는 자원을 View에게 전달
		
		// 결과 : application, session(scope : web 전체), request(scope : page 한정,, 단, include, forward) 객체에 저장
		// 내가 만든 자원이 모든 페이지에서 필요하지 않다면? -> session에서 사용할 필요가 없음.. >> request를 사용한다,, 다른페이지에 쓰고 싶으면 forward 사용..
		request.setAttribute("result", resultobj);
		
		// 5. 저장한 결과를 JSP 페이지에 전달(UI 구성)
		// 현재 : webapp > simpleview.jsp
		// 개발 : webapp > WEB-INF > views > board > board.jsp
		
		// getRequestDispatcher >> view 페이지를 지정합니다
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		dis.forward(request, response); // 현재 내가 가지고 있는 request 객체의 주소값을 forward 시킨다 >> parameter로..
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
