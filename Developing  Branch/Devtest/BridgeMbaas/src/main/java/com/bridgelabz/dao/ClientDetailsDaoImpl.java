package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.ClientDetailsModel;

@Repository("ClientDetailsModel")
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

	@SuppressWarnings("unchecked")
	public List<ClientDetailsModel> listClientDetails() {
		return sessionFactory.openSession().createCriteria(ClientDetailsModel.class).list();
	}

	public ClientDetailsModel getClientDetails(int id) {
		return (ClientDetailsModel) sessionFactory.openSession().get(ClientDetailsModel.class, id);
	}

	public void deleteClientDetails(ClientDetailsModel clientdetailmodel) {
		sessionFactory.openSession().createQuery("DELETE FROM ClientDetailsModel WHERE id = " + clientdetailmodel.getId())
				.executeUpdate();
	}


}
