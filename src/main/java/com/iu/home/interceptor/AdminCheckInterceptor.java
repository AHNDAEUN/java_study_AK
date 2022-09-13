package com.iu.home.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.home.bankMembers.BankMembersDTO;
import com.iu.home.bankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{

	
	//원하는 시점 overriding
	
	
	//~앞에 preHandle
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 1. 로그인 사용자(bankmembersDTO)에서 roleDTO를 꺼내옴
			BankMembersDTO bankMembersDTO =(BankMembersDTO)request.getSession().getAttribute("member");
		// 2. roleDTOs를 반복문 돌려서 roleName꺼내오기
		 boolean check =false;
			for (RoleDTO roleDTO: bankMembersDTO.getRoleDTOs() ) {
			 roleDTO.getRoleNum();
			 System.out.println(roleDTO.getRolename());
			 if(roleDTO.getRolename().equals("admin"));
			 check =true;
			 break;
			}
			
			//admin이 아닐때 (false)
			if(!check) {
				request.setAttribute("message", "권한이 없어요"); //(modl=request)
				request.setAttribute("url", "../../../../");
				RequestDispatcher view=request.getRequestDispatcher("/WEB_INF/views/common/result.jsp"); //("jsp 경로")
			view.forward(request, response);
			
			}
			//권한이 없는 메세지 띄우기
			
		return check; 
				 
				 
				}
	
}
