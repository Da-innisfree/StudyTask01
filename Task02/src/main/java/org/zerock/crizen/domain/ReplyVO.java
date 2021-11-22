package org.zerock.crizen.domain;

import java.util.Date;
import java.text.SimpleDateFormat;

public class ReplyVO {
	private int bno;
	private int rno;
	private String context;
	private String writer;
	private String regDate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.regDate = simpleDateFormat.format(regDate);
	}
	@Override
	public String toString() {
		return "ReplyVo [bno=" + bno + ", rno=" + rno + ", context=" + context + ", writer=" + writer + ", regDate="
				+ regDate + "]";
	}
	
	
}
