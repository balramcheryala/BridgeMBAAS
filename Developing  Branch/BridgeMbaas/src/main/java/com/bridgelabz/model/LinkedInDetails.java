package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LinkedInDetails")
public class LinkedInDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "LinkedinId")
	private String LinkedinId;

	@Column(name = "headline")
	private String headline;

	@Column(name = "industry")
	private String industry;

	@Column(name = "pictureUrl")
	private String pictureUrl;

	@Column(name = "publicProfileUrl")
	private String publicProfileUrl;

	public String getLinkedinId() {
		return LinkedinId;
	}

	public void setLinkedinId(String linkedinId) {
		LinkedinId = linkedinId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getPublicProfileUrl() {
		return publicProfileUrl;
	}

	public void setPublicProfileUrl(String publicProfileUrl) {
		this.publicProfileUrl = publicProfileUrl;
	}
}