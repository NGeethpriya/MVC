package com.order.JavaBeans;

public class ProductBean {
	private String productId;
	private String productName;
	private String purchaseDate;
	private float price;

	public ProductBean(String productId, String productName, String purchaseDate, float price) {
		this.productId = productId;
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public float getPrice() {
		return price;
	}
}
