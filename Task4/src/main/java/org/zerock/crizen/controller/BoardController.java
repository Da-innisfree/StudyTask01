package org.zerock.crizen.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.crizen.domain.BoardVo;
import org.zerock.crizen.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;

	/* 게시판 리스트 출력 페이지 */
	@RequestMapping(value = "/boardlist.do", method = RequestMethod.GET)
	public ModelAndView showBoardList() {
		List<BoardVo> list = service.showList();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList", list);
		mav.setViewName("boardlist");
		
		return mav;
	}

	/* 게시판 입력 페이지 */
	@RequestMapping(value = "/writeboard.do", method = RequestMethod.GET)
	public String writeBoardForm() {
		return "writeboard";
	}

	/* 게시판 내용 입력하기 */
	@RequestMapping(value = "/writeboard.do", method = RequestMethod.POST)
	public String writeBoard(BoardVo vo) {
		service.register(vo);
		return "redirect:boardlist.do";
	}

	/* 게시판 내용 상세 페이지 + 댓글 출력 */
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView showBoard() {
		
		ModelAndView mav = new ModelAndView();

		return mav;
	}

	/* 댓글 입력 페이지 */
	@RequestMapping(value = "/writeboard.do", method = RequestMethod.GET)
	public String writeReplyForm() {
		return "writeReply";
	}
	
	/* 댓글 입력 하기 */
	@RequestMapping(value = "/writeboard.do", method = RequestMethod.GET)
	public ModelAndView writeReply() {
		
		ModelAndView mav = new ModelAndView();

		return mav;
	}

}
