package com.alacriti.buyit.vo;

public class RegisterVO {
	private String name;
	private String email;
	private String password;
	private Long mobileNo;
	

	public RegisterVO() {
		
	}
	public RegisterVO(String name,Long mobileNo,String email,String password) {
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
	public Long getMobileno() {
		return mobileNo;
	}
	public void setMobileno(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	

}
