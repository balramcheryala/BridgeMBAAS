package com.bridgelabz.bridgembass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.bridgembass.database.dao.ClientCredentialsDAO;
import com.bridgelabz.bridgembass.database.model.Credentials;

@Service("credentialservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CredentialsServiceImpl implements Credentialservice {
	@Autowired
	private ClientCredentialsDAO cruddao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(Credentials crud) {
		cruddao.addStudent(crud);

	}

	@Override
	public void update(Credentials crud) {
		cruddao.update(crud);

	}

	@Override
	public List<Credentials> listStudents() {
		
		return cruddao.listStudents();
	}

	@Override
	public Credentials getStudent(int stdid) {
		
		return cruddao.getStudent(stdid);
	}

	@Override
	public void deleteStudent(Credentials crud) {
		cruddao.deleteStudent(crud);
	}

}
