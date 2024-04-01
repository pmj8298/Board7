package com.board.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		
		// 1. 세션에서 회원정보를 검색
		HttpSession session  = request.getSession();
		//UserVo userVo = session.getAttribute("login"); -부모를 자식에게 넘겨 줄 수 없음
		Object obj = session.getAttribute("login");
		
		// 요청한 주소정보 확인
		String requestUrl = request.getRequestURL().toString();
		// /login 페이지는 체크에서 제외한다(제외 설정)
		// Interface 설정하는 곳에서 해당경로를 제외할 때 if()필요없다
		// 로그인 안된 사람은 회원게시판 못가게 만들고, 로그인 필요없는 게시판은 여기서 튕굼
		//if(requestUrl.contains("/login")) {
		//	return true; // 로그인 체크를 중단
		// }
		
		/*로그인 체크 기능을 중지하려면 이 부분을 주석으로 표시
		//---------------------------------------------------
		if(obj == null) {
			// 로그인되어 있지 않다면 /loginForm 으로 이동 -> 이게 핵심!!
			response.sendRedirect("/loginForm");
			return false;
		}
		*/
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
