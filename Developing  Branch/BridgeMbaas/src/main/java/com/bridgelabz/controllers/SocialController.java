package com.bridgelabz.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bridgelabz.connection.FacebookConnection;
import com.bridgelabz.connection.GitHubConnection;
import com.bridgelabz.connection.GoogleConnection;
import com.bridgelabz.connection.LinkedInConnection;
import com.bridgelabz.graph.FacebookGraph;
import com.bridgelabz.graph.GitHubGraph;
import com.bridgelabz.graph.GoogleGraph;
import com.bridgelabz.graph.LinkedInGraph;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

@RestController
@EnableWebMvc
public class SocialController {
	Session session;
	@Autowired
	public SessionFactory sessionfactory;
	private String code = "";
	JSONObject jsonObj;
	Facebook facebook = new FacebookFactory().getInstance();
	public static String TWITTER_CONSUMER_KEY = "M65Cy3KhTd08DOdHeQcLytzg1";
	public static String TWITTER_CONSUMER_SECRET = "xupjwjeQ2UlhDrhs6Vh4deaNgdkBiCdOYDYA5iErYVT6vHGpfp";

	File file1 = new File("/home/bridgelabz/Desktop/back.jpg");
	Twitter twitter;

	/*
	 * FaceBook Controller
	 * 
	 */
	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public void facebook(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException, FacebookException {
		// getiing the autherazation code
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		// creating FacebookConnection by calling FacebookConnection class
		FacebookConnection Connection = new FacebookConnection();
		// getting accesstoken here by exchanging the autherization code with
		// provider
		String accessToken = Connection.getAccessToken(code);
		System.out.println(accessToken);
		// paasing the accesstoken to FacebookGraph graph method to access the
		// user
		// details
		FacebookGraph Graph = new FacebookGraph(accessToken);
		// getting the graph user in json format
		String graph = Graph.getFacebookGraph();
		// passing the graph to get graph data for getting the graph from given
		// json fromat
		Map<String, String> ProfileData = Graph.getGraphData(graph);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>BRIDGEMBAAS</h1>");
		out.println("<h2>Facebook Application Main Menu</h2>");
		out.println("<div>Welcome " + ProfileData.get("fullname"));
		out.println("<div>Your first_name: " + ProfileData.get("first_name"));
		out.println("<div>Your last_name: " + ProfileData.get("last_name"));
		out.println("<div>You are " + ProfileData.get("gender"));
		out.println("<div>You email Id: " + ProfileData.get("email"));
		out.println("<div>Your'e birthday " + ProfileData.get("birthday"));
		out.println("<div>About :" + ProfileData.get("bio"));

	}

	/*
	 * 
	 * LinkedIn Controller
	 * 
	 */
	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public void LinkedIn(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// getiing the autherazation code
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		// creating LinkedInConnection by calling LinkedInConnection class
		LinkedInConnection Connection = new LinkedInConnection();
		// getting accesstoken here by exchanging the autherization code with
		// provider
		String accessToken = Connection.getAccessToken(code);
		try {
			jsonObj = new JSONObject(accessToken);

			System.out.println(jsonObj.get("access_token"));
			// paasing the accesstoken to LinkedInGraph graph method to access
			// the user
			// details
			LinkedInGraph Graph = new LinkedInGraph(jsonObj.get("access_token").toString());
			// getting the graph user in json format
			String graph = Graph.getGraph();
			// passing the graph to get graph data for getting the graph from
			// given
			// json fromat
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

	/*
	 * Google Controller
	 */

	@RequestMapping(value = "/google", method = RequestMethod.GET)
	public void google(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// getiing the autherazation code
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		// creating GoogleConnection by calling GoogleConnection class
		GoogleConnection Connection = new GoogleConnection();
		// getting accesstoken here by exchanging the autherization code with
		// provider
		String accessToken = Connection.getAccessToken(code);
		System.out.println(accessToken);
		// paasing the accesstoken to GoogleGraph graph method to access the
		// user
		// details
		GoogleGraph Graph = new GoogleGraph(accessToken);
		// getting the graph user in json format
		String graph = Graph.getGoogleGraph();
		// passing the graph to get graph data for getting the graph from given
		// json fromat
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

	/*
	 * GitHub Controller
	 */

	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public void GitHub(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// getiing the autherazation code
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);

		// validating the autherazation code
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		// creating github connection by calling github connection class
		GitHubConnection Connection = new GitHubConnection();
		// getting accesstoken here by exchanging the autherization code with
		// provider
		String accessToken = Connection.getAccessToken(code);
		// paasing the accesstoken to github graph method to access the user
		// details
		GitHubGraph Graph = new GitHubGraph(accessToken);
		// getting the graph user in json format
		String graph = Graph.getGitHubGraph();
		System.out.println(graph);
		// passing the graph to get graph data for getting the graph from given
		// json fromat
		Map<String, String> ProfileData = Graph.getGraphData(graph);

		System.out.println(ProfileData);
		// getting the parsed user provider id here
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

	// Request Mapping For post
	@RequestMapping(value = "/post",method = RequestMethod.POST)
	public ModelAndView playersList(@RequestParam(value="tweet", required=true) String post) throws TwitterException {
		System.out.println(post);
		StatusUpdate status = new StatusUpdate(post);

		twitter.updateStatus(status);

		return new ModelAndView("suc");
	}

	// Method For Upload Pic For Twitter

	public void uploadPic(File file, String message) throws Exception {
		try {
			StatusUpdate status = new StatusUpdate(message);
			status.setMedia(file);
			twitter.updateStatus(status);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Twitter Controller
	 */
	@RequestMapping("/twitter")
	public void twitter(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, TwitterException {

		// Get twitter object from session
		twitter = (Twitter) request.getSession().getAttribute("twitter");

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

			out.println("<h2>Your ScreenName:" + accessToken.getScreenName());
			out.println("<h2>Your Token:" + accessToken.getToken());
			out.println("<h2>Your TokenSecret:" + accessToken.getTokenSecret());

			/*
			 * // Instantiate and initialize a new twitter status update
			 * StatusUpdate su = new StatusUpdate(
			 * 
			 * // your tweet or status message "Hi BridegeLabz");
			 * 
			 * 
			 * // attach any media, if you want to su.setMedia( // title of
			 * media "Titile" // url any from website media urls , new
			 * URL("http://bridgelabz.com/images/slide-bg-3.jpg?imgmax=800").
			 * openStream());
			 * 
			 * 
			 * // Uploading Media File su.setMedia(file1); // tweet or update
			 * status Status status = twitter.updateStatus(su); out.println("" +
			 * status.getUser()); System.out.println("Successfully uploaded");
			 */
		} catch (TwitterException e) {

			e.printStackTrace();
		}
	}

	/*
	 * 
	 * Twitter Sign In Controller
	 */
	@RequestMapping("/signin")
	public void twitterSignin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// configure twitter api with consumer key and secret key
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(TWITTER_CONSUMER_SECRET);
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
