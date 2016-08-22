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
		sessionFactory.openSession().save(ccm);

	}

	public void updateClientCredentials(ClientCredentialsModel ccm) {
		sessionFactory.openSession().update(ccm);

	}

	@SuppressWarnings("unchecked")

	@Transactional(readOnly = true)
	public List<ClientCredentialsModel> listClientCredentials() {

		return sessionFactory.openSession().createCriteria(ClientCredentialsModel.class).list();
	}

	public ClientCredentialsModel getClientCredentials(int id) {
		return (ClientCredentialsModel) sessionFactory.openSession().get(ClientCredentialsModel.class, id);

	}

	public void deleteClientCredentials(ClientCredentialsModel ccm) {
		sessionFactory.openSession().createQuery("DELETE FROM ClientCredentialsModel WHERE id = " + ccm.getId())
				.executeUpdate();

	}

}
