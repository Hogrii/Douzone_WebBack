package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.RegisterDAO;
import kr.or.kosa.dto.RegisterDTO;

/**
 * URL 방식(command 방식에도 상관 없다)
 * http://192.168.0.172:8090/WebSite/list.do >> *.do
 * http://192.168.0.172:8090/WebSite/write.do >> *.do
 * 
 * command 방식(parameter 업무 파악)
 * @WebServlet("site.do")
 * http://192.168.0.172:8090/WebSite/site.do?cmd=list
 * http://192.168.0.172:8090/WebSite/site.do?cmd=write
 */
@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontRegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 한글처리
		request.setCharacterEncoding("UTF-8");
		// 2. 데이터 받기
//		String cmd = request.getParameter("cmd");
		// 3. 요청 판단하기
		
		// Url 방식으로 요청 판단하기
		// http://192.168.0.46:8090/WebSite/list.do
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestUri.substring(contextPath.length());
		
		System.out.println("requestUri : " + requestUri); // /WebServlet_8_Member_Url/register.do
		System.out.println("contextPath : " + contextPath); // /WebServlet_8_Member_Url
		System.out.println("urlcommand : " + urlcommand); // /register.do
		
		String viewPage = "";
		if(urlcommand.equals("/register.do")) {
			viewPage = "/WEB-INF/views/register/register.jsp";
		}else if(urlcommand.equals("/registerok.do")) {
			RegisterDTO dto = new RegisterDTO();
			dto.setId(Integer.parseInt(request.getParameter("id")));
			dto.setPwd(request.getParameter("pwd"));
			dto.setEmail(request.getParameter("email"));
			
			RegisterDAO dao = new RegisterDAO();
			dao.writeOk(dto);
			
			// 4. 데이터 담기
			request.setAttribute("user", dto);
			
			viewPage = "/WEB-INF/views/register/register_welcome.jsp";
		}
		// 5. 뷰 지정하기
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		// 6. 뷰 전송하기
		dis.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
