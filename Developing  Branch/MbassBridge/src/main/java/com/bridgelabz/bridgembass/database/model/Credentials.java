package com.bridgelabz.bridgembass.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The Class Credentials.
 */
@Entity
@Table(name = "Credentials")
public class Credentials {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	/** The app ID. */
	@Column(name = "app_ID")
	private String app_ID;

	/** The app secrete. */
	@Column(name = "app_Secrete")
	private String app_Secrete;

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
	 * Gets the app ID.
	 *
	 * @return the app ID
	 */
	public String getApp_ID() {
		return app_ID;
	}

	/**
	 * Sets the app ID.
	 *
	 * @param app_ID
	 *            the new app ID
	 */
	public void setApp_ID(String app_ID) {
		this.app_ID = app_ID;
	}

	/**
	 * Gets the app secrete.
	 *
	 * @return the app secrete
	 */
	public String getApp_Secrete() {
		return app_Secrete;
	}

	/**
	 * Sets the app secrete.
	 *
	 * @param app_Secrete
	 *            the new app secrete
	 */
	public void setApp_Secrete(String app_Secrete) {
		this.app_Secrete = app_Secrete;
	}

	/*
	 * java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Credentials [id=" + id + ", app_ID=" + app_ID + ", app_Secrete=" + app_Secrete + "]";
	}
}
