package org.zerock.crizen.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.crizen.domain.BoardVO;
import org.zerock.crizen.domain.Criteria;
import org.zerock.crizen.domain.ReplyVO;
import org.zerock.crizen.service.BoardService;

@Controller
public class BoardController {

	private static Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	BoardService service;

	@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	public String home(Model model) {
//		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
//				.getRequest();
//		String ip = req.getHeader("X-FORWARDED-FOR");
//		if (ip == null)
//			ip = req.getRemoteAddr();
//
//		model.addAttribute("clientIP", ip);
		return "hello";
	}

	/* 게시판 리스트 출력 페이지 */
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public ModelAndView showBoardList() {
		LOGGER.info("게시판 리스트 페이지");

		ModelAndView mav = new ModelAndView();
		
		mav.addObject("boardList", service.showList());
		mav.setViewName("boardlist");

		return mav;
	}

	/* 게시판 검색 리스트 출력 */
	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public ModelAndView searchBoard(String type, String keyword) {
		LOGGER.info("게시판 검색하기"+type+":"+keyword);
		Criteria ca = new Criteria();
		ca.setType(type);
		ca.setKeyword(keyword);

		ModelAndView mav = new ModelAndView();
		mav.addObject("type", type);
		mav.addObject("keyword", keyword);
		
		mav.addObject("boardList", service.showSearchedList(ca));
		mav.setViewName("boardlist");
		return mav;

	}

	/* 게시판 입력 페이지 */
	@RequestMapping(value = "/writeBoard.do", method = RequestMethod.GET)
	public String writeBoardForm() {
		LOGGER.info("게시판 입력 페이지");
		return "writeboard";
	}

	/* 게시판 내용 입력하기 */
	@RequestMapping(value = "/writeBoard.do", method = RequestMethod.POST)
	public String writeBoard(BoardVO vo) {
		service.register(vo);
		return "redirect:boardList.do";
	}

	/* 게시판 내용 상세 페이지 + 댓글 출력 */
	@RequestMapping(value = "/board.do", method = RequestMethod.GET)
	public ModelAndView showBoard(int bno) {
		LOGGER.info("게시판 상세 페이지");
		ModelAndView mav = new ModelAndView();

		mav.addObject("thisBoard", service.showBoard(bno));
		mav.setViewName("board");

		return mav;
	}

	/* 게시판 수정 페이지 */
	@RequestMapping(value = "/updateView.do", method = RequestMethod.GET)
	public ModelAndView updateView(int bno) {
		LOGGER.info("게시판 수정 페이지");
		System.out.println("수정할 게시물" + bno);

		BoardVO vo = service.showBoard(bno);
		ModelAndView mav = new ModelAndView();
		mav.addObject("thisBoard", vo);
		mav.setViewName("update");
		return mav;
	}

	/* 게시판 수정하기 */
	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public String updateBoard(BoardVO vo) {
		LOGGER.info("게시물 수정:" + vo);

		service.editBoard(vo);
		return "redirect:board.do?bno=" + vo.getBno();
	}

	/* 게시판 삭제하기 */
	@RequestMapping(value = "/remove.do", method = RequestMethod.GET)
	public String deleteBoard(int bno) {
		LOGGER.info("게시물 삭제: " + bno);
		service.removeBoard(bno);
		return "redirect:boardList.do";
	}

	/* 댓글 입력 하기 */
	@RequestMapping(value = "/writereply.do", method = RequestMethod.POST)
	@ResponseBody
	public String writeReply(ReplyVO vo) {
		LOGGER.info("댓글 입력" + vo);
		try {
			service.writeReply(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";

	}

	/* 댓글 리스트 불러오기 */
	@RequestMapping(value = "/readreplys.do", method = RequestMethod.GET)
	public @ResponseBody List<ReplyVO> readReply(int bno) {
		List<ReplyVO> list =  service.showReplys(bno);
		LOGGER.info("댓글 리스트 불러오기" + list);
		return list;
	}
	
	/* 댓글 삭제하기 */
	@RequestMapping(value = "/removeReply.do", method = RequestMethod.GET)
	@ResponseBody
	public String removeReply(int rno) {
		LOGGER.info("댓글 삭제하기");
		try {
			service.removeComment(rno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
//
//	/* 5일전 게시물 삭제 */
//	@Scheduled(cron = "0 0 20 * * *")
//	public void scheduleTest() {
//		LOGGER.info("매일 8시에 실행하는 스케줄러");
//		service.removeBoardsAF5();
//	}

}
