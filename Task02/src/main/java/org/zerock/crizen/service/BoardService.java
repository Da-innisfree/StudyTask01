package org.zerock.crizen.service;

import java.util.List;

import org.zerock.crizen.domain.BoardVO;
import org.zerock.crizen.domain.Criteria;
import org.zerock.crizen.domain.ReplyVO;

public interface BoardService {

	List<BoardVO> showList();
	
	List<BoardVO> showSearchedList(Criteria ca);
	
	List<ReplyVO> showReplys(int bno);
	
	BoardVO showBoard(int bno);

	void  register(BoardVO vo);
	
	boolean editBoard(BoardVO vo);
	
	boolean removeBoard(int bno);
	
	void writeReply(ReplyVO vo);
	
	boolean removeComment(int rno);
	
	int countReplys(BoardVO vo);

	boolean removeBoardsAF5();
	
	void test();

}
