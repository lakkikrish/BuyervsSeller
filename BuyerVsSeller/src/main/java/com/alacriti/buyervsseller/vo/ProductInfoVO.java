package com.alacriti.buyervsseller.vo;

public class ProductInfoVO {
	private int productId;
	private String productName;
	private int categoryId;
	private String productDescription;
	private int price;

	public ProductInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductInfoVO(int productId,String productName,int categoryId,int price, String productDescription) {
		this.productId=productId;
		this.productName=productName;
		this.categoryId=categoryId;
		this.productDescription=productDescription;
		this.price=price;
	}

}
