package com.coe7.service.export;

import javax.jws.WebService;

import com.coe7.domain.Member;

@WebService(endpointInterface="com.coe7.service.export.CalculatorService")
public class CalculatorWebservice implements CalculatorService{
	@Override
	public Member calculate(){
		Member mem = new Member();
		mem.setFirstName("Kovitad");
		return mem;
	}
}
