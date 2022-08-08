package com.iu.test.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO{

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKBOOK VALUES (?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBookNum());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setLong(4, bankBookDTO.getBookSale());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	// BankBook에 있는 모든 데이터 조회 최신순 정렬
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		
		return ar;
	}

	//판매여부 변경
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		int sale = 1;
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		if(bankBookDTO.getBookSale() == 1) {
			sale = 0;
		}
		st.setInt(1, sale);
		st.setLong(2, bankBookDTO.getBookNum());
		
		int result = st.executeUpdate();
		
		
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		BankBookDTO bankBookDTO2 = null;
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBookNum());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO2.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBookSale(rs.getInt("BOOKSALE"));
			System.out.println(1);
			}
		
		
		return bankBookDTO2;
	}

}
