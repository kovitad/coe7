package com.coe7.service.export;

import javax.jws.WebService;

import com.coe7.domain.Member;

@WebService
public interface CalculatorService {
	Member calculate();
}
