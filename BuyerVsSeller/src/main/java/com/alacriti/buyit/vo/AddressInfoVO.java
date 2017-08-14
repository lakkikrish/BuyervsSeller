package com.alacriti.buyit.vo;

public class AddressInfoVO {

	private int productId;
	private int customerId;
	private String street;
	private String city;
	private String state;
	private String country;
	private int zipcode;
	
	
	public AddressInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AddressInfoVO(int customerId,int productId, String street, String city, String state,
			String country, int zipcode) {
		this.productId = productId;
		this.customerId = customerId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getZipcode() {
		return zipcode;
	}


	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
}
