package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bridgembass.database.model.Credentials;

/**
 * The Class ClientCredentialsDAOImpl.
 */
@Repository("ClientCredentials")
public class ClientCredentialsDAOImpl implements ClientCredentialsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * @see
	 * com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO#addStudent(
	 * com.bridgelabz.bridgembass.database.model.Credentials)
	 */
	@Override
	public void addStudent(Credentials ccd) {
		sessionFactory.openSession().save(ccd);

	}

	/*
	 * @see
	 * com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO#update(com.
	 * bridgelabz.bridgembass.database.model.Credentials)
	 */
	@Override
	public void update(Credentials ccd) {
		sessionFactory.openSession().update(ccd);

	}

	/*
	 * @see
	 * com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO#listStudents
	 * ()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Credentials> listStudents() {
		return (List<Credentials>) sessionFactory.openSession().createCriteria(Credentials.class).list();
	}

	/*
	 * @see
	 * com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO#getStudent(
	 * int)
	 */
	@Override
	public Credentials getStudent(int id) {
		return (Credentials) sessionFactory.openSession().get(Credentials.class, id);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO#
	 * deleteStudent(com.bridgelabz.bridgembass.database.model.Credentials)
	 */
	/*
	 * @see com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO#
	 * deleteStudent(com.bridgelabz.bridgembass.database.model.Credentials)
	 */
	@Override
	public void deleteStudent(Credentials ccd) {
		sessionFactory.openSession().createQuery("DELETE FROM Credentials WHERE id = " + ccd.getId()).executeUpdate();

	}

}
