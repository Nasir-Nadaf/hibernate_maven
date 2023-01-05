package com.comtroller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
@Id
@Column(name="id")
private int productId;

@Column(nullable = false)
private String productName;

@Column(nullable = false)
private double productPrice;
private String productmfg;
private String category;

public Product(String category) {
	super();
	this.category = category;
}


public Product(int productId, String productName, double productPrice, String productmfg, String category) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.productPrice = productPrice;
	this.productmfg = productmfg;
	this.category = category;
}


public Product() {
	super();
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
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public String getProductmfg() {
	return productmfg;
}
public void setProductmfg(String productmfg) {
	this.productmfg = productmfg;
}


@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
			+ ", productmfg=" + productmfg + ", category=" + category + "]";
}



}
