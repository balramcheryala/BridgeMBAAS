package com.bridgelabz.bridgembass.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRegistrationForm.
 */
public class UserRegistrationForm {

    /** The user id. */
    private String userId;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The phoneno. */
    private String phoneno;
    
    /** The email. */
    private String email;
    
    /** The password. */
    private String password;
    
    /** The social provider. */
    private SocialProvider socialProvider;

    /**
	 * Instantiates a new user registration form.
	 */
    public UserRegistrationForm() {
    }

    /**
	 * Instantiates a new user registration form.
	 *
	 * @param userId
	 *            the user id
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param phoneno
	 *            the phoneno
	 * @param email
	 *            the email
	 * @param password
	 *            the password
	 * @param socialProvider
	 *            the social provider
	 */
    public UserRegistrationForm(final String userId, final String firstName, final String lastName, final String phoneno, final String email, final String password, final SocialProvider socialProvider) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneno = phoneno;
        this.email = email;
        this.password = password;
        this.socialProvider = socialProvider;
    }

    /**
	 * Gets the builder.
	 *
	 * @return the builder
	 */
    public static Builder getBuilder() {
        return new Builder();
    }

    /**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
    public String getUserId() {
        return userId;
    }

    /**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
    public void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
    public String getFirstName() {
        return firstName;
    }

    /**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
    public String getLastName() {
        return lastName;
    }

    /**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
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
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
	 * Gets the password.
	 *
	 * @return the password
	 */
    public String getPassword() {
        return password;
    }

    /**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
	 * Gets the phoneno.
	 *
	 * @return the phoneno
	 */
    public String getPhoneno() {
        return phoneno;
    }

    /**
	 * Sets the phoneno.
	 *
	 * @param phoneno
	 *            the new phoneno
	 */
    public void setPhoneno(final String phoneno) {
        this.phoneno = phoneno;
    }

    /**
	 * Gets the social provider.
	 *
	 * @return the social provider
	 */
    public SocialProvider getSocialProvider() {
        return socialProvider;
    }

    /**
	 * Sets the social provider.
	 *
	 * @param socialProvider
	 *            the new social provider
	 */
    public void setSocialProvider(final SocialProvider socialProvider) {
        this.socialProvider = socialProvider;
    }

    /**
	 * The Class Builder.
	 */
    public static class Builder {
        
        /** The user id. */
        private String userId;
        
        /** The first name. */
        private String firstName;
        
        /** The last name. */
        private String lastName;
        
        /** The phoneno. */
        private String phoneno;
        
        /** The email. */
        private String email;
        
        /** The password. */
        private String password;
        
        /** The social provider. */
        private SocialProvider socialProvider;

        /**
		 * Adds the user id.
		 *
		 * @param userId
		 *            the user id
		 * @return the builder
		 */
        public Builder addUserId(final String userId) {
            this.userId = userId;
            return this;
        }

        /**
		 * Adds the first name.
		 *
		 * @param firstName
		 *            the first name
		 * @return the builder
		 */
        public Builder addFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
		 * Adds the last name.
		 *
		 * @param lastName
		 *            the last name
		 * @return the builder
		 */
        public Builder addLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
		 * Adds the email.
		 *
		 * @param email
		 *            the email
		 * @return the builder
		 */
        public Builder addEmail(final String email) {
            this.email = email;
            return this;
        }

        /**
		 * Adds the password.
		 *
		 * @param password
		 *            the password
		 * @return the builder
		 */
        public Builder addPassword(final String password) {
            this.password = password;
            return this;
        }

        /**
		 * Adds the phone no.
		 *
		 * @param phoneno
		 *            the phoneno
		 * @return the builder
		 */
        public Builder addPhoneNo(final String phoneno) {
            this.phoneno = phoneno;
            return this;
        }

        /**
		 * Adds the social provider.
		 *
		 * @param socialProvider
		 *            the social provider
		 * @return the builder
		 */
        public Builder addSocialProvider(final SocialProvider socialProvider) {
            this.socialProvider = socialProvider;
            return this;
        }

        /**
		 * Builds the.
		 *
		 * @return the user registration form
		 */
        public UserRegistrationForm build() {
            return new UserRegistrationForm(userId, firstName, lastName, phoneno, email, password, socialProvider);
        }
    }
}
