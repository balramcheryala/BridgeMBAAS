package com.bridgelabz.bridgembass.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
//@RestController is processed if an appropriate HandlerMapping-HandlerAdapter pair is configured
/**
 * The Class SocialController.
 */

//@RestController annotation that is itself annotated with @Controller and @ResponseBody.
/**
 * @author bridgelabz
 *
 */
@RestController
public class SocialController {

	// Marks a constructor, field, setter method or config method as to be
	/** The sessionfactory. */
	// autowired by Spring's dependency injection facilities.
	@Autowired
	public SessionFactory sessionfactory;

	/**
	 * Login.
	 *
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the model and view
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// Landing Page Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Login Page");
		model.addObject("name", "BRIDGEMBASS");
		model.setViewName("login");
		return model;
	}

	/**
	 * User page.
	 *
	 * @return the model and view
	 */
	// UserPage After Success Login
	@RequestMapping(value = { "/modelS" }, method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "BRIDGEMBASS");
		model.addObject("user", getUser());
		model.setViewName("user");
		return model;
	}

	/**
	 * Access denied page.
	 *
	 * @return the model and view
	 */
	// Access denied
	@RequestMapping(value = { "/accessdenied" }, method = RequestMethod.GET)
	public ModelAndView accessDeniedPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("message", "Either username or password is incorrect.");
		System.out.println("Access Denined");
		model.setViewName("accessdenied");
		return model;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
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
