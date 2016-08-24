package com.bridgelabz.bridgembass.dto;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudBean.
 */
public class CrudBean {
	
	/** The id. */
	private Integer id;
	
	/** The email. */
	private String email;
	
	/** The providers. */
	private String providers;
	
	/** The created. */
	private Date created;
	
	/** The signedin. */
	private Date signedin;
	
	/** The useruid. */
	private String useruid;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the providers.
	 *
	 * @return the providers
	 */
	public String getProviders() {
		return providers;
	}

	/**
	 * Sets the providers.
	 *
	 * @param providers
	 *            the new providers
	 */
	public void setProviders(String providers) {
		this.providers = providers;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created
	 *            the new created
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Gets the signedin.
	 *
	 * @return the signedin
	 */
	public Date getSignedin() {
		return signedin;
	}

	/**
	 * Sets the signedin.
	 *
	 * @param signedin
	 *            the new signedin
	 */
	public void setSignedin(Date signedin) {
		this.signedin = signedin;
	}

	/**
	 * Gets the useruid.
	 *
	 * @return the useruid
	 */
	public String getUseruid() {
		return useruid;
	}

	/**
	 * Sets the useruid.
	 *
	 * @param useruid
	 *            the new useruid
	 */
	public void setUseruid(String useruid) {
		this.useruid = useruid;
	}
}
