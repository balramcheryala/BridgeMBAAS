package com.javapapers.java.social.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TWConnection {
	public static final String TW_APP_ID = "81ofobqq5caolc";
	public static final String TW_APP_SECRET = "V1MefhE1dUOmUyYg";
	public static final String REDIRECT_URI = "http://localhost:8081/Facebook_Login/fbhome";


	static String accessToken = "";

	public String getFBAuthUrl() {
		String fbLoginUrl = "";
		try {
			fbLoginUrl = "https://www.linkedin.com/oauth/v2/authorization?" + "response_type=code&client_id="
					+ TWConnection.TW_APP_ID + "&redirect_uri="
					+ URLEncoder.encode(TWConnection.REDIRECT_URI, "UTF-8")
					+ "&state=DCEe45A53sdfKef424FWf&scope=r_basicprofile";

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbLoginUrl;
	}

	public String getFBGraphUrl(String code) {
		String fbGraphUrl = "";
		try {
			fbGraphUrl = "https://www.linkedin.com/oauth/v2/accessToken?"
					+ "grant_type=authorization_code&code="+code+"&redirect_uri="
					+ URLEncoder.encode(TWConnection.REDIRECT_URI, "UTF-8")+"&client_id=" + TWConnection.TW_APP_ID
					+ "&client_secret=" + TW_APP_SECRET;


		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbGraphUrl;
	}

	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL fbGraphURL;
			try {
				fbGraphURL = new URL(getFBGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection fbConnection;
			StringBuffer b = null;
			try {
				fbConnection = fbGraphURL.openConnection();
				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(
						fbConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook "
						+ e);
			}

			accessToken = b.toString();
			if (accessToken.startsWith("[")) {
				throw new RuntimeException("ERROR: Access Token Invalid: "
						+ accessToken);
			}
		}
		return accessToken;
	}
}
