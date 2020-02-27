package com.gul.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.gul.common.EmailGeneric;
import com.gul.entity.PropertyConfig;
import com.gul.entity.User;
import com.gul.entity.UserOtp;
import com.gul.repository.UserOtpRepository;
import com.gul.repository.UserRepository;

@Controller
@SessionAttributes("user")
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserOtpRepository otpRepository;

	@Autowired
	PropertyConfig config;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}

	@GetMapping("/signup")
	public ModelAndView signup() {
		ModelAndView mav = new ModelAndView("signup");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@GetMapping("/forget")
	public ModelAndView forget() {
		ModelAndView mav = new ModelAndView("forget");
		mav.addObject("user", new User());
		return mav;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	@PostMapping("/getOtp")
	public ModelAndView getOtp(@ModelAttribute("user") User user1) {
		ModelAndView mav = new ModelAndView();
		String email = user1.getEmail();
		User user = userRepository.findByEmail(email);
		if (user == null) {
			mav.setViewName("forget");
			mav.addObject("msg", "Email not registered");
		} else {
			UserOtp user2 = otpRepository.findByEmail(user.getEmail());
			Random rnd = new Random();
			int number = rnd.nextInt(999999);
			user2.setEmail(user.getEmail());
			user2.setOtp(Integer.toString(number));
			otpRepository.save(user2);
			EmailGeneric emailGeneric = new EmailGeneric(user2.getEmail(), "" + user2.getOtp(),
					"" + user2.getOtp(), config);
			Thread thread = new Thread(emailGeneric);
			thread.start();
			mav.setViewName("verification_page");
			;

		}
		return mav;
	}

	@PostMapping("/loginSuccess")
	public ModelAndView loginSuccess(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		User user2 = userRepository.findByEmailAndPasswordAndStatus(user.getEmail(), user.getPassword(),
				"Verfied");
		if (user2 == null) {
			mav.setViewName("login");
		} else {
			mav.setViewName("dashboard");
			mav.addObject("name", user2.getName());
			mav.addObject("user", user2);
		}
		return mav;
	}

	@PostMapping("/signupSuccess")
	public ModelAndView signupSuccess(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("verification_page");
		user.setStatus("Not Verfied");
		userRepository.save(user);
		UserOtp userOtp = new UserOtp();
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		userOtp.setEmail(user.getEmail());
		userOtp.setOtp(Integer.toString(number));
		otpRepository.save(userOtp);
		EmailGeneric emailGeneric = new EmailGeneric(user.getEmail(), "" + number, "" + number, config);
		Thread thread = new Thread(emailGeneric);
		thread.start();
		mav.addObject("email", user.getEmail());
		return mav;
	}

	@PostMapping("/verify")
	public ModelAndView verify(HttpServletRequest request, @SessionAttribute("user") User user) {
		ModelAndView mav = new ModelAndView();
		String email = user.getEmail();
		String otp = request.getParameter("otp");
		System.out.println(":: " + email + "   :" + otp);
		UserOtp userOtp = otpRepository.findByEmailAndOtp(email, otp);
		if (userOtp == null) {
			mav.addObject("msg", "Otp is not correct");
			mav.setViewName("verification_page");
		} else {
			User user2 = userRepository.findByEmail(userOtp.getEmail());
			user2.setStatus("Verfied");
			userRepository.save(user2);
			mav.setViewName("success");
		}
		return mav;
	}

	@PostMapping("/pwdSuccess")
	public ModelAndView pwdSuccess(@SessionAttribute("user") User user, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("dashboard");
		String password = request.getParameter("password");
		User user2 = userRepository.findByEmail(user.getEmail());
		user2.setPassword(password);
		userRepository.save(user2);
		mav.addObject("name", user2.getName());
		return mav;
	}

	@GetMapping("/pw")
	public ModelAndView signup2() {
		ModelAndView mav = new ModelAndView("success");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}
}
