package com.iu.start.test;

import com.iu.start.bankbook.BankBookDAO;
import com.iu.start.bankbook.BankBookDTO;

public class BankBookTestMain {

	public static void main(String[] args) {
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		try {
			int result = bankBookDAO.setUpdate(bankBookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
