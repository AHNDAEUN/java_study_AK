package com.iu.home.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{
//	상속받은 메서드를 제정의 하는 것 오버라이딩

	// 특정 url이 오면 interceptor를 거침
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//return true면 Controller로 진행
		//return이 false면 Controller로 진행 x
		System.out.println("controller 진입 전 실행");
		//return super.preHandle(request, response, handler);
		return true;
	
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("Controller에서 DS로 나가기 전");
		super.postHandle(request, response, handler, modelAndView);
	}
}
