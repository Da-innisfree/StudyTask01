package org.zerock.crizen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.crizen.domain.BoardVo;
import org.zerock.crizen.domain.ReplyVo;
import org.zerock.crizen.mapper.BoardMapper;
import org.zerock.crizen.mapper.ReplyMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	ReplyMapper replyMapper;

	@Override
	public List<BoardVo> showList() {
		return boardMapper.readBoardList();
	}
	
	@Override
	public List<ReplyVo> showReplys(BoardVo vo) {
		
		return replyMapper.readReplys(vo);
	}
	

	@Override
	public BoardVo showBoard(BoardVo vo) {
		
		return boardMapper.readBoard(vo);
	}

	@Override
	public void register(BoardVo vo) {
		boardMapper.insertBoard(vo);
		
	}

	@Override
	public void writeReply(ReplyVo vo) {
		replyMapper.insertReply(vo);
		
	}
	
	

	@Override
	public Boolean remove() {
		
		return null;
	}

	@Override
	public int countReplys(BoardVo vo) {
		return replyMapper.countReplys(vo);
	}




}
