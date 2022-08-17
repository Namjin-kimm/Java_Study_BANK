package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.start.util.DBConnector;

public class BoardDAO implements DAO{
	BoardDTO boardDTO = new BoardDTO();

	@Override
	public ArrayList<BoardDTO> getList() throws Exception {
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD ORDER BY NUM DESC";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("NUM"));
			boardDTO.setTitle(rs.getString("TITLE"));
			boardDTO.setContent(rs.getString("WRITER"));
			boardDTO.setDates(rs.getDate("DATES"));
			boardDTO.setHit(rs.getLong("HIT"));
			ar.add(boardDTO);
		}
		DBConnector.disConnection(rs, st, con);
		return ar;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BOARD WHERE NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, boardDTO.getNum());
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			boardDTO.setNum(rs.getLong(1));
			boardDTO.setTitle(rs.getString(2));
			boardDTO.setContent(rs.getString(3));
			boardDTO.setWriter(rs.getString(4));
			boardDTO.setDates(rs.getDate(5));
			boardDTO.setHit(rs.getLong(6));
		}
		return boardDTO;
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL,?,?,?,SYSDATE,?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getTitle());
		st.setString(2, boardDTO.getContent());
		st.setString(3, boardDTO.getWriter());
		st.setLong(4, boardDTO.getHit());
		int result = st.executeUpdate();
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "UPDATE BOARD SET CONTENT=? WHERE NUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, boardDTO.getContent());
		st.setLong(2, boardDTO.getNum());
		int result = st.executeUpdate();
		return result;
	}

	@Override
	public int setDelete() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
