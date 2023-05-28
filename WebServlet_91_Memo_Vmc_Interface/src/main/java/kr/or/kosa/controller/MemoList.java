package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.MemoListServiceAction;

@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemoList() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("글 목록 보기");

		// 판단(Front ....) 클라이언트 요청 확인
		// 요청마다 servlet 판단이 필요 없다
		request.setCharacterEncoding("UTF-8");
		Action action = null;
		ActionForward forward = null;

		action = new MemoListServiceAction();
		forward = action.execute(request, response);

		if (forward != null) {
			if (forward.isRedirect()) {
				// true -> location.href="" 새로운 페이지를 갖겠다
				response.sendRedirect(forward.getPath());
			} else {
				// false -> forward >> view 페이지에서 저장된 자원을 출력
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
