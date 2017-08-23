package com.alacriti.buyit.vo;

public class CommentVO {
	private String comment;
	private int customerId;
	private String customerName;

	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommentVO(String comment,int customerId,String customerName) {
		this.comment=comment;
		this.customerId=customerId;
		this.customerName=customerName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}
