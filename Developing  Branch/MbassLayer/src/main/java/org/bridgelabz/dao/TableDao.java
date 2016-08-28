package org.bridgelabz.dao;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.validation.BindingResult;

public interface TableDao {
	
	public String getFile(String data, BindingResult result) throws IOException, Exception;
	public String insertJson(String data, BindingResult result) throws IOException, Exception;
	public int getId(String tableName, String column_Field, String column_Field_Value) throws ClassNotFoundException, IOException;
	public ArrayList<?>specificRecordDisplay(String  tableName, String column_Field, String rowIdValue) throws ClassNotFoundException, IOException;
}
