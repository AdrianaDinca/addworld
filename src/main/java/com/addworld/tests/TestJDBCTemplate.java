package com.addworld.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.addworld.data.entities.AddworldAgency;
import com.addworld.data.repositories.AddworldAgencyRepository;
import com.addworld.data.repositories.AddworldRepository;

public class TestJDBCTemplate {

	public static void testJDBCTemplate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AddworldAgencyRepository repo = context.getBean(com.addworld.data.repositories.AddworldAgencyRepository.class);
		System.out.println("FIND AGENCY NAME BY ID");
		System.out.println(repo.findAgencyNameById(2));
		System.out.println("FIND AGENCY BY ID");
		System.out.println(repo.findById(2));
		System.out.println("FIND AGENCY BY STATE");
		System.out.println(repo.findAgencyByState("Romania"));	
		
		
		/*AddworldAgency agency = getAddworldAgency();
		agency.setAgencyId(5);
	
		repo.insert(agency);
		System.out.println("FIND AGENCY NAME WITH ID 5");
		System.out.println(repo.findAgencyNameById(5));*/
		
		/*repo.insertUsingAutoGenId(agency);
		System.out.println("FIND AGENCY NAME WITH AUTO GEN ID " + agency.getAgencyId());
		System.out.println(repo.findAgencyNameById(agency.getAgencyId()));*/
		
		/*AddworldAgency agency = repo.findById(6);
		agency.setName("Update Test");
		repo.update(agency);*/
		
		AddworldAgency agency = repo.findById(6);
		repo.delete(agency);
		
	}
	
	
	public static AddworldAgency getAddworldAgency() {
		AddworldAgency agency = new AddworldAgency();
		agency.setName("Addworld Research and Development 2");
		agency.setAddress("Orhideea 4");
		agency.setCity("Bucharest");
		agency.setState("Romania");
		agency.setPostalCode(123656);
		return agency;
	}
}
