package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.ClientCredentialsModel;

public interface ClientCredentialservice {

	public void addClientCredentials(ClientCredentialsModel crud);

	public void updateClientCredentials(ClientCredentialsModel crud);

	public List<ClientCredentialsModel> listClientCredentialss();

	public ClientCredentialsModel getClientCredentials(int stdid);

	public void deleteClientCredentials(ClientCredentialsModel crud);
	
}
