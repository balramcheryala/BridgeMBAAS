package com.bridgelabz.bridgembass.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class AppSuccessHandler.
 */
//Redirect to different pages after Login with Spring Security
public class AppSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	// Encapsulates the redirection logic for all classes in the framework which
	/** The redirect strategy. */
	// perform redirects.
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	/**
	 * Determine target url.
	 *
	 * @param authentication
	 *            the authentication
	 * @return the string
	 */
	/*
	 * This method extracts the roles of currently logged-in user and returns
	 * appropriate URL according to his/her role.
	 */
	protected String determineTargetUrl(Authentication authentication) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		if (isAdmin(roles) || isUser(roles)) {

			url = "/services/userpage";
			System.out.println("Step 10 :Role USer/Admin App Success Handler services User Page redirecting");
		} else {

			url = "/services/accessDenied";
			System.out.println("Step 11 :Role USer/Admin App Suuess Handler services accessDenied redirecting");
		}

		return url;
	}

	/**
	 * Checks if is user.
	 *
	 * @param roles
	 *            the roles
	 * @return true, if is user
	 */
	private boolean isUser(List<String> roles) {
		if (roles.contains("ROLE_USER")) {
			System.out.println("Step 7  : ROlE = user");
			return true;
		}
		return false;
	}

	/**
	 * Checks if is admin.
	 *
	 * @param roles
	 *            the roles
	 * @return true, if is admin
	 */
	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			System.out.println("Is admin : role Admin");
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler#setRedirectStrategy(org.springframework.security.web.RedirectStrategy)
	 */
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler#getRedirectStrategy()
	 */
	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}