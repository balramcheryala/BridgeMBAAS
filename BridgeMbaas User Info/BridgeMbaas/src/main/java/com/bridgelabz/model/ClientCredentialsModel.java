package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ClientCredentialsModel")
public class ClientCredentialsModel {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/** The app ID. */
	@Column(name = "app_ID")
	private String clientid;

	/** The app secrete. */
	@Column(name = "app_Secrete")
	private String clientpassword;

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
	 * Gets the clientid.
	 *
	 * @return the clientid
	 */
	public String getClientid() {
		return clientid;
	}

	/**
	 * Sets the clientid.
	 *
	 * @param clientid
	 *            the new clientid
	 */
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**
	 * Gets the clientpassword.
	 *
	 * @return the clientpassword
	 */
	public String getClientpassword() {
		return clientpassword;
	}

	/**
	 * Sets the clientpassword.
	 *
	 * @param clientpassword
	 *            the new clientpassword
	 */
	public void setClientpassword(String clientpassword) {
		this.clientpassword = clientpassword;
	}

}
