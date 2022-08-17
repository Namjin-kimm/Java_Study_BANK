package com.iu.start.board;

import java.util.ArrayList;

public interface DAO {
	
	public ArrayList<BoardDTO> getList() throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	public int setDelete() throws Exception;

}
