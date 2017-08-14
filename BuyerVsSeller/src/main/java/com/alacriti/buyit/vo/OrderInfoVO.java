package com.alacriti.buyit.vo;

public class OrderInfoVO {
	
	private int customerId;
	private int productId;
	private String orderStatus;
	private String cardNumber;
	private String cardType;
	private String CardName;
	private String date;
	private int cvv;
	
	public OrderInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderInfoVO(int customerId, int productId, String orderStatus,String cardType,
			String cardNumber,String cardName,String date,int cvv ) {
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.productId = productId;
		
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	

}
