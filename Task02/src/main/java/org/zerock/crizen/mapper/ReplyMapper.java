package org.zerock.crizen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.crizen.domain.BoardVO;
import org.zerock.crizen.domain.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	public void insertReply(ReplyVO vo);
	public List<ReplyVO> readReplys(int bno);
	public int countReplys(BoardVO vo);
	public int deleteReply(int rno);

}
