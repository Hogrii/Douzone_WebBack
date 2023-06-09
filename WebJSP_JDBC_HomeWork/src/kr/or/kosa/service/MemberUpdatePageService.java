package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;
import kr.or.kosa.dto.MemberDTO;

public class MemberUpdatePageService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {		
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		MemberDTO dto = new MemberDTO();
		dto = dao.updatePage(id);
		
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("moveEdit.Member");
		return forward;
	}

}
