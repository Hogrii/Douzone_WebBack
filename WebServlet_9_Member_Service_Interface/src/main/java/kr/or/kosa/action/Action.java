package kr.or.kosa.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서비스 클래스의 모든 함수는 동일한 return type과 parameter를 가지고 사용되었으면 좋겠다
public interface Action {
	// interface를 구성하는 모든 함수는 {}가 없음
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
