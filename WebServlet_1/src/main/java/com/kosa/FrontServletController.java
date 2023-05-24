package com.kosa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServletController
 */
@WebServlet("/action.do")
public class FrontServletController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 데이터 받기
		String cmd = request.getParameter("cmd");
		// 판단하기
		if(cmd.equals("greeting")) {
			// 데이터 저장
			request.setAttribute("msg", new Message());
			request.setAttribute("getmsg", new Message().getMessage(cmd));
		}
		// 뷰페이지 설정
		RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		// 뷰페이지 전달
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
