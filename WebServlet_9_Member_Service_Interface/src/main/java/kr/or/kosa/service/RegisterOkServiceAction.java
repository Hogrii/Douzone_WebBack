package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.RegisterDAO;
import kr.or.kosa.dto.RegisterDTO;

public class RegisterOkServiceAction implements Action {
	// Add unimplemented methods

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");

		RegisterDAO dao = new RegisterDAO();
		RegisterDTO dto = new RegisterDTO();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);

		int result = dao.writeOk(dto);

		String resultdata = "";
		if (result > 0) {
			resultdata = "welcome to kosa " + dto.getId() + "님";
		} else {
			resultdata = "Insert Fail ..... retry...";
		}
		// 4. 데이터 저장
		request.setAttribute("data", resultdata);

		// 뷰 설정하기
		// viewpage = "/WEB-INF/views/register/register_welcome.jsp";

		// ActionForward 객체를 통해(viewpage: redirect, forward) 지정, 경로 설정

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/register/register_welcome.jsp");
		
		return forward;
	}

}
