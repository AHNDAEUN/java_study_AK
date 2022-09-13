package com.iu.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		
		// 로그인 유무 판단 (mypage, QNA_list)
		Object obj = session.getAttribute("member");
		
		if(obj != null) {
			System.out.println("로그인 성공");
			
			return true;
		}else {
			System.out.println("로그인 실패");
			response.sendRedirect("../../../../../member/login.iu");
			return false;
		}
		
		
	}  // 로그인한 사람 통과 로그인 안 한 사람 통과 못함
	
	
	

}
