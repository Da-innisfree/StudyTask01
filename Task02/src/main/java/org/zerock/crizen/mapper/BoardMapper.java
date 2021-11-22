package org.zerock.crizen.mapper;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.zerock.crizen.domain.BoardVO;
import org.zerock.crizen.domain.Criteria;

@Mapper
public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);
	public BoardVO readBoard(int bno);
	public List<BoardVO> readBoardList();
	public int updateBoard(BoardVO vo);
	public int deleteBoard(int bno);
	public List<BoardVO> searchBoardList(Criteria ca);
	
	
	public int deleteBoardAf5();
	

}
