package com.bridgelabz.connection;

/*
 * bridgembaas
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class LinkedInConnection {

	public static final String APP_ID = "81ofobqq5caolc";

	public static final String APP_SECRET = "V1MefhE1dUOmUyYg";

	public static final String REDIRECT_URI = "http://localhost:8081/bridgembaas/linkedin";

	static String accessToken = "";

	public String getAuthUrl() {
		String LoginUrl = "";
		try {
			LoginUrl = "https://www.linkedin.com/oauth/v2/authorization?" + "response_type=code&client_id="
					+ LinkedInConnection.APP_ID + "&redirect_uri="
					+ URLEncoder.encode(LinkedInConnection.REDIRECT_URI, "UTF-8")
					+ "&state=DCEe45A53sdfKef424FWf&scope=r_basicprofile";

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return LoginUrl;
	}

	public String getGraphUrl(String code) {
		String GraphUrl = "";
		try {
			GraphUrl = "https://www.linkedin.com/oauth/v2/accessToken?" + "grant_type=authorization_code&code=" + code
					+ "&redirect_uri=" + URLEncoder.encode(LinkedInConnection.REDIRECT_URI, "UTF-8") + "&client_id="
					+ LinkedInConnection.APP_ID + "&client_secret=" + APP_SECRET;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return GraphUrl;
	}

	public String getAccessToken(String code) {
		if ("".equals(accessToken)) {
			URL GraphURL;
			try {
				GraphURL = new URL(getGraphUrl(code));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				throw new RuntimeException("Invalid code received " + e);
			}
			URLConnection Connection;
			StringBuffer b = null;
			try {
				Connection = GraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook " + e);
			}

			accessToken = b.toString();
			if (accessToken.startsWith("[")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}
}
