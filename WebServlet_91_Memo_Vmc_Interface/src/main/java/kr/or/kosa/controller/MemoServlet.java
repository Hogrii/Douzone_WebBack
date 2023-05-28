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
import kr.or.kosa.service.MemoWriteServiceAction;

@WebServlet("/MemoServlet")
public class MemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.한글처리
		// 2.데이터 받기
		// 3.DB연결
		// 4.Insert 실행
		// 5.응답구성

		request.setCharacterEncoding("UTF-8");

		Action action = null;
		ActionForward forward = null;

		// Client 요청(1. 화면주세요(service 필요x), 2. 처리해주세요(service 필요o))
		action = new MemoWriteServiceAction();
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
		System.out.println("get방식");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post방식");
		doProcess(request, response);
	}

}
