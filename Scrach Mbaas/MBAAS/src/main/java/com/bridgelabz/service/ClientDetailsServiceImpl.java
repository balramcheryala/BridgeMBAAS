package com.bridgelabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.dao.ClientDetailsDao;
import com.bridgelabz.model.ClientDetailsModel;

@Service("cds")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private ClientDetailsDao cdd;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addClientDetails(ClientDetailsModel cdm) {
		cdd.addClientDetails(cdm);
	}

	public List<ClientDetailsModel> listClientDetails() {
		return cdd.listClientDetails();
	}

	public ClientDetailsModel getClientDetails(int id) {
		return cdd.getClientDetails(id);
	}

	public void deleteClientDetails(ClientDetailsModel cdm) {
		cdd.deleteClientDetails(cdm);
	}

	public void updateClientDetails(ClientDetailsModel cdm) {
		cdd.updateClientDetails(cdm);
		
	}

}
