package com.bridgelabz.bridgembass.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.bridgelabz.bridgembass.dto.UserRegistrationForm;
import com.bridgelabz.bridgembass.exception.UserAlreadyExistAuthenticationException;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

    /**
	 * Register new user.
	 *
	 * @param UserRegistrationForm
	 *            the user registration form
	 * @return the user details
	 * @throws UserAlreadyExistAuthenticationException
	 *             the user already exist authentication exception
	 */
    public UserDetails registerNewUser(UserRegistrationForm UserRegistrationForm)throws UserAlreadyExistAuthenticationException;
    
}
