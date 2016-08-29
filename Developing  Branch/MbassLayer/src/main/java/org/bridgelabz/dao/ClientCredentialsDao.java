package org.bridgelabz.dao;

import java.util.List;

import org.bridgelabz.model.ClientCredentialsModel;

/*interface ClientCredentialsModelDao.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public interface ClientCredentialsDao {

	public void addClientCredentials(ClientCredentialsModel clientcredentialmodel);

	public void updateClientCredentials(ClientCredentialsModel clientcredentialmodel);

	public List<ClientCredentialsModel> listClientCredentials();

	public ClientCredentialsModel getClientCredentials(int id);

	public void deleteClientCredentials(ClientCredentialsModel clientcredentialmodel);

}
