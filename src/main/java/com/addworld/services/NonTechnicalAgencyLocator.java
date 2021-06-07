package com.addworld.services;

import com.addworld.data.entities.AddworldAgency;
import com.addworld.repositories.AddworldAgencyRepository;

public class NonTechnicalAgencyLocator implements AddworldAgencyLocator {
	
	private AddworldAgencyRepository repository;
	
	
	public AddworldAgencyRepository getRepository() {
		return repository;
	}



	public void setRepository(AddworldAgencyRepository repository) {
		this.repository = repository;
	}



	public AddworldAgency findAgencyByLocation(String agencyLocation) {
		
		for(AddworldAgency agency: repository.getAllAddworldAgencies()) {
			if (agency.getCity().equals(agencyLocation)) {
				return agency;
			}
		}
		
		return null;
		
	}

}
