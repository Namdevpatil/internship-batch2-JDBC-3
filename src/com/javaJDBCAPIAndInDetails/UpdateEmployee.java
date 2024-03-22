package com.javaJDBCAPIAndInDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateEmployee 
{

	public static void main(String[] args) throws SQLException
	{



		Connection connection = null;

		try
		{

			//connection object created
			connection = DatabaseConnection.getDBConnection();

			Employee employee = new Employee(332, "Kumari Rani", "Business Analyst");
		
			//query 

			String query = "update employee set employee_name = ?,  employee_role = ? where employee_id = ?";

			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, employee.getEmployeeName());
			preparedStatement.setString(2, employee.getEmployeeRole());
			
			preparedStatement.setInt(3, employee.getEmployeeId());
			
			preparedStatement.executeUpdate();

			System.out.println("employee data updated.");

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
