package org.zerock.crizen.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardVO {
	private int bno;
	private String title;
	private String context;
	private String writer;
	private String regDate;
	private String editor;
	private String updateDate;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.updateDate = simpleDateFormat.format(updateDate);
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", context=" + context + ", writer=" + writer + ", regDate="
				+ regDate + ", editor=" + editor + ", updateDate=" + updateDate + "]";
	}

}
