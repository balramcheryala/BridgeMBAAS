package org.bridgelabz.dao;

import java.io.IOException;
import org.springframework.validation.BindingResult;

public interface TableDao {
	
	public String getFile(String data, BindingResult result) throws IOException, Exception;
	public String insertJson(String data, BindingResult result) throws IOException, Exception;
	public String getDBSchema(String mSchemaName);
}
