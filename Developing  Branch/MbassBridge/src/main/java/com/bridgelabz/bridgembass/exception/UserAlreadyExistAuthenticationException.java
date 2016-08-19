package com.bridgelabz.bridgembass.exception;

import org.springframework.security.core.AuthenticationException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserAlreadyExistAuthenticationException.
 */
public class UserAlreadyExistAuthenticationException extends AuthenticationException {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4965959220936960984L;

	/**
	 * Instantiates a new user already exist authentication exception.
	 *
	 * @param msg
	 *            the msg
	 */
	public UserAlreadyExistAuthenticationException(final String msg) {
        super(msg);
        System.out.println("IPL Exception User Alredy Exsist result:"+msg);
    }

}
