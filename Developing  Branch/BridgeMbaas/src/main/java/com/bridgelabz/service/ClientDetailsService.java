package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.model.ClientDetailsModel;

/*class interface ClientDetailsService
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public interface ClientDetailsService {

	public void addClientDetails(ClientDetailsModel crud);

	public void updateClientDetails(ClientDetailsModel crud);

	public List<ClientDetailsModel> listClientDetails();

	public ClientDetailsModel getClientDetails(int stdid);

	public void deleteClientDetails(ClientDetailsModel crud);
}
