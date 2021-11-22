package org.zerock.crizen.service;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.crizen.controller.BoardController;
import org.zerock.crizen.domain.CustomMemberVO;
import org.zerock.crizen.domain.MemberVO;
import org.zerock.crizen.mapper.MemberMapper;

public class UserDetailServiceImpl implements UserDetailsService {
	private static Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		LOGGER.info("Load User By UserName : "+username);
		MemberVO vo = memberMapper.read(username);
		LOGGER.info("유저 정보 : "+vo);
		CustomMemberVO customMember = new CustomMemberVO();
		
		if(vo ==null)
			return null;
		else {
			customMember.setUsername(vo.getUsername());
			customMember.setPassword(vo.getPassword());
			customMember.setAuthList(vo.getAuthList());
			customMember.setIsEnabled(vo.getIsEnabled());
		}	
		return customMember;
	}

}
