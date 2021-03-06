package com.javapapers.java.social.facebook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class GGGraph {
	private String accessToken;

	public GGGraph(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getGGGraph() {
		String graph = null;
		try {

			String g = "https://www.googleapis.com/plus/v1/people/me?access_token="
					+ accessToken;
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

	public Map<String, String> getGraphData(String ggGraph) {
		Map<String, String> Profile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(ggGraph);
			Profile.put("id", json.getString("id"));

			Profile.put("firstName", json.getString("firstName"));

			if (json.has("headline"))
				Profile.put("headline", json.getString("headline"));

			if (json.has("industry"))
				Profile.put("industry", json.getString("industry"));

			if (json.has("pictureUrl"))
				Profile.put("pictureUrl", json.getString("pictureUrl"));

			if (json.has("publicProfileUrl"))
				Profile.put("publicProfileUrl", json.getString("publicProfileUrl"));

		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing Google graph data. " + e);
		}
		return Profile;
	}
}
