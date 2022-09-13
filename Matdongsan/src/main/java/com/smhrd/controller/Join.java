package com.smhrd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.domain.Test;
import com.smhrd.domain.TestDAO;

// 문자열 매핑이 따로 관리된다!!
// WEB-INF - web.xml ---> 파일이름 변경시 주의할 것
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 0. post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		// 1. 데이터 가져오기(id,pw)
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Test test = new Test(id, pw);
		
		TestDAO dao = new TestDAO();
		int cnt = dao.insertTest(test);
		
		if (cnt > 0) {
			System.out.println("회원가입 성공!");
			response.sendRedirect("login.html");
		}else {
			System.out.println("회원가입 실패!!");
		}
		
		
		
		

	} // service 메소드 끝!!!

}