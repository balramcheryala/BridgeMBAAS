package com.bridgelabz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.ClientDetailsModel;

@Repository("ClientDetailsModelDao")
public class ClientDetailsDaoImpl implements ClientDetailsDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	public void addClientDetails(ClientDetailsModel cdm) {
		sessionFactory.getCurrentSession().saveOrUpdate(cdm);
	}

	public void updateClientDetails(ClientDetailsModel cdm) {
		sessionFactory.getCurrentSession().update(cdm);
	}

	@SuppressWarnings("unchecked")
	public List<ClientDetailsModel> listClientDetails() {
		return sessionFactory.getCurrentSession().createCriteria(ClientDetailsModel.class).list();
	}

	public ClientDetailsModel getClientDetails(int id) {
		return (ClientDetailsModel) sessionFactory.getCurrentSession().get(ClientDetailsModel.class, id);
	}

	public void deleteClientDetails(ClientDetailsModel cdm) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ClientDetailsModel WHERE id = " + cdm.getId())
				.executeUpdate();
	}


}
