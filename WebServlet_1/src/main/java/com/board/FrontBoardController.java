package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontBoardController
 */
@WebServlet(description = "게시판 front 컨트롤러 입니다", urlPatterns = { "/Board" })
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public FrontBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

    // 요청(동기식) >> doGet, doPost 실행 >> 로직이 동일하다면? -> 하나의 함수를 만들어서 호출하기~ >> private void doProcess
	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		// Get 요청이나, Post 요청 둘 다 doProcess가 처리하게 한다
		System.out.println("클라이언트 요청 방식 : " + method);
		
		// 1. 한글처리
		// 2. 요청받기(request)
		// 3. 요청판단(기준 : 1. parameter 사용하기 : cmd=value >> cmd가 가지는 값에 따라 판단 >> command 방식
		// 	ex) http:192.168.0.52:8080/Web/Board?cmd=list >> 글목록
		// 	ex) http:192.168.0.52:8080/Web/Board?cmd=write >> 글쓰기 >> 약속
		// 4. 결과저장(application, session, request)
		// 5. View 지정
		// 6. View에 결과(session, request)를 forward 방식으로 전달 >> 클라이언트의 주소는 변하지 않고 내용들을 보낼 수 있음
		
		// 1.
		request.setCharacterEncoding("UTF-8");
		
		// 3.
		String cmd = request.getParameter("cmd");
		
		// 2.
		String viewpage = null;
		// cmd >> null >> error.jsp
		// cmd >> boardlist >> list.jsp
		// cmd >> boardwrite >> write.jsp 서비스
		if(cmd==null) {
			viewpage = "/error/error.jsp";
		}else if(cmd.equals("boardlist")) {
			/*
			   DB연결 >> select >> 객체담기
			   boardDao dao = new boardDao();
			   List<Board> boardlist = dao.selectBoardList();
			   request.setAttribute("list", boardlist);
			   forward >> view >> jsp >> request.getAttribute("list");
			 */
			viewpage = "/board/boardlist.jsp";
		}else if(cmd.equals("boardwrite")) {
			viewpage = "/board/boardwrite.jsp";
		}else if(cmd.equals("boarddelete")) {
			viewpage = "/board/boarddelete.jsp";
		}else if(cmd.equals("login")) {
			viewpage = "/WEB-INF/views/login/login.jsp"; // 보안폴더이지만 안에서는 접근이 가능하다!! 밖에서만 접근을 못할 뿐.. // 개발시 이렇게 적을것 같음
		}else {
			viewpage = "/error/error.jsp";
		}
		// 결과 저장
		// 결과를 저장했다 치고~
		
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		dis.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
