package com.bridgelabz.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GitHubConnection {
	public static final String GH_APP_ID = "5f6355f6c885df210f9b";
	public static final String GH_APP_SECRET = "72454ff52dd90e4648ce23aa1748bbb333ff9eac";
	public static final String REDIRECT_URI = "http://localhost:8081/bridgembaas/github";

	static String accessToken = "";

	public String getAuthUrl() {
		String LoginUrl = "";
		try {

			LoginUrl = "https://github.com/login/oauth/authorize?" + "client_id=" + GitHubConnection.GH_APP_ID
					+ "&redirect_uri=" + REDIRECT_URI + "&scope=user";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return LoginUrl;
	}

	// Sending Code With Our Client_id & client_SecretCode To Graph_url For
	// Token
	public String getGraphUrl(String code) {
		String GraphUrl = "";
		try {

			GraphUrl = "https://github.com/login/oauth/access_token?client_id=" + GitHubConnection.GH_APP_ID
					+ "&redirect_uri=" + REDIRECT_URI + "&client_secret=" + GH_APP_SECRET + "&code=" + code;

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
				throw new RuntimeException("Unable to connect with GitHub " + e);
			}

			accessToken = b.toString();
			if (accessToken.startsWith("{")) {
				throw new RuntimeException("ERROR: Access Token Invalid: " + accessToken);
			}
		}
		System.out.println(accessToken);
		return accessToken;
	}

}
