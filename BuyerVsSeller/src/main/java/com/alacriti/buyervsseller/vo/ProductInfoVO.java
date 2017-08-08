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

	public ProductInfoVO(int productId, String productName, int categoryId,
			int price, String productDescription) {
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.productDescription = productDescription;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
