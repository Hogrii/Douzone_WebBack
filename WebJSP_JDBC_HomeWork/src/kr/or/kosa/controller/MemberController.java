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
import kr.or.kosa.service.MemberListService;
import kr.or.kosa.service.MemberLoginService;
import kr.or.kosa.service.MemberLogoutService;
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
		}else if(urlcommand.equals("/list.Member")) {
			// 리스트
			action = new MemberListService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/logout.Member")) {
			// 로그아웃
			action = new MemberLogoutService();
			forward = action.execute(request, response);
		}else if(urlcommand.equals("/moveDetail.Member")) {
			// 디테일로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/member/Ex03_MemberDetail.jsp");			
		}else if(urlcommand.equals("/moveLogin.Member")) {
			// 로그인으로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/login/Ex02_JDBC_Login.jsp");
		}else if(urlcommand.equals("/moveMain.Member")) {
			// 메인으로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/member/Ex02_JDBC_Main.jsp");
		}else if(urlcommand.equals("/moveJoin.Member")) {
			// 회원가입으로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/join/Ex02_JDBC_JoinForm.jsp");
		}else if(urlcommand.equals("/moveSearch.Member")) {
			// 검색리스트로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/member/Ex03_MemberSearch.jsp");
		}else if(urlcommand.equals("/moveEdit.Member")) {
			// 편집페이지로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/member/Ex03_MemberEdit.jsp");
		}else if(urlcommand.equals("/moveList.Member")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/member/Ex03_Memberlist.jsp");
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
