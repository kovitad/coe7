package com.coe7.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;

import com.coe7.domain.CustomUserDetails;

@Service("registeringOpenIDAuthenticationUserDetailsService")
public class RegisteringOpenIDAuthenticationUserDetailsService implements
		AuthenticationUserDetailsService<OpenIDAuthenticationToken>, UserDetailsService {

	@Resource
	private MemberService memberService;
	@Override
	public UserDetails loadUserDetails(OpenIDAuthenticationToken token)
			throws UsernameNotFoundException {
		final String openid = token.getIdentityUrl();
		List<OpenIDAttribute> attributes = token.getAttributes();
		OpenIDAttribute fullnameAttr = (OpenIDAttribute) CollectionUtils.find(attributes, new PropertyEqualPredicate("name", "fullname"));
		OpenIDAttribute emailAttr = (OpenIDAttribute) CollectionUtils.find(attributes, new PropertyEqualPredicate("name", "email"));
		final String userName = StringUtils.substringBefore(emailAttr.getValues().get(0), "@");
		
		return loadUserByUsername(userName);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		UserDetails userDetails = new CustomUserDetails(memberService.findMember(username));
		Authentication authentication =  new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return userDetails;
	}
}
