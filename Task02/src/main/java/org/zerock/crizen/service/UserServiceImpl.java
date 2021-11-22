package org.zerock.crizen.service;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.crizen.domain.AuthVO;
import org.zerock.crizen.domain.MemberVO;
import org.zerock.crizen.mapper.MemberMapper;

@Service
public class UserServiceImpl implements UserService {
	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private ShaPasswordEncoder shaPasswordEncoder;
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public void insertMember(MemberVO vo) {
		String securityPW = shaPasswordEncoder.encodePassword(vo.getPassword(), null);
		vo.setPassword(securityPW);
		LOGGER.info("encoded PW"+securityPW);
		
		AuthVO auth = new AuthVO();
		auth.setUsername(vo.getUsername());
		auth.setAuth("ROLE_MEMBER");
		
		List<AuthVO> authList = new ArrayList();
		authList.add(auth);	
		vo.setAuthList(authList);
	
		memberMapper.insertMember(vo);
		memberMapper.insertAuth(vo);
	}


	@Override
	public boolean updatePW(MemberVO vo) {
		String securityPW = shaPasswordEncoder.encodePassword(vo.getPassword(), null);
		vo.setPassword(securityPW);
		return memberMapper.updatePW(vo)>0;
	}
	
	


	
}
