package com.iu.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.test.members.BankMembersDTO;

@Controller
@RequestMapping("/bankAccount/*")
public class BankAccountController {
	
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session)throws Exception{
		System.out.println("BankAccount Add");
		System.out.println(bankAccountDTO.getBookNum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUsername());
		//DTO : userName, bankNum
		int result = this.bankAccountDAO.add(bankAccountDTO);
		
		return "redirect:../bankbook/list";
	}

}
