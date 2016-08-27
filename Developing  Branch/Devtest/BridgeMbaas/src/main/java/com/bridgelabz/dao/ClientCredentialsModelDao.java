package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.ClientCredentialsModel;

public interface ClientCredentialsModelDao {

	public void addClientCredentials(ClientCredentialsModel clientcredentialmodel);

	public void updateClientCredentials(ClientCredentialsModel clientcredentialmodel);

	public List<ClientCredentialsModel> listClientCredentials();

	public ClientCredentialsModel getClientCredentials(int id);

	public void deleteClientCredentials(ClientCredentialsModel clientcredentialmodel);
	
	
}
