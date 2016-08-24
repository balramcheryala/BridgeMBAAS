package com.bridgelabz.bridgembass.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.bridgelabz.bridgembass.dto.SocialProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class SecurityUtil.
 */
public class SecurityUtil {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

    /**
	 * Authenticate user.
	 *
	 * @param userDetails
	 *            the user details
	 */
    public static void authenticateUser(UserDetails userDetails)
    {
        LOGGER.debug("Logging in principal: {}", userDetails);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        LOGGER.info("User: {} has been logged in.", userDetails);
    }

    /**
	 * To social provider.
	 *
	 * @param providerId
	 *            the provider id
	 * @return the social provider
	 */
    public static SocialProvider toSocialProvider(String providerId) {
        for (SocialProvider socialProvider : SocialProvider.values()) {
            if (socialProvider.getProviderType().equals(providerId)) {
                return socialProvider;
            }
        }
        return SocialProvider.NONE;
    }
}
