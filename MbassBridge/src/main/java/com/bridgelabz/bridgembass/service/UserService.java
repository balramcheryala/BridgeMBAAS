package com.bridgelabz.bridgembass.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.bridgelabz.bridgembass.dto.UserRegistrationForm;
import com.bridgelabz.bridgembass.exception.UserAlreadyExistAuthenticationException;

public interface UserService {

    public UserDetails registerNewUser(UserRegistrationForm UserRegistrationForm)throws UserAlreadyExistAuthenticationException;
    
}
