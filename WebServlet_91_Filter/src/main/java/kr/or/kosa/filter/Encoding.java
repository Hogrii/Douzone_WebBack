package kr.or.kosa.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class Encoding
 */
@WebFilter("/Encoding")
public class Encoding extends HttpFilter implements Filter {
	// 추가 코드
	// member field 생성
	private String encoding; // null
	
    public Encoding() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(FilterConfig fConfig) throws ServletException {
		// 최초 요청시 컴파일되고 한번만 실행
		// 다시 실행될 때 : 코드 수정, 서버 리부팅
		// web.xml에 설정되어 있는 초기값을 읽는다 -> FilterConfig
		System.out.println("init");
		this.encoding = fConfig.getInitParameter("encoding");
		System.out.println("filter init 함수 실행 : " + this.encoding);
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	// 처리하는 함수
	// request, response 호출
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// chain.doFilter를 기준으로 앞 쪽에 
		// request 요청에 대한 필터를 실행하는 코드를 만들면 된다
		if(request.getCharacterEncoding() == null) {
			System.out.println("before : " + request.getCharacterEncoding());
			
			request.setCharacterEncoding(this.encoding);
			
			System.out.println("after : " + request.getCharacterEncoding());
		}
		
		chain.doFilter(request, response); // 필터가 더 존재한다면 다음 doFilter를 호출
		
		// chain.doFilter를 기준으로 뒷 쪽에
		// response 응답에 대한 필터를 실행하는 코드를 만들면 된다
		System.out.println("응답처리 실행 영역");
	}
}
