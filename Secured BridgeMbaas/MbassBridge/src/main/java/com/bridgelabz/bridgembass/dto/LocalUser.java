package com.bridgelabz.bridgembass.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

// TODO: Auto-generated Javadoc
/**
 * The Class LocalUser.
 */
public class LocalUser extends User {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7233175249014094124L;
	
	/** The user id. */
	private String userId;

    /**
	 * Instantiates a new local user.
	 *
	 * @param userId
	 *            the user id
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 * @param enabled
	 *            the enabled
	 * @param accountNonExpired
	 *            the account non expired
	 * @param credentialsNonExpired
	 *            the credentials non expired
	 * @param accountNonLocked
	 *            the account non locked
	 * @param authorities
	 *            the authorities
	 */
    public LocalUser(final String userId, final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        System.out.println("Step 6 :Local UserDto  Extends User ");
        this.userId = userId;
    }

    /**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
    public String getUserId() {
    	System.out.println("Step 7 :Getting User Id From DTO");
        return userId;
    }
}
