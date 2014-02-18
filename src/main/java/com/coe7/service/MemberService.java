package com.coe7.service;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coe7.dao.MemberDao;
import com.coe7.domain.Member;

@Service
public class MemberService {
	
	@Resource
	private AuthenticationManager authenticationManager;
	
	@Resource
	private MemberDao memberDao;
	
	@Transactional
	public Member saveMember(Member myMember){
		return memberDao.save(myMember);
		
	}
	@Transactional(readOnly=true)
	public Member findMember(final String userName) {
		return memberDao.find(userName);
	}
	
	public boolean authenticate(final String userName, final String password) throws AuthenticationException{
		Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		if(authenticate.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(authenticate);
			return true;
		}
		return false;
	}
}
