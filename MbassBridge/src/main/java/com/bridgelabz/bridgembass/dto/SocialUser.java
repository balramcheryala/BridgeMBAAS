package com.bridgelabz.bridgembass.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

// TODO: Auto-generated Javadoc
/**
 * The Class SocialUser.
 */
public class SocialUser extends org.springframework.social.security.SocialUser {

    /** The user id. */
    private String userId;

    /**
	 * Instantiates a new social user.
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
    public SocialUser(final String userId, final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired, final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        System.out.println("Step 8 :Social Usr Extends to org.springframework.social.security.SocialUser ");
        this.userId = userId;
    }

    /* (non-Javadoc)
     * @see org.springframework.social.security.SocialUser#getUserId()
     */
    public String getUserId() {
    	System.out.println("Step 9 :(Security Social USer )getting UserId ");
        return userId;
    }
}
