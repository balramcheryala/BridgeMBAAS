package com.bridgelabz.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/*
 * FacebookConnection  
 * 
 * */
public class FacebookConnection {

	public static final String FB_APP_ID = "872311806235774";
	public static final String FB_APP_SECRET = "f9b7d6e1e4d13b4cc2fcee4ea342fabf";
	public static final String REDIRECT_URI = "http://localhost:8081/bridgembaas/facebook";

	static String accessToken = "";

	// Invoking a authentication url
	public String getAuthUrl() {
		String fbLoginUrl = "";
		try {
			fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id=" + FacebookConnection.FB_APP_ID
					+ "&redirect_uri=" + URLEncoder.encode(FacebookConnection.REDIRECT_URI, "UTF-8") + "&scope=email";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbLoginUrl;
	}

	// creating a connection to grapghurl
	public String getGraphUrl(String code) {
		String fbGraphUrl = "";
		try {
			fbGraphUrl = "https://graph.facebook.com/oauth/access_token?" + "client_id=" + FacebookConnection.FB_APP_ID
					+ "&redirect_uri=" + URLEncoder.encode(FacebookConnection.REDIRECT_URI, "UTF-8") + "&client_secret="
					+ FB_APP_SECRET + "&code=" + code;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return fbGraphUrl;
	}

	// getting accesstoken
	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL fbGraphURL;
			try {
				fbGraphURL = new URL(getGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection FacebookConnection;
			StringBuffer b = null;
			try {
				// openingConnection of fbgraph url
				FacebookConnection = fbGraphURL.openConnection();
				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(FacebookConnection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				// reading a accesstoken from jsp page
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APiProvider
			if (accessToken.startsWith("{")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}

}
