package com.javapapers.java.social.facebook;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class MainMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String code = "";
	JSONObject jsonObj;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		code = req.getParameter("code");
		System.out.println("Authorization Code : " + code);
		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		TWConnection fbConnection = new TWConnection();
		String accessToken = fbConnection.getAccessToken(code);
		try {
			jsonObj = new JSONObject(accessToken);

			System.out.println(jsonObj.get("access_token"));

			TWGraph fbGraph = new TWGraph(jsonObj.get("access_token").toString());
			String graph = fbGraph.getFBGraph();
			Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
			System.out.println(fbProfileData);
			ServletOutputStream out = res.getOutputStream();
			out.println("<h1>BRIDGEMBAAS</h1>");
			out.println("<h2>Linked IN Application Main Menu</h2>");
			out.println("<div>Welcome " + fbProfileData.get("id"));
			out.println("<div>Welcome " + fbProfileData.get("firstName"));
			out.println("<div>Welcome " + fbProfileData.get("headline"));
			out.println("<div>Welcome " + fbProfileData.get("industry"));
			out.println("<div>Welcome " + fbProfileData.get("pictureUrl"));
			out.println("<div>Welcome " + fbProfileData.get("publicProfileUrl"));
		} catch (JSONException e) {

			e.printStackTrace();
		}

	}

}
