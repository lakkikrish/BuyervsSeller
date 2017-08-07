package com.alacriti.buyervsseller.vo;

public class ProductVO {

	private int Category_id;
	private String Category_name;
	public ProductVO() {
		
	}
	public ProductVO(int productId,String productName) {
		this.Category_id=productId;
		this.Category_name=productName;
	}
	public ProductVO(String productName){
		this.Category_name=productName;
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
