/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.coe7.social.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.ReconnectFilter;

/**
 * Spring Social Configuration.
 * This configuration demonstrates the use of the simplified Spring Social configuration options from Spring Social 1.1.
 * 
 * @author Craig Walls
 */
//@Configuration
//@EnableSocial
public class SocialConfig implements SocialConfigurer {

	//
	// Web Controller and Filter Beans
	//
	@Bean
	public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
		ConnectController connectController = new ConnectController(connectionFactoryLocator, connectionRepository);
		//connectController.addInterceptor(new PostToWallAfterConnectInterceptor());
		//connectController.addInterceptor(new TweetAfterConnectInterceptor());
		return connectController;
	}
	@Bean
	public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository) {
		return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, new SimpleSignInAdapter(new HttpSessionRequestCache()));
	}
	
	@Bean
	public ReconnectFilter apiExceptionHandler(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
		return new ReconnectFilter(usersConnectionRepository, userIdSource);
	}

	@Override
	public void addConnectionFactories(
			ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
		
		
	}

	@Override
	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(
			ConnectionFactoryLocator connectionFactoryLocator) {
		// TODO Auto-generated method stub
		return null;
	}

}
