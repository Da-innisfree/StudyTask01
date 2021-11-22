package org.zerock.crizen.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.zerock.crizen.controller.BoardController;
import org.zerock.crizen.domain.MemberVO;
import org.zerock.crizen.mapper.MemberMapper;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String username = request.getParameter("username");
		
		if (exception instanceof AuthenticationServiceException) {
			LOGGER.info("존재하지 않는 사용자입니다.");
			request.setAttribute("error", username + "는 존재하지 않는 사용자입니다.");

		} else if (exception instanceof DisabledException) {
			LOGGER.info("비활성화된 계정입니다.");
			request.setAttribute("error", "비활성화된 계정입니다.");

		} else if (exception instanceof BadCredentialsException) {
			int chk = memberMapper.chkFailCnt(username);
			LOGGER.info("아이디 또는 비밀번호가 틀립니다.");
			if (chk < 4) {
				memberMapper.failCntUpdate(username);
				request.setAttribute("error", "아이디 또는 비밀번호가 틀립니다. - " + (chk + 1) + "회 오류");
			} else if (chk == 4) {
				memberMapper.failCntUpdate(username);

				MemberVO vo = new MemberVO();
				vo.setUsername(username);
				vo.setIsEnabled('0');
				
				memberMapper.disabledMember(vo);
				request.setAttribute("error", "계정이 잠겼습니다.");
			}

		}

		// 로그인 페이지로 다시 포워딩
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
}
