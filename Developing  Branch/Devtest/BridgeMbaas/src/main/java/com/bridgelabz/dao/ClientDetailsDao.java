package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.model.ClientDetailsModel;

public interface ClientDetailsDao {

	public void addClientDetails(ClientDetailsModel clientdetailmodel);

	public void updateClientDetails(ClientDetailsModel clientdetailmodel);

	public List<ClientDetailsModel> listClientDetails();

	public ClientDetailsModel getClientDetails(int id);

	public void deleteClientDetails(ClientDetailsModel clientdetailmodel);
}
