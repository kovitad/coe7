package com.coe7.service;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.coe7.domain.Member;

public class DomainUsernamePasswordAuthenticationToken extends
		UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = -1593532662016087276L;

	private final String domain;

	// used for attempting authentication
	public DomainUsernamePasswordAuthenticationToken(String principal,
			String credentials, String domain) {
		super(principal, credentials);
		this.domain = domain;
	}

	// used for returning to Spring Security after being
	// authenticated
	public DomainUsernamePasswordAuthenticationToken(Member principal,
			String credentials, String domain,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		this.domain = domain;
	}

	public String getDomain() {
		return domain;
	}

}
