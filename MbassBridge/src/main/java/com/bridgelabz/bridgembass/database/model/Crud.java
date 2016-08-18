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

@Entity
@Table(name = "crudtable")
public class Crud implements Serializable {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date date;

	public void setId(Integer id) {
		this.id = id;
	}

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "email")
	private String email;

	@Column(name = "providers")
	private String providers;

	@Column(name = "createdDate")
	@Temporal(TemporalType.DATE)
	private Date created;

	@Column(name = "signedinDate")
	@Temporal(TemporalType.DATE)
	private Date signedin;

	@Column(name = "useruid")
	private String useruid;

	public Integer getId() {
		return id;
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
