package com.coe7.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.coe7.domain.Member;

@Controller
public class PersonController {
	private static final String SEARCH_VIEW_KEY = "redirect:search.html";
	private static final String SEARCH_MODEL_KEY = "persons";

	public PersonController(){
		
	}
	/**
	 * For every request for this controller, this will create a person instance
	 * for the form.
	 */
	@ModelAttribute
	public Member newRequest(@RequestParam(required = false) Integer id) {
		return new Member();
	}

	/*
	 * <p>Saves a person.</p>
	 * 
	 * <p>Expected HTTP POST and request '/person/form'.</p>
	 */
	@RequestMapping(value = "/person/form", method = RequestMethod.POST)
	public Member form(Member person, Model model) {
		return new Member();
	}
}
