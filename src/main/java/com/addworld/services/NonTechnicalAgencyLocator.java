package com.addworld.services;

import com.addworld.data.entities.AddworldAgency;

public class NonTechnicalAgencyLocator implements AddworldAgencyLocator {
	
	private AddworldAgencyCacheService agencyCacheService;
	
	
	public AddworldAgencyCacheService getAgencyCacheService() {
		return agencyCacheService;
	}



	public void setAgencyCacheService(AddworldAgencyCacheService agencyCacheService) {
		this.agencyCacheService = agencyCacheService;
	}



	public AddworldAgency findAgencyByLocation(String agencyLocation) {
		
		for(AddworldAgency agency: agencyCacheService.getAllAddworldAgencies()) {
			if (agency.getCity().equals(agencyLocation)) {
				return agency;
			}
		}
		
		return null;
		
	}

}
