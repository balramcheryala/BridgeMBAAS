package org.bridgelabz.dao;

import java.util.List;

import org.bridgelabz.model.ClientCredentialsModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*implements ClientCredentialsModelDao.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public class ClientCredentialsDaoImpl implements ClientCredentialsDao {
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
		sessionFactory.openSession()
				.createQuery("DELETE FROM ClientCredentialsModel WHERE id = " + clientcredentialmodel.getId())
				.executeUpdate();

	}

}
