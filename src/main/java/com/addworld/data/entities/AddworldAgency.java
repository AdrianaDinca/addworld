package com.addworld.data.entities;

public class AddworldAgency {

	private Integer agencyId;
	private String name;
	private String address;
	private String city;
	private String state;
	private Integer postalCode;
	
	public Integer getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "AddworldAgency [agencyId=" + agencyId + ", name=" + name + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", postalCode=" + postalCode + "]";
	}
	
}
