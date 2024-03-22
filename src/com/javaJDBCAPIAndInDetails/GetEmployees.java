package com.javaJDBCAPIAndInDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployees 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			//query 
			//String query = "select * from employee";
			String query = "select * from employee";
			
			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt(1)+" | "+resultSet.getString(2)+" | "+resultSet.getString(3));
			}


		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			connection.close();
		}

	}

}
