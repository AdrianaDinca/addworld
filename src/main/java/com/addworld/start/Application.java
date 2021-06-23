package com.addworld.start;

import com.addworld.tests.TestJDBCTemplate;
import com.addworld.tests.TestJPA;
import com.addworld.tests.TestScopeBeanInjectionProblem;

public class Application {
	
	public static void main(String[] args) {
		
		//basic bean dependency test
		//TestXMLBeanDependency.testXMLBeanDependency();
		
		//connect to db via mysql jdbc driver
		//TestJDBCConnection.testJdbcConnection();
		
		//use datasource
		//TestSpringJDBCDataSource.testSpringJdbcDataSource();
		
		//use jdbc template
		//TestJDBCTemplate.testJDBCTemplate();
		
		//test jpa
		//TestJPA.testJPA();
	
		//test scoped bean injection problem with scoped proxy
		//TestScopeBeanInjectionProblem.testScopedProxy();
		
		//test scoped bean injection problem with java.util.Function
		TestScopeBeanInjectionProblem.testFunction();
		
		
	}

}
