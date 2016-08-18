package com.javapapers.java.social.facebook;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String code = "";
	

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// Authorization Code Getting Here
		code = req.getParameter("code");
		System.out.println("AuthorizedCode:" + code);

		if (code == null || code.equals("")) {
			throw new RuntimeException("ERROR: Didn't get code parameter in callback.");
		}
		GGConnection Connection = new GGConnection();
		
		//Getting Access Token Here 
		String accessToken = Connection.getAccessToken(code);
		
		System.out.println(accessToken);
		
		GGGraph Graph = new GGGraph(accessToken);
		String graph = Graph.getGGGraph();
		Map<String, String> ProfileData = Graph.getGraphData(graph);
		System.out.println(ProfileData);
		ServletOutputStream out = res.getOutputStream();
		out.println("<h1>BRIDGEMBAAS</h1>");
		out.println("<h2>Linked IN Application Main Menu</h2>");
		out.println("<div>Welcome " + ProfileData.get("id"));
		out.println("<div>firstName " + ProfileData.get("firstName"));
		out.println("<div>headline " + ProfileData.get("headline"));
		out.println("<div>industry " + ProfileData.get("industry"));
		out.println("<div>pictureUrl " + ProfileData.get("pictureUrl"));
		out.println("<div>publicProfileUrl " + ProfileData.get("publicProfileUrl"));

	}

}
