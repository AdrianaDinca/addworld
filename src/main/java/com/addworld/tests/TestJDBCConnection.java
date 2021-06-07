package com.addworld.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCConnection {
	
	public static void testJdbcConnection() {
		Connection connection = null;
		//protect against SQL injection
		PreparedStatement statement = null;
		
		String sql = "insert into ADDWORLD_AGENCY values (?,?,?,?,?,?)";
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addworld", "addworld", "addworld");

			statement = connection.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setString(2,  "Addworld Headquarter");
			statement.setString(3, "Pipera 4");
			statement.setString(4, "Bucharest");
			statement.setString(5, "Romania");
			statement.setInt(6, 123456);

			statement.execute();
			
		} catch (SQLException e) {
			//log exception
			System.out.println(e.getMessage());
		} finally {
			//close connection;
			try {
				if (statement != null) {
					statement.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
