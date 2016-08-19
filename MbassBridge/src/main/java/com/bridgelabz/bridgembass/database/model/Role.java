package com.bridgelabz.bridgembass.database.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
// TODO: Auto-generated Javadoc

/**
 * The Class Role.
 */
@Entity
@Table(name = "ROLE")
public class Role implements Serializable {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The role id. */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID", unique = true, nullable = false)
    private Integer roleId;

    /** The name. */
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;

    /** The users. */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    /**
	 * Instantiates a new role.
	 */
    public Role() {
    }

    /**
	 * Instantiates a new role.
	 *
	 * @param roleId
	 *            the role id
	 * @param name
	 *            the name
	 * @param users
	 *            the users
	 */
    public Role(final Integer roleId, final String name, final Set<User> users) {
        this.roleId = roleId;
        this.name = name;
        this.users = users;
    }

    /**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
    public Integer getRoleId() {
        return roleId;
    }

    /**
	 * Sets the role id.
	 *
	 * @param roleId
	 *            the new role id
	 */
    public void setRoleId(final Integer roleId) {
        this.roleId = roleId;
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
	 * Gets the users.
	 *
	 * @return the users
	 */
    public Set<User> getUsers() {
        return users;
    }

    /**
	 * Sets the users.
	 *
	 * @param users
	 *            the new users
	 */
    public void setUsers(final Set<User> users) {
        this.users = users;
    }

    /**
	 * Adds the user.
	 *
	 * @param user
	 *            the user
	 */
    public void addUser(final User user)
    {
        this.users.add(user);
    }
}
