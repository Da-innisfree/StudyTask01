package org.zerock.crizen.domain;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class CustomMemberVO implements UserDetails {
	
	private String username;
	private String password;
	private Date regDate;
	private List<GrantedAuthority> authList;
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

	public void setAuthList(List<AuthVO> authList) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(AuthVO vo : authList) {
			authorities.add(new SimpleGrantedAuthority(vo.getAuth()));
		}
		this.authList = authorities;
		
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authList;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return isEnabled== '1'? true: false;
	}


}
