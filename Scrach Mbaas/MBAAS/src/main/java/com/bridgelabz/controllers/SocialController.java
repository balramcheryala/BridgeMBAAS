package com.bridgelabz.controllers;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bridgelabz.connection.FacebookConnection;
import com.bridgelabz.connection.GitHubConnection;
import com.bridgelabz.connection.GoogleConnection;
import com.bridgelabz.connection.LinkedInConnection;
import com.bridgelabz.connection.TwitterConnection;
import com.bridgelabz.graph.FacebookGraph;
import com.bridgelabz.graph.GitHubGraph;
import com.bridgelabz.graph.GoogleGraph;
import com.bridgelabz.graph.LinkedInGraph;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import javax.servlet.http.HttpServlet;

@RestController
@EnableWebMvc
public class SocialController {

	@Autowired
	public SessionFactory sessionfactory;
	private String code = "";
	JSONObject jsonObj;
	public static String CONSUMER_KEY = "M65Cy3KhTd08DOdHeQcLytzg1";
	public static String CONSUMER_SECRET = "xupjwjeQ2UlhDrhs6Vh4deaNgdkBiCdOYDYA5iErYVT6vHGpfp";

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public void facebook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		FacebookConnection Connection = new FacebookConnection();
		String accessToken = Connection.getAccessToken(code);
		System.out.println(accessToken);
		FacebookGraph Graph = new FacebookGraph(accessToken);
		String graph = Graph.getFacebookGraph();
		Map<String, String> ProfileData = Graph.getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>BRIDGEMBAAS</h1>");
		out.println("<h2>Facebook Application Main Menu</h2>");
		out.println("<div>Welcome " + ProfileData.get("fullname"));
		out.println("<div>Your first_name: " + ProfileData.get("first_name"));
		out.println("<div>Your last_name: " + ProfileData.get("last_name"));
		out.println("<div>You are " + ProfileData.get("gender"));
		out.println("<div>Your'e birthday " + ProfileData.get("birthday"));
		out.println("<div>About :" + ProfileData.get("bio"));

	}

	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public void LinkedIn(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		LinkedInConnection Connection = new LinkedInConnection();
		String accessToken = Connection.getAccessToken(code);
		try {
			jsonObj = new JSONObject(accessToken);

			System.out.println(jsonObj.get("access_token"));

			LinkedInGraph Graph = new LinkedInGraph(jsonObj.get("access_token").toString());
			String graph = Graph.getGraph();
			Map<String, String> ProfileData = Graph.getGraphData(graph);
			System.out.println(ProfileData);
			String name = ProfileData.get("id");
			System.out.println(name);
			ServletOutputStream out = res.getOutputStream();
			out.println("<h1>BRIDGEMBAAS</h1>");
			out.println("<h2>LinkedIn Application Main Menu</h2>");
			out.println("<div>Welcome " + ProfileData.get("id"));
			out.println("<div>firstName " + ProfileData.get("firstName"));
			out.println("<div>headline " + ProfileData.get("headline"));
			out.println("<div>industry " + ProfileData.get("industry"));
			out.println("<div>pictureUrl " + ProfileData.get("pictureUrl"));
			out.println("<div>publicProfileUrl " + ProfileData.get("publicProfileUrl"));
		} catch (JSONException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/google", method = RequestMethod.GET)
	public void google(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		GoogleConnection Connection = new GoogleConnection();
		String accessToken = Connection.getAccessToken(code);
		System.out.println(accessToken);
		GoogleGraph Graph = new GoogleGraph(accessToken);
		String graph = Graph.getGoogleGraph();
		Map<String, String> ProfileData = Graph.getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>BRIDGEMBAAS</h1>");
		out.println("<h2>Google Application Main Menu</h2>");
		out.println("<div>Welcome " + ProfileData.get("fullname"));
		out.println("<div>Your first_name: " + ProfileData.get("first_name"));
		out.println("<div>Your last_name: " + ProfileData.get("last_name"));
		out.println("<div>You are " + ProfileData.get("gender"));
		out.println("<div>Your'e birthday " + ProfileData.get("birthday"));
		out.println("<div>About :" + ProfileData.get("bio"));

	}

	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public void GitHub(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}

		GitHubConnection Connection = new GitHubConnection();
		String accessToken = Connection.getAccessToken(code);
		GitHubGraph Graph = new GitHubGraph(accessToken);
		String graph = Graph.getGitHubGraph();
		System.out.println(graph);
		Map<String, String> ProfileData = Graph.getGraphData(graph);
		System.out.println(ProfileData);
		String name = ProfileData.get("id");
		System.out.println(name);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>BRIDGEMBAAS</h1>");
		out.println("<h2>Github Application Main Menu</h2>");
		out.println("<div>Welcome " + ProfileData.get("id"));
		out.println("<div>login  " + ProfileData.get("login"));
		out.println("<div>followers_url  " + ProfileData.get("followers_url"));
		out.println("<div>repos_url " + ProfileData.get("repos_url"));
		out.println("<div>bio " + ProfileData.get("bio"));
		out.println("<div>avatar_url " + ProfileData.get("avatar_url"));
		out.println("<div>name " + ProfileData.get("name"));
		out.println("<div>location " + ProfileData.get("location"));
		out.println("<div>updated_at " + ProfileData.get("created_at"));
		out.println("<div>updated_at " + ProfileData.get("updated_at"));

	}

	@RequestMapping("/twitter")
	public void twitter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get twitter object from session
		Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");

		// Get twitter request token object from session
		RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
		String verifier = request.getParameter("oauth_verifier");

		// Get twitter access token object by verifying request token
		AccessToken accessToken;
		try {
			accessToken = twitter.getOAuthAccessToken(requestToken, verifier);

			System.out.println(accessToken);
			request.getSession().removeAttribute("requestToken");
			ServletOutputStream out = response.getOutputStream();
			out.println("<h1>BRIDGEMBAAS</h1>");
			out.println("<h2>Twitter Application Main Menu</h2>");
			out.println("<h2>YourUserId:" + accessToken.getUserId());
			out.println("<h2>Your ScreenName:" + accessToken.getScreenName());
			out.println("<h2>Your Token:" + accessToken.getToken());
			out.println("<h2>Your TokenSecret:" + accessToken.getTokenSecret());
			
		} catch (TwitterException e) {

			e.printStackTrace();
		}
	}
	@RequestMapping("/signin")
	public void twitterSignin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// configure twitter api with consumer key and secret key
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(TwitterConnection.CONSUMER_KEY)
				.setOAuthConsumerSecret(TwitterConnection.CONSUMER_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		request.getSession().setAttribute("twitter", twitter);
		try {

			// setup callback URL
			StringBuffer callbackURL = request.getRequestURL();
			int index = callbackURL.lastIndexOf("/");
			callbackURL.replace(index, callbackURL.length(), "").append("/twitter");

			// get request object and save to session
			RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
			System.out.println(requestToken);
			request.getSession().setAttribute("requestToken", requestToken);

			// redirect to twitter authentication URL
			response.sendRedirect(requestToken.getAuthenticationURL());

		} catch (TwitterException e) {
			throw new ServletException(e);
		}

	}
}
