package com.bridgelabz.bridgembass.database.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class Crud.
 */
@Entity
@Table(name = "crudtable")
public class Crud implements Serializable {
	
	/** The date. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date date;

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -723583058586873479L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/** The email. */
	@Column(name = "email")
	private String email;

	/** The providers. */
	@Column(name = "providers")
	private String providers;

	/** The created. */
	@Column(name = "createdDate")
	@Temporal(TemporalType.DATE)
	private Date created;

	/** The signedin. */
	@Column(name = "signedinDate")
	@Temporal(TemporalType.DATE)
	private Date signedin;

	/** The useruid. */
	@Column(name = "useruid")
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
