package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.bridgelabz.model.ClientCredentialsModel;

@Repository("ClientCredentialsModel")
public class ClientCredentialsModelDaoImpl implements ClientCredentialsModelDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().save(clientcredentialmodel);

	}

	public void updateClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().update(clientcredentialmodel);

	}

	@SuppressWarnings("unchecked")
	public List<ClientCredentialsModel> listClientCredentials() {

		return sessionFactory.openSession().createCriteria(ClientCredentialsModel.class).list();
	}

	public ClientCredentialsModel getClientCredentials(int id) {
		return (ClientCredentialsModel) sessionFactory.openSession().get(ClientCredentialsModel.class, id);

	}

	public void deleteClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().createQuery("DELETE FROM ClientCredentialsModel WHERE id = " + clientcredentialmodel.getId())
				.executeUpdate();

	}


}