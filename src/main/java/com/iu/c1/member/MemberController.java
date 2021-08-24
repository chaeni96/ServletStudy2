package com.iu.c1.member;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

public class MemberController {
	
	public void start(HttpServletRequest request) {
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
		}else if(path.equals("memberPage.do")) {
			System.out.println("myPage 진행");
		}else {
			System.out.println("그 외 나머지");
		}
		
		
		
	}

}
