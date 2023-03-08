package com.sms.genericutility.ExternalResources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	Statement stat;
	String col_values;
	int nonSelectResult;
	ResultSet selectResult;
/**
 * This method is used to get database connection
 * @param dbUrl
 * @param dbUsername
 * @param dbPasssword
 * @throws SQLException
 */
	public void getDbConnection(String dbUrl, String dbUsername, String dbPasssword) 
	{
		Driver driverRef;
		try {
			driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);	
		con=DriverManager.getConnection(dbUrl,dbUsername, dbPasssword);
		stat=con.createStatement();
		}
    catch (SQLException e) {
			
		}

	}
	/**
	 * This method is used to execute select query and fetch the data
	 * @param col_name
	 * @param selectquery
	 * @return
	 * @throws SQLException
	 */
	public String executeQuery(String col_name, String selectquery)
	{
	
		try {
			selectResult = stat.executeQuery(selectquery);
			while(selectResult.next())
			{
				 col_values=selectResult.getString(col_name);
				
			}	
		} catch (SQLException e) {
			
		}
		return col_values;

	}
/**
 * This method is used to execute non-select query
 * @param nonselectquery
 * @return
 * @throws SQLException
 */
	public int updateQuery(String nonSelectQuery) {

		
		try {
			nonSelectResult = stat.executeUpdate(nonSelectQuery);
		} catch (SQLException e) {
			
		}
		if(nonSelectResult==1)
		{
			System.out.println("database updated");
		}
		else
		{
			System.out.println("database not updated");
		}
		return nonSelectResult;
	}
	
	public void closeConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
		
		}
	}

}

