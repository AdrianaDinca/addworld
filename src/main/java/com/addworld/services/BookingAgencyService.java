package com.addworld.services;

import com.addworld.data.entities.AddworldAgency;

public class BookingAgencyService {

	private AddworldAgencyLocator addworldAgencyLocator;
	
	public BookingAgencyService(AddworldAgencyLocator addworldAgencyLocator) {
		this.addworldAgencyLocator = addworldAgencyLocator;
		
	}
	
	public AddworldAgency findAgencyByLocation(String agencyLocation) {
		AddworldAgency agency = addworldAgencyLocator.findAgencyByLocation(agencyLocation);
		return agency;
	}
}
