package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TwitterDetails")
public class TwitterDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "userId")
	private long userId;

	@Column(name = "token")
	private String token;
	
	@Column(name = "tokenSecret")
	private String tokenSecret;
	
	@Column(name = "ScreenName")
	private String ScreenName;

	public String getScreenName() {
		return ScreenName;
	}

	public void setScreenName(String screenName) {
		ScreenName = screenName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long l) {
		this.userId = l;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

}
