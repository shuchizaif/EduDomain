package com.qa.opencart.pojo;

public class ProductPOJO {

	private String searchKey;
	private String productName;
	private int productImages;
	public ProductPOJO(String searchKey, String productName, int productImages) {
		
		this.searchKey = searchKey;
		this.productName = productName;
		this.productImages = productImages;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductImages() {
		return productImages;
	}
	public void setProductImages(int productImages) {
		this.productImages = productImages;
	}
	@Override//this method will covert memory address of product into String . It is overridden from Object class
	public String toString() {
		return "ProductPOJO [searchKey=" + searchKey + ", productName=" + productName + ", productImages="
				+ productImages + "]";
	}
	
	
	
	
}
