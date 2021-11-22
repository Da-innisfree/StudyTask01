package org.zerock.crizen.service;

import org.zerock.crizen.domain.AuthVO;
import org.zerock.crizen.domain.MemberVO;

public interface UserService {
	
	public void insertMember(MemberVO vo);
	
	public boolean updatePW(MemberVO vo);

}
