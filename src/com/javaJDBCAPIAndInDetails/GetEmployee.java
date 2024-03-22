package com.javaJDBCAPIAndInDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetEmployee 
{

	public static void main(String[] args) throws SQLException
	{
		
		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			//query 
			//String query = "select * from employee where employee_id = '"+employee.getEmployeeId()+"'";
			String query = "select * from employee where employee_id = ?";

			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			Employee employee = new Employee();
			employee.setEmployeeId(117);
			
			preparedStatement.setInt(1, employee.getEmployeeId());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String role = resultSet.getString(3);
				
				Employee employee2 = new Employee(id, name, role);
				
				System.out.println(employee2.toString());
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
