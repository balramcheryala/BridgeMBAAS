package com.bridgelabz.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.bridgelabz.properties.ConnectionProperties;

/*Connection name: GitHubConnection
 *created: Aug 18, 2016 10:33AM
 *Created By: Balram
 */

public class GitHubConnection {
	ConnectionProperties CP = new ConnectionProperties();

	static String accessToken = "";

	// Invoking a authentication url
	public String getAuthUrl() {
		String LoginUrl = "";
		try {

			LoginUrl = "https://github.com/login/oauth/authorize?" + "client_id=" + CP.GH_APP_ID + "&redirect_uri="
					+ CP.GH_REDIRECT_URI + "&scope=user";

		} catch (Exception e) {
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

			GraphUrl = "https://github.com/login/oauth/access_token?client_id=" + CP.GH_APP_ID + "&redirect_uri="
					+ CP.GH_REDIRECT_URI + "&client_secret=" + CP.GH_APP_SECRET + "&code=" + code;

		} catch (Exception e) {
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
				// openingConnection of fbgraph url
				Connection = GraphURL.openConnection();

				BufferedReader in;
				in = new BufferedReader(new InputStreamReader(Connection.getInputStream()));
				String inputLine;
				b = new StringBuffer();
				// reading a accesstoken from jsp page
				while ((inputLine = in.readLine()) != null)
					b.append(inputLine + "\n");
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to connect with GitHub " + e);
			}

			accessToken = b.toString();
			// Validating a AccessToken Got from the APiProvider
			if (accessToken.startsWith("{")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		System.out.println(accessToken);
		return accessToken;
	}

}
