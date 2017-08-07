package com.alacriti.buyervsseller.vo;

public class RegisterVO {
	private String name;
	private String email;
	private String password;
	private int mobileNo;
	

	public RegisterVO() {
		
	}
	public RegisterVO(String name,int mobileNo,String email,String password) {
		this.name=name;
		this.mobileNo=mobileNo;
		this.email=email;
		this.password=password;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMobileno() {
		return mobileNo;
	}
	public void setMobileno(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
