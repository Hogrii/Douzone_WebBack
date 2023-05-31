package kr.or.kosa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;
import kr.or.kosa.dto.MemberDTO;

public class MemberSearchService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.searchByMemberName(request.getParameter("search"));
		
		request.setAttribute("memberList", memberList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("moveSearch.Member");
		return forward;
	}
}
