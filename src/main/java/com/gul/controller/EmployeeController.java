package com.gul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.PersonalDetails;

@Controller
public class EmployeeController {

	@GetMapping("profile")
	public ModelAndView profile() {
		ModelAndView mav = new ModelAndView("profile");
		mav.addObject("personalDetails", new PersonalDetails());
		return mav;
	}
}
