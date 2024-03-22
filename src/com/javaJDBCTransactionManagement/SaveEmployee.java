package com.javaJDBCTransactionManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveEmployee 
{

	public static void main(String[] args) throws SQLException
	{
			
		Connection connection = null;
		
		try
		{
			
			//connection object created
			connection = DatabaseConnection.getDBConnection();
			
			connection.setAutoCommit(false);//***
			
			//query 
			//String query = "insert into employee(employee_id, employee_name, employee_role) values('"+employee.getEmployeeId()+"', '"+employee.getEmployeeName()+"', '"+employee.getEmployeeRole()+"')";
			String query = "insert into employee(employee_id, employee_name, employee_role) values(?, ?, ?)";
			
			//query statement object
			//Statement statement = connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			Employee employee = new Employee(330, "John", "Software Engineer");
			
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeeRole());
			
			//execute query statement
			int status = preparedStatement.executeUpdate();
			
			connection.commit();
			
			System.out.println(status+ " employee object stored in the database table.");
			
			
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
