package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Credentials;

/**
 * The Interface ClientCredentials.
 */
public interface ClientCredentialsDAO {

	/**
	 * Adds the student.
	 *
	 * @param ccd
	 *            the ccd
	 */
	public void addStudent(Credentials ccd);

	/**
	 * Update.
	 *
	 * @param ccd
	 *            the ccd
	 */
	public void update(Credentials ccd);

	/**
	 * List students.
	 *
	 * @return the list
	 */
	public List<Credentials> listStudents();

	/**
	 * Gets the student.
	 *
	 * @param id
	 *            the id
	 * @return the student
	 */
	public Credentials getStudent(int id);

	/**
	 * Delete student.
	 *
	 * @param ccd
	 *            the ccd
	 */
	public void deleteStudent(Credentials ccd);
}
