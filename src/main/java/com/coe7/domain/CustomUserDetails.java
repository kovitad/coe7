package com.coe7.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {

	private Member member;

	private static final long serialVersionUID = -6942075997820975560L;

	public CustomUserDetails(final Member member) {
		super();
		this.member = member;
		

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<Authority> auths = new ArrayList<Authority>();

		auths.add(new Authority("ROLE_USER"));

		return auths;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.member.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.member.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
