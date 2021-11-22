package org.zerock.crizen.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.crizen.domain.BoardVO;
import org.zerock.crizen.domain.Criteria;
import org.zerock.crizen.domain.ReplyVO;
import org.zerock.crizen.mapper.BoardMapper;
import org.zerock.crizen.mapper.ReplyMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Autowired
	BoardMapper boardMapper;
	
	@Autowired
	ReplyMapper replyMapper;

	@Override
	public List<BoardVO> showList() {
		return boardMapper.readBoardList();
	}
	
	@Override
	public List<BoardVO> showSearchedList(Criteria ca) {
		System.out.print(boardMapper.searchBoardList(ca));
		return boardMapper.searchBoardList(ca);
	}

	
	@Override
	public List<ReplyVO> showReplys(int bno) {	
		LOGGER.info("댓글 불러오기");
		return replyMapper.readReplys(bno);
	}
	

	@Override
	public BoardVO showBoard(int bno) {
		
		return boardMapper.readBoard(bno);
	}

	@Override
	public void register(BoardVO vo) {
		LOGGER.info("게시물 등록"+vo.toString());
		boardMapper.insertBoard(vo);
		
	}

	@Override
	public void writeReply(ReplyVO vo) {
		LOGGER.info("댓글 등록"+vo.toString());
		replyMapper.insertReply(vo);
		
	}
	
	@Override
	public boolean editBoard(BoardVO vo) {
		return boardMapper.updateBoard(vo)>0;
	}

	@Override
	public boolean removeBoard(int bno) {
		
		return boardMapper.deleteBoard(bno)>0;
	}
	

	@Override
	public int countReplys(BoardVO vo) {
		return replyMapper.countReplys(vo);
	}

	@Override
	public boolean removeBoardsAF5() {
		return boardMapper.deleteBoardAf5() >0;
	}

	@Override
	public void test() {
		System.out.println("test()");
		
	}

	@Override
	public boolean removeComment(int rno) {
		return replyMapper.deleteReply(rno)>0;
	}







}
