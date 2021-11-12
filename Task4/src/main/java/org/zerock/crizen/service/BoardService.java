package org.zerock.crizen.service;

import java.util.List;

import org.zerock.crizen.domain.BoardVo;
import org.zerock.crizen.domain.ReplyVo;

public interface BoardService {

	List<BoardVo> showList();
	
	List<ReplyVo> showReplys(BoardVo vo);
	
	BoardVo showBoard(BoardVo vo);

	void  register(BoardVo vo);
	
	void writeReply(ReplyVo vo);
	
	int countReplys(BoardVo vo);

	Boolean remove();

}
