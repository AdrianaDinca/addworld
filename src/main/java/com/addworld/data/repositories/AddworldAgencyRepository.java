package com.addworld.data.repositories;

import java.util.List;

import com.addworld.data.entities.AddworldAgency;

public interface AddworldAgencyRepository extends AddworldRepository<AddworldAgency> {
	public String findAgencyNameById(Integer agencyId);
	
	public List<AddworldAgency> findAgencyByState(String state);
	
	public void insertUsingAutoGenId(final AddworldAgency agency);

}
