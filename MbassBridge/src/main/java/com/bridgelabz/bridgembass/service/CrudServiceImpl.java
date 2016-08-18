package com.bridgelabz.bridgembass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.bridgembass.database.dao.CrudDao;
import com.bridgelabz.bridgembass.database.model.Crud;


@Service("crudService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CrudServiceImpl implements CrudService {

	@Autowired
	private CrudDao crudDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(Crud crud) {
		crudDao.addStudent(crud);
	}
	
	public List<Crud> listStudents() {
		return crudDao.listStudents();
	}

	public Crud getStudent(int id) {
		return crudDao.getStudent(id);
	}
	
	public void deleteStudent(Crud crud) {
		crudDao.deleteStudent(crud);
	}

	@Override
	public void update(Crud crud) {
		crudDao.update(crud);
		
	}

}
