package com.addworld.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.addworld.data.repositories.AddworldProjectRepository;

public class TestJPA {

	public static void testJPA() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AddworldProjectRepository repo = context.getBean(AddworldProjectRepository.class);
		
		System.out.println(repo.findOne(1).getName());
		
		System.out.println(repo.findByName("Addworld Cloud"));
		
		System.out.println(repo.findByTeamId(1));
	}
}
