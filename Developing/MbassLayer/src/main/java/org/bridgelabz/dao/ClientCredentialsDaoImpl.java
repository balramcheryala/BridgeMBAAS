package org.bridgelabz.dao;

import java.util.ArrayList;
import java.util.List;

import org.bridgelabz.model.ClientCredentialsModel;
import org.bridgelabz.model.FacebookDetails;
import org.bridgelabz.service.ClientDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/*implements ClientCredentialsModelDao.
 *created: Aug 18, 2016 11:33AM
 *Created By: Balram
 */

public class ClientCredentialsDaoImpl implements ClientCredentialsDao {
	@Autowired
	private SessionFactory sessionFactory;

	Session session;

	public void addClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().save(clientcredentialmodel);

	}

	public void updateClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession().update(clientcredentialmodel);

	}

	@SuppressWarnings("unchecked")
	public List<ClientCredentialsModel> listClientCredentials() {

		return sessionFactory.openSession().createCriteria(ClientCredentialsModel.class).list();
	}

	public ClientCredentialsModel getClientCredentials(int id) {
		return (ClientCredentialsModel) sessionFactory.openSession().get(ClientCredentialsModel.class, id);

	}

	public void deleteClientCredentials(ClientCredentialsModel clientcredentialmodel) {
		sessionFactory.openSession()
				.createQuery("DELETE FROM ClientCredentialsModel WHERE id = " + clientcredentialmodel.getId())
				.executeUpdate();

	}

	// getting the clientid and Client passwords Here
	public ArrayList<String> credentials(String projectname, String appType) {
		String appId;
		String appSecret;
		ArrayList<String> arrayList=new ArrayList<String>();
		Session s = sessionFactory.openSession();
		System.err.println("project name and provider:"+projectname+ " "+ appType);
		Query query = s.createQuery("from ClientCredentialsModel where projectName = ? and provider = ?");
		query.setParameter(0, projectname);
		query.setParameter(1, appType);
		List<ClientCredentialsModel> list = query.list();
		for (ClientCredentialsModel fd : list) {
			appId = fd.getClientid();
			appSecret=fd.getClientpassword();
			System.out.println("app id and secret:"+appId +" "+appSecret);
			arrayList.add(appId);
			arrayList.add(appSecret);
		}
		return arrayList;
	}

	// getting accesstoken from here
	@Override
	public ArrayList<String> AccessToken(String projectname, String tableName) {
		String accessToken = "";
		String facebookId="";
		ArrayList<String> arrayList=new ArrayList<String>();
		Session s = sessionFactory.openSession();
		Query query = s.createQuery("from " + tableName + " where projectName = ?");
		query.setParameter(0, projectname);
		List<FacebookDetails> list = query.list();
		for (FacebookDetails fd : list) {
			accessToken = fd.getAccessToken();
			facebookId=fd.getFacebookid();
			System.out.println("facebookId"+facebookId);
			arrayList.add(accessToken);
			arrayList.add(facebookId);	
		}
		System.out.println("access token:" + accessToken);
		return arrayList;
	}

}
