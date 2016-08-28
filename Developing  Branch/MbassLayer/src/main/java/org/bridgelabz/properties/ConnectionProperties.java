package org.bridgelabz.properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*class ConnectionProperties
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */
public class ConnectionProperties {

	@Autowired
	SessionFactory sf;
	public String TWITTER_CONSUMER_KEY = "M65Cy3KhTd08DOdHeQcLytzg1";
	public String TWITTER_CONSUMER_SECRET = "xupjwjeQ2UlhDrhs6Vh4deaNgdkBiCdOYDYA5iErYVT6vHGpfp";

	public String FB_APP_ID = "872311806235774";
	public String FB_APP_SECRET = "f9b7d6e1e4d13b4cc2fcee4ea342fabf";
	public String FB_REDIRECT_URI = "http://localhost:8081/bridgembaas/facebook";

	public String GH_APP_ID = "5f6355f6c885df210f9b";
	public String GH_APP_SECRET = "72454ff52dd90e4648ce23aa1748bbb333ff9eac";
	public String GH_REDIRECT_URI = "http://localhost:8081/bridgembaas/github";

	public String GG_APP_ID = "1063203149782-3c2mc0mgb6b1uu4ta9hj720c1ecoopdq.apps.googleusercontent.com";
	public String GG_APP_SECRET = "glOO8FTt5F_9C8VFdvUxf3ON";
	public String GG_REDIRECT_URI = "http://localhost:8081/bridgembaas/userpage";

	public String LK_APP_ID = "81ofobqq5caolc";
	public String LK_APP_SECRET = "V1MefhE1dUOmUyYg";
	public String LK_REDIRECT_URI = "http://localhost:8081/bridgembaas/linkedin";

}
