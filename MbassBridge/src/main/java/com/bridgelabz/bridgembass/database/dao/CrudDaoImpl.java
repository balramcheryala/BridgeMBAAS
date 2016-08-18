package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bridgembass.database.model.Crud;

@Repository("CrudDao")
public class CrudDaoImpl implements CrudDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Crud crud) {
		sessionFactory.getCurrentSession().saveOrUpdate(crud);
	}

	public void update(Crud crud) {
		sessionFactory.getCurrentSession().update(crud);
	}

	@SuppressWarnings("unchecked")
	public List<Crud> listStudents() {
		return (List<Crud>) sessionFactory.getCurrentSession().createCriteria(Crud.class).list();
	}

	public Crud getStudent(int id) {
		return (Crud) sessionFactory.getCurrentSession().get(Crud.class, id);
	}

	public void deleteStudent(Crud crud) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Crud WHERE id = " + crud.getId()).executeUpdate();
	}

}
