package com.addworld.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCConnection {
	
	public static void testJdbcConnection() {
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		String sql = "insert into AGENCY values (?,?,?,?,?,?)";
		try {
			connection = DriverManager.getConnection("jdbc:mysql//localhost:3306/addworld", "addworld", "addworld");

			statement = connection.prepareStatement(sql);
			statement.setString(2,  "Addworld Headquarter");
			statement.setString(3, "Pipera 4");
			statement.setString(4, "Bucharest");
			statement.setString(4, "Romania");
			statement.setInt(6, 123456);

			
		} catch (SQLException e) {
			//log exception
		} finally {
			//close connection;
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				//log exception
			}
		}
		
	}

}
