package com.gul.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.gul.entity.Education;
import com.gul.entity.PersonalDetails;
import com.gul.entity.Skill;
import com.gul.entity.User;
import com.gul.repository.DetailsRepository;
import com.gul.repository.EducationRepository;
import com.gul.repository.SkillRepository;

@Controller
public class EmployeeController {

	@Autowired
	DetailsRepository detailsRepository;
	@Autowired
	EducationRepository educationRepository;
	@Autowired
	SkillRepository skillRepository;

	@InitBinder
	public void initConverter(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("profile")
	public ModelAndView profile(@SessionAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("profile");
		PersonalDetails personalDetails = detailsRepository.findByUid(user.getId());
		mav.addObject("personalDetails", personalDetails);
		return mav;
	}

	@PostMapping("/saveDetails")
	public ModelAndView saveDetails(@SessionAttribute("user") User user,
			@ModelAttribute("personalDetails") PersonalDetails personalDetails) {
		ModelAndView mav = new ModelAndView("profile");
		personalDetails.setUid(user.getId());
		detailsRepository.save(personalDetails);
		return mav;
	}

	@GetMapping("education")
	public ModelAndView education(@SessionAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("education");
//		PersonalDetails personalDetails = detailsRepository.findByUid(user.getId());
		mav.addObject("education", new Education());
		return mav;
	}

	@PostMapping("/saveEducation")
	public ModelAndView saveEducation(@SessionAttribute("user") User user,
			@ModelAttribute("education") Education education) {
		ModelAndView mav = new ModelAndView("profile");
		education.setUid(user.getId());
		educationRepository.save(education);
		return mav;
	}

	@GetMapping("skill")
	public ModelAndView skill(@SessionAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("skill");
		mav.addObject("skill", new Skill());
		return mav;
	}

	@PostMapping("/saveSkill")
	public ModelAndView saveSkill(@SessionAttribute("user") User user, @ModelAttribute("skill") Skill skill) {
		ModelAndView mav = new ModelAndView("skill");
		skill.setUid(user.getId());
		skillRepository.save(skill);
		return mav;
	}
}
