package com.bridgelabz.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class FacebookGraph {
	private String accessToken;

	public FacebookGraph(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getFacebookGraph() {
		String graph = null;
		try {

			String g = "https://graph.facebook.com/me?fields=id,name,email,birthday,about,gender,first_name,last_name&"
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

	public Map<String, String> getGraphData(String FacebookGraph) {
		Map<String, String> fbProfile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(FacebookGraph);
			
/*			JSONObject json2 =json.getJSONObject("");
			JSONObject objects = getArray.getJSONObject(i);*/
			
			fbProfile.put("id", json.getString("id"));
			fbProfile.put("fullname", json.getString("name"));
			if (json.has("first_name"))
				fbProfile.put("first_name", json.getString("first_name"));
			if (json.has("last_name"))
				fbProfile.put("last_name", json.getString("last_name"));
			if (json.has("birthday"))
				fbProfile.put("birthday", json.getString("birthday"));
			if (json.has("bio"))
				fbProfile.put("bio", json.getString("bio"));
			if (json.has("gender"))
				fbProfile.put("gender", json.getString("gender"));
			if (json.has("email"))
				fbProfile.put("email", json.getString("email"));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return fbProfile;
	}

}
