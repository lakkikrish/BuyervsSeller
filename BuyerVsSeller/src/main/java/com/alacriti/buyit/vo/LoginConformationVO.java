package com.alacriti.buyit.vo;

public class LoginConformationVO {
	private boolean check;
	private int customerId;
	private String customerName;
	public LoginConformationVO() {
		
	}
	public LoginConformationVO(boolean check) {
	this.check=check;		
	}
public LoginConformationVO(int customerId,String customerName,boolean check) {
		this.customerId=customerId;
		this.customerName=customerName;
		this.check=check;
	}
	public boolean getCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public int getCustId() {
		return customerId;
	}
	public void setCustId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustName() {
		return customerName;
	}
	public void setCustName(String customerName) {
		this.customerName = customerName;
	}
	

}
