package com.bridgelabz.bridgembass.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import com.bridgelabz.bridgembass.dto.LocalUser;
import com.bridgelabz.bridgembass.dto.SocialProvider;
import com.bridgelabz.bridgembass.dto.UserRegistrationForm;
import com.bridgelabz.bridgembass.service.UserService;
import com.bridgelabz.bridgembass.util.SecurityUtil;

// TODO: Auto-generated Javadoc
/**
 * If no local user associated with the given connection then
 * connection signup will create a new local user from the given connection.
 */
public class AppConnectionSignUp implements ConnectionSignUp {

    /** The user service. */
    @Autowired
    private UserService userService;

    /* (non-Javadoc)
     * @see org.springframework.social.connect.ConnectionSignUp#execute(org.springframework.social.connect.Connection)
     */
    @Override
    public String execute(final Connection<?> connection) {
        UserRegistrationForm userDetails = toUserRegistrationObject(connection.getKey().getProviderUserId(), SecurityUtil.toSocialProvider(connection.getKey().getProviderId()), connection.fetchUserProfile());
        LocalUser user = (LocalUser) userService.registerNewUser(userDetails);
        return user.getUserId();
    }

    /**
	 * To user registration object.
	 *
	 * @param userId
	 *            the user id
	 * @param socialProvider
	 *            the social provider
	 * @param userProfile
	 *            the user profile
	 * @return the user registration form
	 */
    private UserRegistrationForm toUserRegistrationObject(final String userId, final SocialProvider socialProvider, final UserProfile userProfile) {
        return UserRegistrationForm.getBuilder()
                .addUserId(userId)
                .addFirstName(userProfile.getName())
                .addEmail(userProfile.getEmail())
                .addPassword(userProfile.getName())
                .addSocialProvider(socialProvider).build();
    }

}
