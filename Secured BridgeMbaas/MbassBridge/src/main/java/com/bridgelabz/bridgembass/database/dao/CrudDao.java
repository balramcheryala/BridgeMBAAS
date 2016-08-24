package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Crud;

// TODO: Auto-generated Javadoc
/**
 * The Interface CrudDao.
 */
public interface CrudDao {

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
	 * @param id
	 *            the id
	 * @return the student
	 */
	public Crud getStudent(int id);

	/**
	 * Delete student.
	 *
	 * @param crud
	 *            the crud
	 */
	public void deleteStudent(Crud crud);
}
