package com.iu.start.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	BankBookDAO bankBookDAO = new BankBookDAO();
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		
		System.out.println("list 실행");
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long bookNum) {
		System.out.println("detail 실행");
		System.out.println("bookNum :" + bookNum);
		
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("add 실행");
		return "/bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("실행");
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result);
	}

}
