package com.iu.start.test;

import java.sql.Connection;

import com.iu.start.test.members.BankMembersDAO;
import com.iu.start.test.members.BankMembersDTO;
import com.iu.start.util.DBConnector;

public class TestMain {

	public static void main(String[] args) {
//		System.out.println("Hello");
		
//		try {
//			Connection con = DBConnector.getConnection();
//			System.out.println(con != null);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUsername("dd");
		bankMembersDTO.setPassword("11");
		bankMembersDTO.setName("haha");;
		bankMembersDTO.setEmail("hoho");;
		bankMembersDTO.setPhone("1234");;
		try {
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
