package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;

public class MemberLoginService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		ActionForward forward = new ActionForward();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();

		switch (dao.loginMember(id, pwd)) {
		case 1:
			// 로그인
			forward.setRedirect(false);
			forward.setPath("moveMain.Member");
			session.setAttribute("userid", id);
			break;
		case 2:
			// 패스워드 다름
			forward.setRedirect(true);
			forward.setPath("moveLogin.Member");
			break;
		case 3:
			// 아이디가 없음
			forward.setRedirect(true);
			forward.setPath("moveJoin.Member");
			break;
		default:
			break;
		}

		return forward;
	}

}