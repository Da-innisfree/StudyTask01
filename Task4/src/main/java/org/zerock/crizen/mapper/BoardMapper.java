package org.zerock.crizen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.crizen.domain.BoardVo;

@Mapper
public interface BoardMapper {
	
	public void insertBoard(BoardVo vo);
	public BoardVo readBoard(BoardVo vo);
	public List<BoardVo> readBoardList();
	

}
