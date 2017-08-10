package com.alacriti.buyervsseller.vo;

public class ProductVO {

	private int Category_id;
	private String Category_name;
	private String image;

	public ProductVO() {

	}

	public ProductVO(int productId, String productName) {
		this.Category_id = productId;
		this.Category_name = productName;
	}

	public ProductVO(int productId, String productName, String image) {
		this.Category_id = productId;
		this.Category_name = productName;
		this.image = image;
	}

	public ProductVO(String productName) {
		this.Category_name = productName;
	}
	public ProductVO(int productId) {
		this.Category_id = productId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProductId() {
		return Category_id;
	}

	public void setProductId(int productId) {
		this.Category_id = productId;
	}

	public String getProductName() {
		return Category_name;
	}

	public void setProductName(String productName) {
		this.Category_name = productName;
	}
}
