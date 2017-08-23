package com.alacriti.buyit.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrdersVO {
	private int customerId;
	private String street;
	private String city;
	private String state;
	private String country;
	private int zipcode;
	private int productId;
	private String orderStatus;
	private String cardNumber;
	private String cardType;
	private String CardName;
	private String date;
	private int cvv;
	private boolean cashOnDelivery;
	private int paymentType;
	private int addressId;
	public OrdersVO() {
	}

	public OrdersVO(int customerId,int productId, String street, String city, String state,
			String country, int zipcode ,int paymentType) {
		this.productId=productId;
		//this.cashOnDelivery=cashOnDelivery;
		this.customerId = customerId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.paymentType=paymentType;
	}

	public OrdersVO(int customerId, int productId, String street, String city,
			String state, String country, int zipcode, String cardType,
			String cardNumber,String cardName,String date,int cvv ,int paymentType) {

		this.customerId = customerId;
		//this.cashOnDelivery=cashOnDelivery;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.productId = productId;
		this.cardType=cardType;
		this.cardNumber=cardNumber;
		this.CardName=cardName;
		this.date=date;
		this.cvv=cvv;
		this.paymentType=paymentType;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardName() {
		return CardName;
	}

	public void setCardName(String cardName) {
		CardName = cardName;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public OrdersVO(String customerId, String productId, String orderStatus) {
		this.customerId = Integer.parseInt(customerId);
		this.productId = Integer.parseInt(productId);
		this.orderStatus = orderStatus;
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

	public boolean isCashOnDelivery() {
		return cashOnDelivery;
	}

	public void setCashOnDelivery(boolean cashOnDelivery) {
		this.cashOnDelivery = cashOnDelivery;
	}

	

}
