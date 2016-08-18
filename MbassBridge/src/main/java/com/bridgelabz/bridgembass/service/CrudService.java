package com.bridgelabz.bridgembass.service;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Crud;

public interface CrudService {

	public void addStudent(Crud crud);

	public void update(Crud crud);

	public List<Crud> listStudents();

	public Crud getStudent(int stdid);

	public void deleteStudent(Crud crud);
}
