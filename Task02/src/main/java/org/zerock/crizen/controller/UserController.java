package org.zerock.crizen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.crizen.domain.MemberVO;
import org.zerock.crizen.service.UserService;

@Controller
public class UserController {
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/* 로그인 페이지 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public void loginView(String msg, String error, Model model) {
		LOGGER.info("로그인 페이지");
		model.addAttribute("error", error);
		model.addAttribute("msg", msg);
	}

	/* 회원가입 페이지 */
	@RequestMapping(value = "/signUp.do", method = RequestMethod.GET)
	public void signUpView(String msg,Model model) {
		LOGGER.info("회원가입 페이지");
		model.addAttribute("msg", msg);

	}
	
	/* 회원가입 */
	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String signUp(MemberVO vo, Model model) {
		LOGGER.info("회원가입");
		try {
			userService.insertMember(vo);
			model.addAttribute("msg", vo.getUsername()+"님 로그인 해주세요.");
		} catch (Exception e) {
			model.addAttribute("msg", "회원가입을 다시 시도해주세요.");
			return "redirect:signUp.do";
		}
		
		return "redirect:login.do";
	}
	
	/* 비밀번호 변경 페이지 */
	@RequestMapping(value = "/chgPW.do", method = RequestMethod.GET)
	public void chgPW(String msg,Model model) {
		LOGGER.info("비밀번호 변경 페이지");
		model.addAttribute("msg", msg);
	}
	
	/* 비밀번호 변경*/
	@RequestMapping(value = "/chgpw.do", method = RequestMethod.POST)
	public String updatePW(MemberVO vo, Model model) {
		LOGGER.info("비밀번호 변경하기");
		if(userService.updatePW(vo))
			model.addAttribute("msg", "비밀번호 변경이 완료되었습니다.");	
		return "redirect:login.do";
	}

}
