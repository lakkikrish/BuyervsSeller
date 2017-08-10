package com.alacriti.buyervsseller.vo;

public class ProductInfoVO {
	private int productId;
	private String productName;
	private int categoryId;
	private String productDescription;
	private int price;
	private String image;
	private int rating;
	private String comments;

	public ProductInfoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductInfoVO(int productId, String productName, int categoryId,
			int price, String productDescription, String image) {
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.productDescription = productDescription;
		this.price = price;
		this.image = image;

	}

	public ProductInfoVO(int productId, String productName, int price,
			String image) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.image = image;

	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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
