package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDAO;
import kr.or.kosa.dto.MemberDTO;

public class MemberJoinService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO dto = new MemberDTO();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("mname");
		int age = Integer.parseInt(request.getParameter("age"));
		char gender = request.getParameter("gender").charAt(0);
		System.out.println("gender : " + gender);
		String email = request.getParameter("email");
		String ip = request.getRemoteAddr();
		
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setEmail(email);
		dto.setIp(ip);
		
		MemberDAO dao = new MemberDAO();
		dao.joinMember(dto);		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/Ex02_JDBC_Login.jsp");
		return forward;
	}

}
