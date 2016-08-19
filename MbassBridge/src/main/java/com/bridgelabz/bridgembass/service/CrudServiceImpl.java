package com.bridgelabz.bridgembass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.bridgembass.database.dao.CrudDao;
import com.bridgelabz.bridgembass.database.model.Crud;


// TODO: Auto-generated Javadoc
/**
 * The Class CrudServiceImpl.
 */
@Service("crudService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CrudServiceImpl implements CrudService {

	/** The crud dao. */
	@Autowired
	private CrudDao crudDao;
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.service.CrudService#addStudent(com.bridgelabz.bridgembass.database.model.Crud)
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(Crud crud) {
		crudDao.addStudent(crud);
	}
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.service.CrudService#listStudents()
	 */
	public List<Crud> listStudents() {
		return crudDao.listStudents();
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.service.CrudService#getStudent(int)
	 */
	public Crud getStudent(int id) {
		return crudDao.getStudent(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.service.CrudService#deleteStudent(com.bridgelabz.bridgembass.database.model.Crud)
	 */
	public void deleteStudent(Crud crud) {
		crudDao.deleteStudent(crud);
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.service.CrudService#update(com.bridgelabz.bridgembass.database.model.Crud)
	 */
	@Override
	public void update(Crud crud) {
		crudDao.update(crud);
		
	}

}
