package org.bridgelabz.dao;

import java.util.List;

import org.bridgelabz.model.ClientCredentialsModel;
import org.hibernate.Query;
import org.hibernate.Session;
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

	Session session ;
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

	/* (non-Javadoc)
	 * @see org.bridgelabz.dao.ClientCredentialsDao#getId(java.lang.String)
	 */
	@Override
	public String getId(String provider) {
		System.out.println(provider);
		session = sessionFactory.openSession();
		String hql2 = "SELECT C.clientid FROM ClientCredentialsModel C where C.provider="+provider;
		Query query=session.createQuery(hql2);
		List results = query.list();
		System.out.println(results.toString());
		
		return provider;
	}

}
