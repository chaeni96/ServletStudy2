package com.iu.c1.bankbook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BankbookController {
	
	private BankBookDAO bankBookDAO;
	
	public BankbookController() {
		bankBookDAO = new BankBookDAO();
	}
	
	public void start(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Bankbook Controller 실행");
		
		String uri = request.getRequestURI();
		
		int index = uri.lastIndexOf("/");
		
		String path = uri.substring(index+1);
		
		if(path.equals("bankbookList.do")) {
			System.out.println("상품 목록 확인");
			ArrayList<BankBookDTO> ar = bankBookDAO.getList();
			
			//for(초기식;조건식;증감식)
			//for(모은타입명 변수명:컬렉션참조변수명)
				
			for(BankBookDTO bankBookDTO:ar) {
				System.out.println(bankBookDTO.getBookName());
				System.out.println(bankBookDTO.getBookNumber());
				System.out.println(bankBookDTO.getBookRate());
				System.out.println(bankBookDTO.getBookSale());
			}
			
			request.setAttribute("list", ar);
			
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookList.jsp");
			try {
				view.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(path.equals("bankbookInsert.do")) {
			System.out.println("상품 등록 확인");
		}else if(path.equals("bankbookSelect.do")) {
			System.out.println("상품상세 조회");
			String num = request.getParameter("bookNumber");
			long num2 = Long.parseLong(num);
			
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNumber(num2);
			
			bankBookDTO = bankBookDAO.getSelect(bankBookDTO);
			
			System.out.println(bankBookDTO.getBookName());
			System.out.println(bankBookDTO.getBookNumber());
			System.out.println(bankBookDTO.getBookRate());
			System.out.println(bankBookDTO.getBookSale());
			
			request.setAttribute("dto", bankBookDTO);
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/bankbook/bankbookSelect.jsp");
			try {
				view.forward(request, response);
				
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("그 외 나머지");
		}
	}
}
