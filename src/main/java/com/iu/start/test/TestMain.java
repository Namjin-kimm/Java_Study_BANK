package com.iu.start.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.test.members.BankMembersDAO;
import com.iu.start.test.members.BankMembersDTO;
import com.iu.start.util.DBConnector;
import com.iu.test.start.bankbook.BankBookDAO;
import com.iu.test.start.bankbook.BankBookDTO;

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
		
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername("dd");
//		bankMembersDTO.setPassword("11");
//		bankMembersDTO.setName("haha");;
//		bankMembersDTO.setEmail("hoho");;
//		bankMembersDTO.setPhone("1234");;
//		try {
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//===============================================================
		// 1. 번
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
//		bankBookDTO.setBookNum(Calendar.getInstance().getTimeInMillis());
//		bankBookDTO.setBookName("haha");
//		bankBookDTO.setBookRate(3.14);
//		bankBookDTO.setBookSale(1);
//		
//		try {
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 2 번!!
//		try {
//			ar = bankBookDAO.getList();
//			for(BankBookDTO bankBookDTO2 : ar) {
//				System.out.print(bankBookDTO2.getBookNum() + "\t");
//				System.out.print(bankBookDTO2.getBookName() + "\t");
//				System.out.print(bankBookDTO2.getBookRate() + "\t");
//				System.out.println(bankBookDTO2.getBookSale());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//3 번!!
		
//		bankBookDTO.setBookNum(1659511964733L);
//		bankBookDTO.setBookSale(1);
//		
//		try {
//			int result = bankBookDAO.setChangeSale(bankBookDTO);
//			System.out.println(result);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		bankBookDTO.setBookNum(1659511964733L);
		
		try {
			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
			System.out.println(bankBookDTO);
			System.out.println(bankBookDTO.getBookNum());
			System.out.println(bankBookDTO.getBookName());
			System.out.println(bankBookDTO.getBookRate());
			System.out.println(bankBookDTO.getBookSale());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
