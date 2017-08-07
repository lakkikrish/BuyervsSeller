package com.alacriti.buyervsseller.vo;

public class OrdersVO {
	private int customerId;
	private String street;
	private String city;
	private String state;
	private String country;
	private int zipcode;
	private int productId;
	private String orderStatus;

	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersVO(int customerId,String street,String city,String state,String country,int zipcode) {
	
		this.customerId=customerId;
		this.street=street;
		this.city=city;
		this.state=state;
		this.country=country;
		this.zipcode=zipcode;
	}
	public OrdersVO(int customerId, int productId,String orderStatus){
		this.customerId=customerId;
		this.productId=productId;
		this.orderStatus=orderStatus;
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
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	

}
