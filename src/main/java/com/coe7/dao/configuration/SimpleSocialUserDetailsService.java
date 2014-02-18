package com.coe7.dao.configuration;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;




import com.coe7.service.RegisteringOpenIDAuthenticationUserDetailsService;

@Service
public class SimpleSocialUserDetailsService implements SocialUserDetailsService{

	@Resource
	private RegisteringOpenIDAuthenticationUserDetailsService registeringOpenIDAuthenticationUserDetailsService;
	
	@Override
	public SocialUserDetails loadUserByUserId(String userId)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		return (SocialUserDetails)registeringOpenIDAuthenticationUserDetailsService.loadUserByUsername(userId);
	}

    
}
