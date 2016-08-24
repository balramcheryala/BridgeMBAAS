package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.ClientDetailsModel;

public interface ClientDetailsDao {

	public void addClientDetails(ClientDetailsModel cdm);

	public void updateClientDetails(ClientDetailsModel cdm);

	public List<ClientDetailsModel> listClientDetails();

	public ClientDetailsModel getClientDetails(int id);

	public void deleteClientDetails(ClientDetailsModel cdm);
}
