package com.alacriti.buyit.vo;

public class ProductsDetailsVO {
	private int productId;
	private String productName;
	private int rating;
	private String comments;
	private int price;
	private int categoryId;
	public ProductsDetailsVO() {
		super();
		
	}
	public ProductsDetailsVO(int productId,String productName,int rating,String comments,int price,int category_Id) {
		this.productId=productId;
		this.productName=productName;
		this.rating=rating;
		this.comments=comments;
		this.price=price;
		this.categoryId=categoryId;
		
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
