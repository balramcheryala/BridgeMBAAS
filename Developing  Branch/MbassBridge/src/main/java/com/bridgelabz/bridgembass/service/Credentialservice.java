package com.bridgelabz.bridgembass.service;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Credentials;

// TODO: Auto-generated Javadoc
/**
 * The Interface Credentialservice.
 */
public interface Credentialservice {
	
	/**
	 * Adds the student.
	 *
	 * @param crud
	 *            the crud
	 */
	public void addStudent(Credentials crud);

	/**
	 * Update.
	 *
	 * @param crud
	 *            the crud
	 */
	public void update(Credentials crud);

	/**
	 * List students.
	 *
	 * @return the list
	 */
	public List<Credentials> listStudents();

	/**
	 * Gets the student.
	 *
	 * @param stdid
	 *            the stdid
	 * @return the student
	 */
	public Credentials getStudent(int stdid);

	/**
	 * Delete student.
	 *
	 * @param crud
	 *            the crud
	 */
	public void deleteStudent(Credentials crud);
}
