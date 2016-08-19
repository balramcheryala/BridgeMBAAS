package com.bridgelabz.bridgembass.registry;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.provider.SocialAuthenticationService;

// TODO: Auto-generated Javadoc
/**
 * The Class AppSocialAuthenticationServiceRegistry.
 */
public class AppSocialAuthenticationServiceRegistry extends SocialAuthenticationServiceRegistry {

	/** The authentication services. */
	private List<SocialAuthenticationService<?>> authenticationServices;

	/**
	 * Instantiates a new app social authentication service registry.
	 *
	 * @param authenticationServices
	 *            the authentication services
	 */
	public AppSocialAuthenticationServiceRegistry(final List<SocialAuthenticationService<?>> authenticationServices) {
		this.authenticationServices = authenticationServices;
	}

	// When the constructor is called, the bean is not yet initialized -
	// i.e. no dependencies are injected
	// @PostConstruct method the bean is fully initialized and you can use the
	/**
	 * Inits the.
	 */
	// dependencies.
	@PostConstruct
	public void init() {
		if (authenticationServices != null) {
			for (SocialAuthenticationService authenticationService : authenticationServices) {
				System.out.println("Social Authentication Service Registry   " + authenticationService);
				super.addAuthenticationService(authenticationService);
			}
		}
	}

}
