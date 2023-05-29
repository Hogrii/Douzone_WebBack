package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;

public class MemberDetailService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		dao.detailMember(id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Ex03_MemberDetail.jsp");
		return forward;
	}

}
