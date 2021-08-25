package com.iu.c1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberService {
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	
	//MemberController에 넣는것 대신
	public int memberJoin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDTO memberDTO = new MemberDTO();
		/* 다른 방법
		 String id = request.getParameter("id"); String pw =
		 request.getParameter("pw"); String name = request.getParameter("name");
		 String phone = request.getParameter("phone"); String email =
		 request.getParameter("email");
		  
		 MemberDTO memberDTO = new MemberDTO(); memberDTO.setId(id);
		 memberDTO.setPw(pw); memberDTO.setName(name); memberDTO.setPhone(phone);
		 memberDTO.setEmail(email);
		  
		 int result = memberDAO.memberJoin(memberDTO);
		 */
		memberDTO.setId(request.getParameter("id"));
		memberDTO.setPw(request.getParameter("pw"));
		memberDTO.setName(request.getParameter("name"));
		memberDTO.setPhone(request.getParameter("phone"));
		memberDTO.setEmail(request.getParameter("email"));
		
		//int result = memberDAO.memberJoin(memberDTO)
		//return result;
		
		return memberDAO.memberJoin(memberDTO);
		
	}

}
