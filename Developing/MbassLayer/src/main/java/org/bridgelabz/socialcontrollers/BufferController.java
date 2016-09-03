package org.bridgelabz.socialcontrollers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.bridgelabz.controllers.Dashboard;
import org.bridgelabz.dao.ClientCredentialsDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/*Class ClientDetailsBean.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

@Controller("social")
public class BufferController {
	Session session;

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	ClientCredentialsDao dao;

	File file = new File("/home/bridgelabz/Desktop/qwerty.jpg");

	// Request Mapping For Twitter post
	@RequestMapping(value = "/twitterpost", method = RequestMethod.POST)
	public ModelAndView playersList(@RequestParam(value = "tweet", required = true) String post)
			throws TwitterException {
		System.out.println(post);
		StatusUpdate status = new StatusUpdate(post);
		TwitterControllers.twitter.updateStatus(status);
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Successfully uploaded  To Twitter");
		return new ModelAndView("tweetsuccess", map);
	}

	/*
	 * FaceBook Post
	 */

	@RequestMapping(value = "/fbpost", method = RequestMethod.POST)
	public ModelAndView fbpost(@RequestParam(value = "facebookpost", required = true) String facebookpost)
			throws IOException {
		System.out.println("I am executing");
		HttpsURLConnection connection;
		String fbLoginUrl = "https://graph.facebook.com/"
				+ dao.AccessToken(Dashboard.globalname, "FacebookDetails").get(1) + "/feed?message="
				+ URLEncoder.encode(facebookpost, "UTF-8") + "&"
				+ dao.AccessToken(Dashboard.globalname, "FacebookDetails").get(0);

		URL url = new URL(fbLoginUrl);
		connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		// connection.connect();
		InputStream response = connection.getInputStream();
		System.out.println("Response " + response);
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Successfully posted To FaceBook");
		return new ModelAndView("DataSaved", map);
	}

	@RequestMapping(value = "/bufferpost", method = RequestMethod.POST)
	public ModelAndView bufferPost(@RequestParam(value = "post", required = true) String post)
			throws TwitterException, IOException {
		System.out.println("bufferpostexecuting");

		HttpsURLConnection connection;
		String fbLoginUrl = "https://graph.facebook.com/"
				+ dao.AccessToken(Dashboard.globalname, "FacebookDetails").get(1) + "/feed?message="
				+ URLEncoder.encode(post, "UTF-8") + "&"
				+ dao.AccessToken(Dashboard.globalname, "FacebookDetails").get(0);
		URL url = new URL(fbLoginUrl);
		connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		InputStream response = connection.getInputStream();
		System.out.println("Response " + response);

		// TWITTER POST
		StatusUpdate status = new StatusUpdate(post);
		TwitterControllers.twitter.updateStatus(status);
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Successfully posted To FaceBook And Twitter");
		return new ModelAndView("bufferpost", map);
	}

	// Method For Upload Pic For Twitter
	@RequestMapping(value = "/picupload")
	public ModelAndView uploadPic(@RequestParam(value = "post", required = true) String post) throws Exception {
		try {
			StatusUpdate status = new StatusUpdate(post);
			status.setMedia(file);
			Twitter Access = TwitterControllers.twitter;
			TwitterControllers.twitter.updateStatus(status);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "Successfully Pic Uploaded To Twitter");
		return new ModelAndView("DataSaved", map);
	}
}
