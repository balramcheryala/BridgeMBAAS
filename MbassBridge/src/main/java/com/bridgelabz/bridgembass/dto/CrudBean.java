package com.bridgelabz.bridgembass.dto;

import java.util.Date;

public class CrudBean {
	private Integer id;
	private String email;
	private String providers;
	private Date created;
	private Date signedin;
	private String useruid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProviders() {
		return providers;
	}

	public void setProviders(String providers) {
		this.providers = providers;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getSignedin() {
		return signedin;
	}

	public void setSignedin(Date signedin) {
		this.signedin = signedin;
	}

	public String getUseruid() {
		return useruid;
	}

	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
}
