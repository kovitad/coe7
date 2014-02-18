package com.coe7.managebean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.coe7.domain.Member;
import com.coe7.service.MemberService;

@Component
public class MemberRegistrationBean {
	private final Logger LOG = LoggerFactory.getLogger(MemberRegistrationBean.class);
	@Resource
	private MemberService service;
	private Member member;
	
	@PostConstruct
	public void init(){
		member = new Member();
	}
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	public void register(){
		BCryptPasswordEncoder encodeder = new BCryptPasswordEncoder();
		String encryptedPassword = encodeder.encode(member.getPassword());
		member.setPassword(encryptedPassword);
		Member memberObj = service.saveMember(member);
		LOG.info("Member Id :"+memberObj.getId());	
	}
	public static void main(String[] argv) {
		BCryptPasswordEncoder encodeder = new BCryptPasswordEncoder();
		String encryptedPassword = encodeder.encode("saliga");
		System.out.println(encryptedPassword);
	}
	
}
