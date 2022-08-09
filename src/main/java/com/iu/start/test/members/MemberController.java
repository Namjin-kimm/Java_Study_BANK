package com.iu.start.test.members;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankbook.BankBookDTO;

@Controller
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할
//Container에게 이 클래스의 객체를 생성 위임
public class MemberController {
	BankMembersDAO bankMembersDAO = new BankMembersDAO();
	
	//annotation
	//@ : 설명 + 실행
	
	// /member/login
	@RequestMapping(value = "login")
	
	public String login() {
		System.out.println("로그인 실행");
		
		return "/member/login";
	}
	
	//join /member/join
	@RequestMapping(value = "join", method = RequestMethod.GET)
	
	public String join() {
		System.out.println("조인 GET 실행");
		
		return "/member/join";
		
		
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("조인 POST 실행");
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername(request.getParameter("id"));
//		bankMembersDTO.setPassword(request.getParameter("pw"));
//		bankMembersDTO.setName(request.getParameter("name"));
//		bankMembersDTO.setEmail(request.getParameter("email"));
//		bankMembersDTO.setPhone(request.getParameter("phone"));
		
		
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			System.out.println(result);
		return "/member/join";
	}
	
//	public String join(String id, String pw, String name, String email, String phone) throws Exception {
//		System.out.println("조인 POST 실행");
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername(id);
//		bankMembersDTO.setPassword(pw);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
//		
//		
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result);
//		return "/member/join";
//	}
}
