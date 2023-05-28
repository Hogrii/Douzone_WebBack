package kr.or.kosa.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDAO;
import kr.or.kosa.dto.MemoDTO;

public class MemoWriteServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String memo = request.getParameter("memo");

		try {
			MemoDAO dao = new MemoDAO();
			int n = dao.insertMemo(new MemoDTO(id, email, memo));
    		List<MemoDTO> memoList = dao.getMemoList();    		
    		request.setAttribute("memoList", memoList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("memolist.jsp");

		return forward;
	}

}
