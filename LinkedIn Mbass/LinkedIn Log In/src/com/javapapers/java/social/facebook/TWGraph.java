package com.javapapers.java.social.facebook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class TWGraph {
	private String accessToken;

	public TWGraph(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getFBGraph() {
		String graph = null;
		try {

			String g = "https://api.linkedin.com/v1/people/~:(id,firstName,location,headline,industry,public-profile-url,picture-url)?oauth2_access_token="
					+ accessToken + "&format=json";
			URL u = new URL(g);
			URLConnection c = u.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
			String inputLine;
			StringBuffer b = new StringBuffer();
			while ((inputLine = in.readLine()) != null)
				b.append(inputLine + "\n");
			in.close();
			graph = b.toString();
			System.out.println(graph);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in getting FB graph data. " + e);
		}
		return graph;
	}

	public Map<String, String> getGraphData(String fbGraph) {
		Map<String, String> fbProfile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(fbGraph);
			fbProfile.put("id", json.getString("id"));
			
			fbProfile.put("firstName", json.getString("firstName"));
			
			if (json.has("headline"))
				fbProfile.put("headline", json.getString("headline"));
			
			if (json.has("industry"))
				fbProfile.put("industry", json.getString("industry"));
			
		/*	// reading inner object from json object
			if (json.has("location"))
				fbProfile.put("location", json.getString("location"));
*/
			if (json.has("pictureUrl"))
				fbProfile.put("pictureUrl", json.getString("pictureUrl"));
			
			if (json.has("publicProfileUrl"))
				fbProfile.put("publicProfileUrl", json.getString("publicProfileUrl"));
			
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return fbProfile;
	}
}
