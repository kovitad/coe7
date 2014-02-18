package com.coe7.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.coe7.domain.Authority;
import com.coe7.domain.Member;


public class MyAuthenticationProvider implements AuthenticationProvider {
	
	@Resource
	private MemberService memberService;
	
	@PostConstruct
	public void init(){

	}
	
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		DomainUsernamePasswordAuthenticationToken token = (DomainUsernamePasswordAuthenticationToken) authentication;
		String userName = token.getName();
		String domain = token.getDomain();
		Member user = memberService.findMember(userName);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username/password");
		}
		String password = user.getPassword();
		if (!password.equals(token.getCredentials())) {
			throw new BadCredentialsException("Invalid username/password");
		}
		// TODO Auto-generated method stub
		List<Authority> auths = new ArrayList<Authority>();
		auths.add(new Authority("ROLE_USER"));
		Collection<? extends GrantedAuthority> authorities = auths;
		return new DomainUsernamePasswordAuthenticationToken(user, password,
				domain, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return DomainUsernamePasswordAuthenticationToken.class
				.equals(authentication);
	}

}
