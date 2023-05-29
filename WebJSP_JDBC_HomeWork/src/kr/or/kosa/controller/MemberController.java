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
import kr.or.kosa.service.MemberDeleteService;
import kr.or.kosa.service.MemberDetailService;
import kr.or.kosa.service.MemberJoinService;
import kr.or.kosa.service.MemberLoginService;
import kr.or.kosa.service.MemberSearchService;
import kr.or.kosa.service.MemberUpdatePageService;
import kr.or.kosa.service.MemberUpdateService;

@WebServlet("*.Member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestURI.substring(contextPath.length());
		
		System.out.println(requestURI);
		System.out.println(contextPath);
		System.out.println(urlcommand);
		
		Action action = null;
		ActionForward forward = null;
		
		if(urlcommand.equals("/join.Member")) {
			// 회원가입
			action = new MemberJoinService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/login.Member")) {
			// 로그인
			action = new MemberLoginService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/delete.Member")) {
			// 삭제
			action = new MemberDeleteService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/moveUpdate.Member")) {
			// 수정 페이지
			action = new MemberUpdatePageService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/update.Member")) {
			// 수정
			action = new MemberUpdateService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/detail.Member")) {
			// 상세정보
			action = new MemberDetailService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/search.Member")) {
			// 검색
			action = new MemberSearchService();
			forward = action.execute(request, response);
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
