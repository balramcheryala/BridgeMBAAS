package org.bridgelabz.dao;

import java.util.List;

import org.bridgelabz.model.ClientDetailsModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*implements ClientDetailsDao.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public class ClientDetailsDaoImpl implements ClientDetailsDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	public void addClientDetails(ClientDetailsModel clientdetailmodel) {
		sessionFactory.openSession().saveOrUpdate(clientdetailmodel);
	}

	public void updateClientDetails(ClientDetailsModel clientdetailmodel) {
		sessionFactory.openSession().update(clientdetailmodel);
	}

	public List<ClientDetailsModel> listClientDetails(String projectName) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from ClientDetailsModel where projectName=?");
		query.setString(0, projectName);
		List<ClientDetailsModel> clientDetailsModels = query.list();
		return clientDetailsModels;
	}

	public ClientDetailsModel getClientDetails(int id, String projectName) {
		return (ClientDetailsModel) sessionFactory.openSession().get(ClientDetailsModel.class, projectName);
	}

	public void deleteClientDetails(ClientDetailsModel clientdetailmodel) {
		sessionFactory.openSession().createQuery("DELETE FROM ClientDetailsModel WHERE useruid = ?")
				.setString(0, clientdetailmodel.getUseruid()).executeUpdate();
	}

}
