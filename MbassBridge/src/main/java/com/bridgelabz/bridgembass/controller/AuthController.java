package com.bridgelabz.bridgembass.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AuthController {

	

	//dashboard
	@RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("dashboard");
		return model;
	}
	// Sign in By
	@RequestMapping(value = { "/signinby" }, method = RequestMethod.GET)
	public ModelAndView signInBy() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBAAS");
		model.addObject("user", getUser());
		model.setViewName("sign-in");
		return model;
	}

	// id_secure code
	@RequestMapping(value = { "/id_secure" }, method = RequestMethod.GET)
	public ModelAndView id_secure() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.addObject("project", "Set Redirect Uri as http://localhost:8081/projectname/__/auth/{provider}");
		model.setViewName("id_secure");
		return model;
	}

	// getUser
	private String getUser() {
		String userName = null;
		// The simplest way to retrieve the currently authenticated principal is
		// via a static call to the SecurityContextHolder
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Getting the username from Security Context Holder");
		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
