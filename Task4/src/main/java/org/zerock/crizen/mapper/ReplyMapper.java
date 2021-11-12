package org.zerock.crizen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.crizen.domain.BoardVo;
import org.zerock.crizen.domain.ReplyVo;

@Mapper
public interface ReplyMapper {
	
	public void insertReply(ReplyVo vo);
	public List<ReplyVo> readReplys(BoardVo vo);
	public int countReplys(BoardVo vo);
	

}
