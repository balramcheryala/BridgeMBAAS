package com.bridgelabz.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GoogleConnection {
	public static final String GG_APP_ID = "1063203149782-3c2mc0mgb6b1uu4ta9hj720c1ecoopdq.apps.googleusercontent.com";
	public static final String GG_APP_SECRET = "glOO8FTt5F_9C8VFdvUxf3ON";
	public static final String REDIRECT_URI = "http://localhost:8081/bridgembaas/google";

	static String accessToken = "";

	public String getAuthUrl() {
		String LoginUrl = "";
		try {
			LoginUrl = "https://accounts.google.com/o/oauth2/auth?" + "&scope=email%20profile" + "&redirect_uri="
					+ REDIRECT_URI + "&response_type=code&client_id=" + GoogleConnection.GG_APP_ID
					+ "&nonce=DgkRrHXmyu3KLd0KDdfq";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return LoginUrl;
	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	public String getGraphUrl(String code) {
		System.out.println(code);
		String GraphUrl = "";
		try {
			GraphUrl = "https://accounts.google.com/o/oauth2/token?" +"code=" + code+ "grant_type=authorization_code"+
					"&client_id=" + GoogleConnection.GG_APP_ID + "&client_secret=" + GG_APP_SECRET + "&redirect_uri="
					+ REDIRECT_URI;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return GraphUrl;
	}

	// Exchanging Code and Generating Access Token Here
	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL GraphURL;
			try {
				GraphURL = new URL(getGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection GoogleConnection;
			StringBuffer b = null;
			try {
				GoogleConnection = GraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(GoogleConnection.getInputStream()));
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
		System.out.println(accessToken);
		return accessToken;
	}

}
