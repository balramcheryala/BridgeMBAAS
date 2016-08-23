package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.ClientDetailsModel;

public interface ClientDetailsService {

	public void addClientDetails(ClientDetailsModel crud);

	public void updateClientDetails(ClientDetailsModel crud);

	public List<ClientDetailsModel> listClientDetails();

	public ClientDetailsModel getClientDetails(int stdid);

	public void deleteClientDetails(ClientDetailsModel crud);
}
