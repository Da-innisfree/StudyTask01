package org.zerock.crizen.domain;


import java.util.Date;
import java.util.List;

public class MemberVO  {
	
	private String username;
	private String password;
	private Date regDate;
	private List<AuthVO> authList;
	private char isEnabled;
	private int failCnt;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<AuthVO> getAuthList() {
		return authList;
	}
	public void setAuthList(List<AuthVO> authList) {
		this.authList = authList;
	}
	public char getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(char isEnabled) {
		this.isEnabled = isEnabled;
	}
	public int getFailCnt() {
		return failCnt;
	}
	public void setFailCnt(int failCnt) {
		this.failCnt = failCnt;
	}
	@Override
	public String toString() {
		return "MemberVO [username=" + username + ", password=" + password + ", regDate=" + regDate + ", authList="
				+ authList + ", isEnabled=" + isEnabled + ", failCnt=" + failCnt + "]";
	}
	
	
	
	
}