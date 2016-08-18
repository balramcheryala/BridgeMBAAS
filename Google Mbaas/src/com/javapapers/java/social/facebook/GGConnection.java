package com.javapapers.java.social.facebook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class GGConnection {
	public static final String GG_APP_ID = "1063203149782-3c2mc0mgb6b1uu4ta9hj720c1ecoopdq.apps.googleusercontent.com";
	public static final String GG_APP_SECRET = "glOO8FTt5F_9C8VFdvUxf3ON";
	public static final String REDIRECT_URI = "http://localhost:8081/Facebook_Login/fbhome";

	static String accessToken = "";

	public String getGGAuthUrl() {
		String ggLoginUrl = "";
		try {
			ggLoginUrl = "https://accounts.google.com/o/oauth2/v2/auth?" + "response_type=code&client_id="
					+ GGConnection.GG_APP_ID + "&redirect_uri=" + URLEncoder.encode(GGConnection.REDIRECT_URI, "UTF-8")
					+ "&scope=email%20profile";

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ggLoginUrl;
	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	public String getggGraphUrl(String code) {
		String ggGraphUrl = "";
		try {
			ggGraphUrl = "https://www.googleapis.com/oauth2/v1/token?" + "grant_type=authorization_code&code=" + code
					+ "&redirect_uri=" + URLEncoder.encode(GGConnection.REDIRECT_URI, "UTF-8") + "&client_id="
					+ GGConnection.GG_APP_ID + "&client_secret=" + GG_APP_SECRET;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ggGraphUrl;
	}

	// Exchanging Code and Generating Access Token Here
	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL ggGraphURL;
			try {
				ggGraphURL = new URL(getggGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection ggConnection;
			StringBuffer b = null;
			try {
				ggConnection = ggGraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(ggConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Google " + e);
			}

			accessToken = b.toString();
			if (accessToken.startsWith("[")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}
}
