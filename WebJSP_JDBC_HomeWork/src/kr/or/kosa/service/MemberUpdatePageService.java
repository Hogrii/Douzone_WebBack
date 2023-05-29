package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;

public class MemberUpdatePageService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {		
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		dao.updatePage(id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Ex03_MemberEdit.jsp");
		return forward;
	}

}
