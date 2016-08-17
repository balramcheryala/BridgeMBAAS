package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Crud;

public interface CrudDao {
	
	public void addStudent(Crud crud);

	public List<Crud> listStudents();
	
	public Crud getStudent(int id);
	
	public void deleteStudent(Crud crud);
}
