package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bridgembass.database.model.Crud;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudDaoImpl.
 *
 * @author bridgelabz
 */
@Repository("CrudDao")
public class CrudDaoImpl implements CrudDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.database.dao.CrudDao#addStudent(com.bridgelabz.bridgembass.database.model.Crud)
	 */
	public void addStudent(Crud crud) {
		sessionFactory.getCurrentSession().saveOrUpdate(crud);
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.database.dao.CrudDao#update(com.bridgelabz.bridgembass.database.model.Crud)
	 */
	public void update(Crud crud) {
		sessionFactory.getCurrentSession().update(crud);
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.database.dao.CrudDao#listStudents()
	 */
	@SuppressWarnings("unchecked")
	public List<Crud> listStudents() {
		return (List<Crud>) sessionFactory.getCurrentSession().createCriteria(Crud.class).list();
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.database.dao.CrudDao#getStudent(int)
	 */
	public Crud getStudent(int id) {
		return (Crud) sessionFactory.getCurrentSession().get(Crud.class, id);
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.bridgembass.database.dao.CrudDao#deleteStudent(com.bridgelabz.bridgembass.database.model.Crud)
	 */
	public void deleteStudent(Crud crud) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Crud WHERE id = " + crud.getId()).executeUpdate();
	}

}
