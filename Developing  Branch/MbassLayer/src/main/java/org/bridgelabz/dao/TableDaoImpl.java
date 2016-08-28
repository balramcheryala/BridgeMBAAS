package org.bridgelabz.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;

import com.mysql.jdbc.ResultSetMetaData;

@Repository("dao")
public class TableDaoImpl implements TableDao {
	/** The m table name. */
	public String mTableName = null;
	public String mcolumnField = null;
	public String mcol_data_type = null;
	/** The json objects keys. */
	public Map<String, String> pair = new HashMap<String, String>();
	/** The db connection. */
	static Connection dbConnection = null;

	/** The pstmt. */
	PreparedStatement pstmt = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.bridgelabz.dao.TableDao#getFile(java.lang.String,
	 * org.springframework.validation.BindingResult)
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	public String getFile(String uploadedValidFile, BindingResult result) throws IOException, Exception {
		JSONObject jsonObject = new JSONObject(uploadedValidFile);
		// loop to get the dynamic key
		for (Object keys : jsonObject.keySet()) {
			mTableName = (String) keys;
		}
		String dataType = null;
		JSONObject valueObject = null;
		String strArray[] = null;
		JSONArray jsonArray = jsonObject.getJSONArray(mTableName);
		if (jsonArray != null && jsonArray.length() > 0) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject object = jsonArray.optJSONObject(i);
				Iterator<String> iterator = (Iterator<String>) object.keys();
				while (iterator.hasNext()) {
					mcolumnField = iterator.next();
					if (mcolumnField instanceof String)
						valueObject = new JSONObject(object.get(mcolumnField).toString());
					dataType = valueObject.getString("type");
					mcol_data_type = returnDataType(dataType);
					pair.put(mcolumnField, mcol_data_type);
				}
			}
		}
		try {
			dbConnection = getConnection();
			DatabaseMetaData dbm = dbConnection.getMetaData();
			// check if table is there
			ResultSet table = dbm.getTables(null, null, mTableName, null);
			if (table.next()) {
				// Table exists
				System.out.println("table name already exist in Database..!");
			} else {
				// Table does not exist
				// create SQL query to create new table Team
				String query = null;
				String id = "bridge_id int AUTO_INCREMENT PRIMARY KEY";
				System.out.println("tablename :" + mTableName);
				query = "create table " + mTableName + "( " + id + ",";
				Iterator itr = pair.entrySet().iterator();
				Set<Map.Entry<String, String>> entrySet = pair.entrySet();
				for (int i = 0; i < entrySet.size(); i++) {
					Map.Entry pairs = (Map.Entry) itr.next();
					query = query + pairs.getKey() + " " + pairs.getValue();
					if (i != entrySet.size() - 1) {
						query = query + ",";
					}
				}
				query = query + ");";
				System.out.println("table create query :" + query);
				// create a statement
				pstmt = dbConnection.prepareStatement(query);
				// Step 5 Executing SQL & retrieve data into ResultSet
				int sqlQueryResult = pstmt.executeUpdate();
				// output of database creation
				if (0 == sqlQueryResult) {
					System.out.println("New table created successfully");
				} else {
					System.out.println("Error in creating table");
				}
				pair.clear();
			}
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return "showFile";
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream(
				"/home/bridgeit/Downloads/EmbaasLayer-master/MbassLayer/src/main/webapp/WEB-INF/dbConnection.properties");
		// load a properties file
		prop.load(input);
		String drivers = prop.getProperty("jdbc.driver");
		String connectionURL = prop.getProperty("jdbc.url");
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");
		Class.forName(drivers);
		dbConnection = DriverManager.getConnection(connectionURL, username, password);
		return dbConnection;
	}
	public String returnDataType(String data_type) {
		String col_data_type = null;
		switch (data_type) {

		case "string":
			col_data_type = "varchar(80)";
			break;
		}
		return col_data_type;
	}

	/* (non-Javadoc)
	 * @see com.bridgelabz.dao.TableDao#insertJson(java.lang.String, org.springframework.validation.BindingResult)
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public String insertJson(String jsonData, BindingResult result) throws IOException, Exception {
		JSONObject jsonObject = new JSONObject(jsonData);
		System.out.println("jsonObject Array :"+jsonObject.toString());
		// loop to get the dynamic key
		for (Object keys : jsonObject.keySet()) {
			mTableName = (String) keys;
		}
		try {
			dbConnection = getConnection();
				Set<String> keyset = null;
				List<String> values = new ArrayList<String>();
				JSONArray jsonArray = jsonObject.getJSONArray(mTableName);
				if (jsonArray != null && jsonArray.length() > 0) {
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject object = jsonArray.optJSONObject(i);
						keyset = object.keySet();
						Iterator<String> iterator = (Iterator<String>) object.keys();
						while (iterator.hasNext()) {
							String key = iterator.next();
							String value = object.getString(key);
							values.add(value);
						}
					}
					}
				String jsonkey[] = keyset.toArray(new String[keyset.size()]);
				String jsonValues[] = values.toArray(new String[values.size()]);
				// create the MYSQL insert PreparedStatement
				String insert_Query = "insert into " + mTableName + " (";
				for (int i = 0; i < jsonkey.length; i++) {
					insert_Query = insert_Query + jsonkey[i];
					if (i != jsonkey.length - 1) {
						insert_Query = insert_Query + ",";
					}
				}
				insert_Query = insert_Query + ")" + " values" + "(";
				int index = 0;
				for (int j = 0; j < jsonkey.length; j++) {
					if (j != jsonkey.length - 1) {
						insert_Query = insert_Query + "?" + ",";
					}
				}
				insert_Query = insert_Query + "?);";
				pstmt = dbConnection.prepareStatement(insert_Query);
				for (int j = 0; j <jsonValues.length; j++) {
					pstmt.setString(++index, jsonValues[j]);
				}
				int i = pstmt.executeUpdate();
				if (i != 0) {
					System.out.println("json Data Inserted into Database");
				} else {
					System.out.println("not Inserted");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "successJson";
	}
	
	/* (non-Javadoc)
	 * @see com.bridgelabz.dao.TableDao#getId(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int getId(String tableName,String column_Field,String column_Filed_Value) throws ClassNotFoundException, IOException
	{
		int generatedKey =0;
		try {
			dbConnection = getConnection();
			String select_id="select bridge_id from "+tableName+" where "+column_Field+"="+"'"+column_Filed_Value+"'"+';';
			System.out.println("id query :"+select_id);
			pstmt=dbConnection.prepareStatement(select_id);
			
			ResultSet rs=pstmt.executeQuery(select_id);
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
			System.out.println("inserted record id :"+generatedKey);
			returnID(generatedKey);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return generatedKey;
	}
	public int returnID(int row_Id)
	{
		System.out.println("inserted record row id :"+row_Id);
		return row_Id;
	}
	@Override
	public ArrayList<?> specificRecordDisplay(String tableName, String column_Field, String rowIdValue)
			throws ClassNotFoundException, IOException {
		JSONArray myArrayOfRefs= new JSONArray();
        JSONObject myObject = new JSONObject();
        String[]strArray=null;
        String data=null;
		try {
			dbConnection = getConnection();
			String select_query="select * from "+tableName+" where "+column_Field+"="+rowIdValue+';';
			System.out.println("select query :"+select_query);
			pstmt=dbConnection.prepareStatement(select_query);
			ResultSet rs=pstmt.executeQuery(select_query);
			ResultSetMetaData resultSetMetaData=(ResultSetMetaData) rs.getMetaData();
			System.out.println("count :"+resultSetMetaData.getColumnCount());
			for(int i=1;i<=resultSetMetaData.getColumnCount();i++)
			{
				while(rs.next()) {
				data=rs.getString(i);
				}
				strArray=data.split("");
			}
			for(String s:strArray)
			{
				System.out.println(s);
			}
			/*int j=0;
			while(rs.next()) {
				try
				{
					for(j=1;j<10;j++)
					{
					System.out.println(rs.getString(j));
					}
					j++;*/
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
}
