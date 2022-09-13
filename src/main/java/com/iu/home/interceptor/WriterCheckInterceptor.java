package com.iu.home.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		String method = request.getMethod();
		
		if (method.equals("POST")) {
			
			return ;
		}
	 // 로그인 사용자의 ID와 DTO의 작성자가 일치하는가?
		// 로그인 사용자 정보 

		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		// DTO writer 정보
		Map<String , Object> map =modelAndView.getModel();
		//map.keySet();// 맵에 있는 키들을 set타입으로 모아 둔 것	
		BoardDTO boardDTO = (BoardDTO)map.get("boardDTO");
	
			// 일치 여부
		if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())) {
				
			modelAndView.setViewName("common/result");
			modelAndView.addObject("result",1);
			modelAndView.addObject("message", " 작성자만 수정 가능합니다. ");
			modelAndView.addObject("url","./list.iu");
		}
	
	
	}

}
