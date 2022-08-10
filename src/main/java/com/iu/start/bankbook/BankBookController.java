package com.iu.start.bankbook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	BankBookDAO bankBookDAO = new BankBookDAO();
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		System.out.println("list 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
//		ModelAndView mv = new ModelAndView();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar);
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO)throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("detail 실행");
//		System.out.println("bookNum :" + bookNum);
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDTO);
		
		return mv;
		
//		return "bankbook/detail";
	}
	
	// /bankbook/add GET /WEB-INF/views/bankbook/add.jsp
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		System.out.println("add 실행");
//		return "/bankbook/add";
//		요청한 URI주소와 View(jsp)의 경로명이 일치 할 경우 리턴타입을 void로 할 수 있다
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("실행");
		ModelAndView mv = new ModelAndView();
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result);
		mv.setViewName("redirect:list");
		return mv;
	}

}
