package com.bridgelabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.dao.ClientCredentialsModelDao;
import com.bridgelabz.model.ClientCredentialsModel;

@Service("credentialservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CredentialsServiceImpl implements ClientCredentialservice {
	@Autowired
	private ClientCredentialsModelDao cruddao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addClientCredentials(ClientCredentialsModel crud) {
		cruddao.addClientCredentials(crud);

	}

	public void updateClientCredentials(ClientCredentialsModel crud) {
		cruddao.updateClientCredentials(crud);

	}

	public List<ClientCredentialsModel> listClientCredentialss() {

		return cruddao.listClientCredentials();
	}

	public ClientCredentialsModel getClientCredentials(int stdid) {

		return cruddao.getClientCredentials(stdid);
	}

	public void deleteClientCredentials(ClientCredentialsModel crud) {
		cruddao.deleteClientCredentials(crud);
	}

}
