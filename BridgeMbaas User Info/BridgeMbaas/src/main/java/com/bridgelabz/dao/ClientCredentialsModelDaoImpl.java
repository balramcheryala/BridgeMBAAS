package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.model.ClientCredentialsModel;

@Repository("ClientCredentialsModel")
public class ClientCredentialsModelDaoImpl implements ClientCredentialsModelDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addClientCredentials(ClientCredentialsModel ccm) {
		sessionFactory.getCurrentSession().save(ccm);

	}

	public void updateClientCredentials(ClientCredentialsModel ccm) {
		sessionFactory.getCurrentSession().update(ccm);

	}

	@SuppressWarnings("unchecked")

	@Transactional(readOnly = true)
	public List<ClientCredentialsModel> listClientCredentials() {

		return sessionFactory.getCurrentSession().createCriteria(ClientCredentialsModel.class).list();
	}

	public ClientCredentialsModel getClientCredentials(int id) {
		return (ClientCredentialsModel) sessionFactory.getCurrentSession().get(ClientCredentialsModel.class, id);

	}

	public void deleteClientCredentials(ClientCredentialsModel ccm) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ClientCredentialsModel WHERE id = " + ccm.getId())
				.executeUpdate();

	}

}
