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
import com.bridgelabz.model.FacebookDetails;
import com.bridgelabz.model.GitHubDetails;
import com.bridgelabz.model.LinkedInDetails;
import com.bridgelabz.model.TwitterDetails;
import com.bridgelabz.properties.ConnectionProperties;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;


/*Class ClientDetailsBean.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */


@RestController
@EnableWebMvc
public class SocialController {
	Session session;
	ConnectionProperties CP = new ConnectionProperties();
	@Autowired
	public SessionFactory sessionfactory;
	private String code = "";
	JSONObject jsonObj;
	Twitter twitter;
	File file = new File("/home/bridgelabz/Desktop/qwe.jpg");

	/*
	 * FaceBook Controller
	 * 
	 */
	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public ModelAndView facebook(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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

		session = sessionfactory.openSession();
		FacebookDetails details = new FacebookDetails();
		details.setFacebookid(ProfileData.get("id"));
		details.setBio(ProfileData.get("bio"));
		details.setEmail(ProfileData.get("email"));
		details.setFirst_name(ProfileData.get("first_name"));
		details.setGender(ProfileData.get("gender"));
		details.setLast_name(ProfileData.get("last_name"));
		details.setName(ProfileData.get("name"));
		session.save(details);
		session.close();
		return new ModelAndView("DataSaved");

	}

	/*
	 * 
	 * LinkedIn Controller
	 * 
	 */
	@RequestMapping(value = "/linkedin", method = RequestMethod.GET)
	public ModelAndView LinkedIn(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
			// Parsed Data Storing into the DataBase
			session = sessionfactory.openSession();
			LinkedInDetails details = new LinkedInDetails();
			details.setLinkedinId(ProfileData.get("id"));
			details.setFirstName(ProfileData.get("firstName"));
			details.setHeadline(ProfileData.get("headline"));
			details.setIndustry(ProfileData.get("industry"));
			details.setPictureUrl(ProfileData.get("pictureUrl"));
			details.setPublicProfileUrl(ProfileData.get("publicProfileUrl"));
			session.save(details);
			session.close();

		} catch (JSONException e) {

			e.printStackTrace();
		}
		return new ModelAndView("DataSaved");

	}

	/*
	 * Google Controller
	 */

	@RequestMapping(value = "/google", method = RequestMethod.GET)
	public ModelAndView google(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		return new ModelAndView("DataSaved");

	}

	/*
	 * GitHub Controller
	 */

	@RequestMapping(value = "/github", method = RequestMethod.GET)
	public ModelAndView GitHub(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// getiing the autherazation code
		code = req.getParameter("code");

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

		// passing the graph to get graph data for getting the graph from given
		// json fromat
		Map<String, String> ProfileData = Graph.getGraphData(graph);

		// getting the parsed user provider id here
		session = sessionfactory.openSession();
		GitHubDetails details = new GitHubDetails();
		details.setGithubId(ProfileData.get("id"));
		details.setLogin(ProfileData.get("login"));
		details.setFollowers_url(ProfileData.get("followers_url"));
		details.setRepos_url(ProfileData.get("repos_url"));
		details.setBio(ProfileData.get("bio"));
		details.setAvatar_url(ProfileData.get("avatar_url"));
		details.setName(ProfileData.get("name"));
		details.setLocation(ProfileData.get("location"));
		details.setCreated_at(ProfileData.get("created_at"));
		details.setUpdated_at(ProfileData.get("updated_at"));
		session.save(details);
		session.close();
		return new ModelAndView("DataSaved");
	}

	/*
	 * Twitter Controller
	 */
	@RequestMapping("/twitter")
	public ModelAndView twitter(HttpServletRequest request, HttpServletResponse response)
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

			session = sessionfactory.openSession();
			TwitterDetails details = new TwitterDetails();
			details.setUserId(accessToken.getUserId());
			details.setScreenName(accessToken.getScreenName());
			details.setToken(accessToken.getToken());
			details.setTokenSecret(accessToken.getTokenSecret());
			session.save(details);
			session.close();

		} catch (TwitterException e) {

			e.printStackTrace();
		}
		return new ModelAndView("DataSaved");
	}

	// Request Mapping For post
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ModelAndView playersList(@RequestParam(value = "tweet", required = true) String post)
			throws TwitterException {
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
	 * 
	 * Twitter Sign In Controller
	 */
	@RequestMapping("/signin")
	public void twitterSignin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// configure twitter api with consumer key and secret key
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(CP.TWITTER_CONSUMER_KEY)
				.setOAuthConsumerSecret(CP.TWITTER_CONSUMER_SECRET);
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
