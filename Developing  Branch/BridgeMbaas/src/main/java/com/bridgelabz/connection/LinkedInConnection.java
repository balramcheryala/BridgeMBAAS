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

import com.bridgelabz.properties.ConnectionProperties;

/*Connection name: LinkedInConnection
 *created: Aug 18, 2016 09:33AM
 *Created By: Balram
 */

public class LinkedInConnection {

	ConnectionProperties CP = new ConnectionProperties();
	static String accessToken = "";

	// Invoking a authentication url
	public String getAuthUrl() {
		String LoginUrl = "";
		try {

			LoginUrl = "https://www.linkedin.com/oauth/v2/authorization?" + "response_type=code&client_id="
					+ CP.LK_APP_ID + "&redirect_uri=" + URLEncoder.encode(CP.LK_REDIRECT_URI, "UTF-8")
					+ "&state=DCEe45A53sdfKef424FWf&scope=r_basicprofile";

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return LoginUrl;
	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	// creating a connection to grapghurl
	public String getGraphUrl(String code) {
		String GraphUrl = "";
		try {
			GraphUrl = "https://www.linkedin.com/oauth/v2/accessToken?" + "grant_type=authorization_code&code=" + code
					+ "&redirect_uri=" + URLEncoder.encode(CP.LK_REDIRECT_URI, "UTF-8") + "&client_id=" + CP.LK_APP_ID
					+ "&client_secret=" + CP.LK_APP_SECRET;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return GraphUrl;
	}

	// Exchanging Code and Generating Access Token Here
	// getting accesstoken
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

				// reading a accesstoken from jsp page
				b = new StringBuffer();
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with Facebook " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APiProvider
			if (accessToken.startsWith("[")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		return accessToken;
	}
}
