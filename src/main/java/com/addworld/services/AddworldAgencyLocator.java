package com.addworld.services;

import com.addworld.data.entities.AddworldAgency;

public interface AddworldAgencyLocator {

	AddworldAgency findAgencyByLocation(String agencyLocation);
}
