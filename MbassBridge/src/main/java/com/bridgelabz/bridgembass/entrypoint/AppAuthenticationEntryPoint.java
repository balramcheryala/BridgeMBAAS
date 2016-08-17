package com.bridgelabz.bridgembass.entrypoint;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class AppAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/**
	 * loginFormUrl URL where the login page can be found.
	 */
	public AppAuthenticationEntryPoint(final String loginFormUrl) {
		super(loginFormUrl);
	}

	/**
	 * Performs the redirect (or forward) to the login form URL.
	 */
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		// redirect to login page. Use https if forceHttps true
		System.out.println("Step 2: App Authentication Entry Point  " +redirectStrategy);
		String redirectUrl = buildRedirectUrlToLoginPage(request, response, authException);
		System.out.println("Step 3 : Redirecting To :"+redirectUrl);
		redirectStrategy.sendRedirect(request, response, redirectUrl);
	}

}
