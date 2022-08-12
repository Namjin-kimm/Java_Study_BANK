package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.start.util.DBConnector;

public class BankAccountDAO implements AccountDAO{

	@Override
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL,?,?,SYSDATE)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		
		int result = st.executeUpdate();
		
		DBConnector.disConnection(st, con);
		
		return result;
	}
	
	

}
