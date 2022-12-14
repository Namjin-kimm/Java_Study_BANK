package com.iu.start.test.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.iu.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO{
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		Connection con = DBConnector.getConnection();
		String sql = "SELECT USERNAME, NAME FROM MEMBERS WHERE USERNAME =? AND PASSWORD =?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
		}else {
			bankMembersDTO = null;
//			return null;
		}
		DBConnector.disConnection(rs, st, con);
		
		return bankMembersDTO;
	}

	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. SQL문 생성
		String sql = "INSERT INTO MEMBERS VALUES (?, ?, ?, ?, ?)";
		
		//3. 쿼리문 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());
		
		//5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		
		//6. 자원 해제
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception {
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. 쿼리문 작성
		String sql = "SELECT * FROM MEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
		
		//3. 쿼리문 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ? 값 세팅
		st.setString(1, "%" + search + "%");
		
		//5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString(1));
			bankMembersDTO.setPassword(rs.getString(2));
			bankMembersDTO.setName(rs.getString(3));
			bankMembersDTO.setEmail(rs.getString(4));
			bankMembersDTO.setPhone(rs.getString(5));
			ar.add(bankMembersDTO);
		}
		
		//6. 자원 해제
//		rs.close();
//		st.close();
//		con.close();
		DBConnector.disConnection(rs, st, con);
		
		return ar;
	}

	

}
