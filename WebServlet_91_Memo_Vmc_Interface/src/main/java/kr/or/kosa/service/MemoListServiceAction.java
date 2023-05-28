package kr.or.kosa.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDAO;
import kr.or.kosa.dto.MemoDTO;

public class MemoListServiceAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
    	// 목록보기
    	MemoDAO dao = new MemoDAO();
    	try {
    		List<MemoDTO> memoList = dao.getMemoList();    		
    		request.setAttribute("memoList", memoList);
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("memolist.jsp");
		
		return forward;
	}

}
