package com.iu.start.test.members;

import java.util.ArrayList;

public interface MembersDAO {
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;
	
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception;

}
