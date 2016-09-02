/*
 * 
 */
package org.bridgelabz.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


/*class LinkedInGraph
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */


public class LinkedInGraph {
	
	/** The access token. */
	private String accessToken;

	/**
	 * Instantiates a new graph.
	 *
	 * @param accessToken
	 *            the access token
	 */
	public LinkedInGraph(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * Gets the graph.
	 *
	 * @return the graph
	 */
	public String getGraph() {
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


	/**
	 * Gets the graph data.
	 *
	 * @param Graph
	 *            the graph
	 * @return the graph data
	 */
	public Map<String, String> getGraphData(String Graph) {
		Map<String, String> Profile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(Graph);
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
			throw new RuntimeException("ERROR in parsing LinkedIn graph data. " + e);
		}
		return Profile;
	}
}
