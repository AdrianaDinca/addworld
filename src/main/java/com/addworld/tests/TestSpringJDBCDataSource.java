package com.addworld.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringJDBCDataSource {
	public static void testSpringJdbcDataSource() {
		Connection connection = null;
		//protect against SQL injection
		PreparedStatement statement = null;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		DataSource dataSource = context.getBean("datasource", DataSource.class);
		
		String sql = "insert into ADDWORLD_AGENCY values (?,?,?,?,?,?)";
		try {
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addworld", "addworld", "addworld");

			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, 4);
			statement.setString(2,  "Addworld Customer Care");
			statement.setString(3, "Orhideea 4");
			statement.setString(4, "Bucharest");
			statement.setString(5, "Romania");
			statement.setInt(6, 123656);

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
