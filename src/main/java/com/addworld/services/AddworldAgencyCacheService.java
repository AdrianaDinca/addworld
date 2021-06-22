package com.addworld.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.addworld.data.entities.AddworldAgency;

public class AddworldAgencyCacheService {
	private Map<Integer, AddworldAgency> agencyMap = new HashMap<Integer, AddworldAgency>();
	
	
	public void addAddworldAgency(AddworldAgency agency) {
		agencyMap.put(agency.getAgencyId(), agency);
	}
	
	public AddworldAgency getAddworldAgencyBasedOnId(Integer agencyId) {
		return agencyMap.get(agencyId);
	}
	
	public List<AddworldAgency> getAllAddworldAgencies() {
		return new ArrayList(agencyMap.values());
	}
}
