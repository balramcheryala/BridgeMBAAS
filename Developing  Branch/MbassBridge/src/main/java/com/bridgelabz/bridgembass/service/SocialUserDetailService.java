package com.bridgelabz.bridgembass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialAuthenticationException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;

import com.bridgelabz.bridgembass.dto.LocalUser;
import com.bridgelabz.bridgembass.dto.SocialUser;


// TODO: Auto-generated Javadoc
/**
 * The Class SocialUserDetailService.
 */
@Service("socialUserDetailService")
public class SocialUserDetailService implements SocialUserDetailsService {

    /** The user detail service. */
    @Autowired
    @Qualifier(value = "localUserDetailService")
    private UserDetailsService userDetailService;

    /* (non-Javadoc)
     * @see org.springframework.social.security.SocialUserDetailsService#loadUserByUserId(java.lang.String)
     */
    @Override
    public SocialUserDetails loadUserByUserId(final String userId) throws UsernameNotFoundException, DataAccessException {
        LocalUser user = (LocalUser) userDetailService.loadUserByUsername(userId);
        if (user == null) {
            throw new SocialAuthenticationException("No local user mapped with social user " + userId);
        }
        return new SocialUser(user.getUserId(),user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), user.getAuthorities());
    }
}
