package org.zerock.crizen.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.crizen.domain.AuthVO;
import org.zerock.crizen.domain.MemberVO;

@Mapper
public interface MemberMapper {
	public MemberVO read(String username);
	
	public void insertMember(MemberVO vo);
	
	public void insertAuth(MemberVO vo);
	
	public void disabledMember(MemberVO vo);
	
	public int updatePW(MemberVO vo);
	
	public int chkFailCnt(String username);

	public int failCntUpdate(String username);
	
}
