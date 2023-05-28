package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.BoardWriteOkServiceAction;
import kr.or.kosa.service.LoginOkServiceAction;
import kr.or.kosa.service.RegisterOkServiceAction;

/**
 * URL 방식(command 방식에도 상관 없다) http://192.168.0.172:8090/WebSite/list.do >> *.do
 * http://192.168.0.172:8090/WebSite/write.do >> *.do
 * 
 * command 방식(parameter 업무 파악) @WebServlet("site.do")
 * http://192.168.0.172:8090/WebSite/site.do?cmd=list
 * http://192.168.0.172:8090/WebSite/site.do?cmd=write
 */
@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontRegisterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 한글처리
		request.setCharacterEncoding("UTF-8");
		// 2. 데이터 받기
		// String cmd = request.getParameter("cmd");
		// 3. 요청 판단하기

		// Url 방식으로 요청 판단하기
		// http://192.168.0.46:8090/WebSite/list.do

		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestUri.substring(contextPath.length());

		System.out.println("requestUri : " + requestUri); // /WebServlet_8_Member_Url/register.do
		System.out.println("contextPath : " + contextPath); // /WebServlet_8_Member_Url
		System.out.println("urlcommand : " + urlcommand); // /register.do

		Action action = null;
		ActionForward forward = null;

		// Client 요청(1. 화면주세요(service 필요x), 2. 처리해주세요(service 필요o))
		if (urlcommand.equals("/register.do")) {
			// UI만 제공하면 된다 -> service 객체 필요 없음
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/register/register.jsp");
		} else if (urlcommand.equals("/registerok.do")) {
			// UI 제공 + 서비스 로직 필요
			action = new RegisterOkServiceAction();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("login.do")) {
			// UI 제공
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/login/login.jsp");
		} else if (urlcommand.equals("loginok.do")) {
			// UI 제공 + 서비스 로직 필요
			action = new LoginOkServiceAction();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/write.do")) {
			// UI만 제공하면 된다 -> service 객체 필요 없음
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/board/boardwrite.jsp");
		} else if (urlcommand.equals("/writeok.do")) {
			// UI 제공 + 서비스 로직 필요
			action = new BoardWriteOkServiceAction();
			forward = action.execute(request, response);
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				// true -> location.href="" 새로운 페이지를 갖겠다
				response.sendRedirect(forward.getPath());				
			}else {
				// false -> forward >> view 페이지에서 저장된 자원을 출력
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
