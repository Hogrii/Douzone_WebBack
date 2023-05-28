package kr.or.kosa.action;

/**
 * 
 * servlet(client) 요청
 * 
 * 1. 화면을 주세요(UI 경로)
 * 2. 처리해 주세요(Service)
 * 
 * 화면 아니면 로직 처리
 *
 */

public class ActionForward {
	private boolean isRedirect = false; // view의 전환(redirect or forward)
	private String path = null; // 이동 경로(view의 주소)
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}