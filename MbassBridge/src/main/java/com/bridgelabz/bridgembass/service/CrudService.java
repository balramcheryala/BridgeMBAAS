package com.bridgelabz.bridgembass.service;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Crud;

// TODO: Auto-generated Javadoc
/**
 * The Interface CrudService.
 */
public interface CrudService {

	/**
	 * Adds the student.
	 *
	 * @param crud
	 *            the crud
	 */
	public void addStudent(Crud crud);

	/**
	 * Update.
	 *
	 * @param crud
	 *            the crud
	 */
	public void update(Crud crud);

	/**
	 * List students.
	 *
	 * @return the list
	 */
	public List<Crud> listStudents();

	/**
	 * Gets the student.
	 *
	 * @param stdid
	 *            the stdid
	 * @return the student
	 */
	public Crud getStudent(int stdid);

	/**
	 * Delete student.
	 *
	 * @param crud
	 *            the crud
	 */
	public void deleteStudent(Crud crud);
}
