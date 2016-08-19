package com.bridgelabz.bridgembass.database.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "USER")
public class User implements Serializable{

    /** The user id. */
    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    private String userId;

    /** The name. */
    @Column(name = "NAME", nullable = true, length = 32)
    private String name;

    /** The password. */
    @Column(name = "PASSWORD", nullable = true, length = 64)
    private String password;

    /** The email id. */
    @Column(name = "EMAIL_ID", nullable = true, length = 128)
    private String emailId;

    /** The active. */
    @Column(name = "ACTIVE", nullable = false, length = 1)
    private Integer active;

    /** The provider. */
    @Column(name = "PROVIDER", nullable = false, length = 32)
    private String provider;

    /** The roles. */
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles = new HashSet<>();

    /**
	 * Instantiates a new user.
	 */
    public User() {
    }

    /**
	 * Instantiates a new user.
	 *
	 * @param userId
	 *            the user id
	 * @param name
	 *            the name
	 * @param password
	 *            the password
	 * @param emailId
	 *            the email id
	 * @param active
	 *            the active
	 * @param provider
	 *            the provider
	 * @param roles
	 *            the roles
	 */
    public User(final String userId, final String name, final String password, final String emailId, final Integer active, final String provider, final Set<Role> roles) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.emailId = emailId;
        this.active = active;
        this.provider = provider;
        this.roles = roles;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
    public String getName() {
        return name;
    }

    /**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
    public void setName(final String name) {
        this.name = name;
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
	 * Gets the active.
	 *
	 * @return the active
	 */
    public Integer getActive() {
        return active;
    }

    /**
	 * Sets the active.
	 *
	 * @param active
	 *            the new active
	 */
    public void setActive(final Integer active) {
        this.active = active;
    }

    /**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
	 * Sets the roles.
	 *
	 * @param roles
	 *            the new roles
	 */
    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    /**
	 * Gets the provider.
	 *
	 * @return the provider
	 */
    public String getProvider() {
        return provider;
    }

    /**
	 * Sets the provider.
	 *
	 * @param provider
	 *            the new provider
	 */
    public void setProvider(final String provider) {
        this.provider = provider;
    }

    /**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
    public String getEmailId() {
        return emailId;
    }

    /**
	 * Sets the email id.
	 *
	 * @param emailId
	 *            the new email id
	 */
    public void setEmailId(final String emailId) {
        this.emailId = emailId;
    }
}
