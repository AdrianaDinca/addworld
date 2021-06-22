package com.addworld.start;

import com.addworld.tests.TestJDBCTemplate;

public class Application {
	
	public static void main(String[] args) {
		
		//basic bean dependency test
		//TestXMLBeanDependency.testXMLBeanDependency();
		
		//connect to db via mysql jdbc driver
		//TestJDBCConnection.testJdbcConnection();
		
		//use datasource
		//TestSpringJDBCDataSource.testSpringJdbcDataSource();
		
		//use jdbc template
		TestJDBCTemplate.testJDBCTemplate();
		
	
	}

}
