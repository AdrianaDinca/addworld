package com.addworld.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//basic bean dependency test
		//TestXMLBeanDependency.testXMLBeanDependency(context);
		
	}

}
