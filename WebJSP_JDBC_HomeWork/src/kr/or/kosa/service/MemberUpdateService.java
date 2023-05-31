package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;
import kr.or.kosa.dto.MemberDTO;

public class MemberUpdateService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");

		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setAge(age); 
		dto.setGender(gender);
		dto.setEmail(email);
		
		MemberDAO dao = new MemberDAO();
		dao.updateMember(dto);		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("list.Member");
		return forward;
	}

}
