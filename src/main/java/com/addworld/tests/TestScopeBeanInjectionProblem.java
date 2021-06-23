package com.addworld.tests;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.addworld.scope.AppConfig;
import com.addworld.scope.PrototypeBean;
import com.addworld.scope.SingletonBean;
import com.addworld.scope.SingletonFunctionBean;

public class TestScopeBeanInjectionProblem {
	public static void testScopedProxy() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SingletonBean singleton1 = context.getBean(SingletonBean.class);
		PrototypeBean prototype1 = context.getBean(PrototypeBean.class);
		
		SingletonBean singleton2 = context.getBean(SingletonBean.class);
		PrototypeBean prototype2 = context.getBean(PrototypeBean.class);
			
		System.out.println("Singleton - same instances: " + singleton1.equals(singleton2));
		System.out.println("Prototype - different instances: " + prototype1.equals(prototype2));
		
	}
	
	public static void testFunction() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		SingletonFunctionBean singletonFunctionBean1 = context.getBean(SingletonFunctionBean.class);
		SingletonFunctionBean singletonFunctionBean2 = context.getBean(SingletonFunctionBean.class);
		
		PrototypeBean prototype1 = singletonFunctionBean1.getPrototypeInstance("prototype1");
		PrototypeBean prototype2 = singletonFunctionBean1.getPrototypeInstance("prototype2");
		
		System.out.println("Singleton - same instances: " + singletonFunctionBean1.equals(singletonFunctionBean2));
		System.out.println("Prototype - different instances: " + prototype1.equals(prototype2));
		

		
	}
}
