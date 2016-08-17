package com.bridgelabz.bridgembass.dto;

public enum SocialProvider {
	
	// Enables for a variable to be a set of predefined constants.
	FACEBOOK("facebook"), TWITTER("twitter"), LINKEDIN("linkedin"), GOOGLE("google"), NONE("local");

	private String providerType;

	public String getProviderType() {
		return providerType;
	}

	SocialProvider(final String providerType) {
		this.providerType = providerType;
	}

}
