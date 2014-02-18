package com.coe7.domain;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	private static final long serialVersionUID = 7708204342302955297L;
	private String role;
	public Authority(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}
}
