package com.javaJDBCAPIAndInDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			Employee employee = new Employee();
			employee.setEmployeeId(330);
		
			//query 

			String query = "delete from employee where employee_id = ?";

			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, employee.getEmployeeId());
			
			preparedStatement.executeUpdate();

			System.out.println("employee data deleted.");

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
