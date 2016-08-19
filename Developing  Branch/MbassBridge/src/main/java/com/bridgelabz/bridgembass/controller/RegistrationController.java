package com.bridgelabz.bridgembass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.bridgembass.dto.LocalUser;
import com.bridgelabz.bridgembass.dto.UserRegistrationForm;
import com.bridgelabz.bridgembass.exception.UserAlreadyExistAuthenticationException;
import com.bridgelabz.bridgembass.service.UserService;
import com.bridgelabz.bridgembass.util.SecurityUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class RegistrationController.
 */
@RestController
public class RegistrationController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/**
	 * Signup.
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
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "User Registration Form");
		model.setViewName("registration");
		return model;
	}

	/**
	 * Register user.
	 *
	 * @param registrationForm
	 *            the registration form
	 * @return the model and view
	 * @throws UserAlreadyExistAuthenticationException
	 *             the user already exist authentication exception
	 */
	@RequestMapping(value = { "/user/register" }, method = RequestMethod.POST)
	public @ResponseBody ModelAndView registerUser(@RequestBody UserRegistrationForm registrationForm)
			throws UserAlreadyExistAuthenticationException {
		if (registrationForm.getUserId() == null) {
			registrationForm.setUserId(registrationForm.getUserId());
		}

		LocalUser localUser = (LocalUser) userService.registerNewUser(registrationForm);

		SecurityUtil.authenticateUser(localUser);

		ModelAndView model = new ModelAndView();
		model.addObject("title", "User");
		model.addObject("user", localUser.getUsername());
		model.setViewName("user");
		return model;

	}
}
