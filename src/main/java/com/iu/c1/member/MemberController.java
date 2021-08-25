package com.iu.c1.member;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {
	
	private MemberService memberService;
	
	public MemberController() {
		memberService = new MemberService();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberController 실행");
		
		String uri = request.getRequestURI();
		
		int index = uri.lastIndexOf("/");
		
		String path = uri.substring(index+1);
		
		if(path.equals("memberLogin.do")) {
			System.out.println("로그인 진행");
			String id = request.getParameter("id");
			String pw= request.getParameter("pw");
			System.out.println(id);
			System.out.println(pw);
			
		}else if(path.equals("memberJoin.do")){
			System.out.println("회원가입 진행");
			
			String method = request.getMethod();
			
			if(method.equals("POST")) {
				int result = memberService.memberJoin(request, response);
				
				if(result>0) {	
					response.sendRedirect("../");
				}else {
					response.sendRedirect("./memberJoin.do");	
				}

			}else {
				
				RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/member/memberJoin.jsp");
				view.forward(request, response);
			}
			
		}else if(path.equals("memberPage.do")) {
			System.out.println("myPage 진행");
		}else {
			System.out.println("그 외 나머지");
		}
		
		
		
	}

}
