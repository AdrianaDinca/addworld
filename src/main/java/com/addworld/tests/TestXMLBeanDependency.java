package com.addworld.tests;

import org.springframework.context.ApplicationContext;

import com.addworld.data.entities.AddworldAgency;
import com.addworld.repositories.AddworldAgencyRepository;
import com.addworld.services.BookingAgencyService;

public class TestXMLBeanDependency {
	
	private static AddworldAgencyRepository repository;
	private static BookingAgencyService booking;
	
	public static void testXMLBeanDependency(ApplicationContext context) {
		repository = context.getBean(AddworldAgencyRepository.class);
		
		booking = context.getBean(BookingAgencyService.class); 
		
		pushDataIntoRepository();
		
		for(AddworldAgency agency: repository.getAllAddworldAgencies()) {
			System.out.println(agency.toString());
		}
		
		AddworldAgency agency = booking.findAgencyByLocation("Bucuresti");
		if (agency == null) {
			System.out.println("No agency in that location.");
		} else {
			System.out.println(agency.toString());
		}
	}
	
	public static void pushDataIntoRepository() {
		AddworldAgency agency1 = new AddworldAgency();
		agency1.setName("Agency 1");
		agency1.setAddress("Unirii 4");
		agency1.setCity("Bucharest");
		agency1.setState("Romania");
		agency1.setPostalCode(1010123);
		
		
		AddworldAgency agency2 = new AddworldAgency();
		agency2.setName("Agency 2");
		agency2.setAddress("Muncii 9");
		agency2.setCity("Timisoara");
		agency2.setState("Romania");
		agency2.setPostalCode(1030123);
		
		repository.addAddworldAgency(agency1);
		repository.addAddworldAgency(agency2);
		
		
	}
}
