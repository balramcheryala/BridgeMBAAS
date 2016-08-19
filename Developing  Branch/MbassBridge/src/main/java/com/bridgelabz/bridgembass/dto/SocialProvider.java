package com.bridgelabz.bridgembass.dto;

// TODO: Auto-generated Javadoc
/**
 * The Enum SocialProvider.
 */
public enum SocialProvider {

	/** The facebook. */
	// Enables for a variable to be a set of predefined constants.
	FACEBOOK("facebook"),
	/** The twitter. */
	TWITTER("twitter"),
	/** The linkedin. */
	LINKEDIN("linkedin"),
	/** The google. */
	GOOGLE("google"),
	/** The none. */
	NONE("local");

	/** The provider type. */
	private String providerType;

	/**
	 * Gets the provider type.
	 *
	 * @return the provider type
	 */
	public String getProviderType() {
		return providerType;
	}

	/**
	 * Instantiates a new social provider.
	 *
	 * @param providerType
	 *            the provider type
	 */
	SocialProvider(final String providerType) {
		this.providerType = providerType;
	}

}
