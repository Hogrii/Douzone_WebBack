package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 생성
		// session.setAttribute() 는 jsp에서 사용 가능.. servlet은 java 파일이라 request.getSession()을 통해 접근해야 한다
		HttpSession session = request.getSession(); // getSession() == getSession(true) >> 값이 있으면 리턴, 없으면 생성
		if(session != null) {
			session.setAttribute("name", "홍길동");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
