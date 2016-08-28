package org.bridgelabz.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


/*class GitHubGraph
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */


public class GitHubGraph {
	private String accessToken;

	public GitHubGraph(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getGitHubGraph() {
		String graph = null;
		try {

			String g = "https://api.github.com/user?" + accessToken;
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
			throw new RuntimeException("ERROR in getting graph data. " + e);
		}
		return graph;
	}

	public Map<String, String> getGraphData(String GithubGraph) {
		Map<String, String> Profile = new HashMap<String, String>();
		try {
			JSONObject json = new JSONObject(GithubGraph);
			Profile.put("id", json.getString("id"));
			Profile.put("login", json.getString("login"));
			if (json.has("followers_url"))
				Profile.put("followers_url", json.getString("followers_url"));
			if (json.has("repos_url"))
				Profile.put("repos_url", json.getString("repos_url"));
			if (json.has("bio"))
				Profile.put("bio", json.getString("bio"));
			if (json.has("avatar_url"))
				Profile.put("avatar_url", json.getString("avatar_url"));
			if (json.has("name"))
				Profile.put("name", json.getString("name"));
			if (json.has("location"))
				Profile.put("location", json.getString("location"));
			if (json.has("created_at"))
				Profile.put("created_at", json.getString("created_at"));
			if (json.has("updated_at"))
				Profile.put("updated_at", json.getString("updated_at"));
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("ERROR in parsing FB graph data. " + e);
		}
		return Profile;
	}

}
