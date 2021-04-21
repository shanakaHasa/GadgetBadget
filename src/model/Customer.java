package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {
	private Connection connect()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");

			//Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gadgetbadget?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		}
		catch (Exception e)
		{e.printStackTrace();}
		return con;
	}
	public String insertCustomer(String C_id, String C_name, String C_type, String Added_date, String email, String password)
	{
		String output = "";
		try
		{
			Connection con = connect();
			if (con == null)
			{return "Error while connecting to the database for inserting."; }
			// create a prepared statement
			String query = " insert into customers(`customerID`,`customerName`,`customerType`,`addedDate`,`email`,`password`)" + " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, C_name);
			preparedStmt.setString(3, C_type);
			preparedStmt.setString(4, Added_date);
			preparedStmt.setString(5, email);
			preparedStmt.setString(6, password);
			
			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		}
		catch (Exception e)
		{
			output = "Error while inserting the customer.";
			System.err.println(e.getMessage());
		}
		return output;
	}
	
}


