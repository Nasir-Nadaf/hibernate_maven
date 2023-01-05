package com.comtroller.entity;

import com.controller.ProductController;

public class ProductUtility {
public static Product scan() {
	System.out.println("enter product id");
	int productid =ProductController.scanner.nextInt();
	
	System.out.println("enter product name");
	String productname =ProductController.scanner.next();
	
	System.out.println("enter product price");
	int productprice =ProductController.scanner.nextInt();
	
	System.out.println("enter product mfg date");
	String productmfg =ProductController.scanner.next();
	
	System.out.println("enter product category");
	String category =ProductController.scanner.next();
	
	Product product=new Product(productid, productname, productprice, productmfg,category);
	
	return product;	
}
public static int delete() {
	System.out.println("enter product id to delete product");
	int id=ProductController.scanner.nextInt();
	return id;
	
}
public static int get() {
	System.out.println("enter product id to get detail product");
	int id=ProductController.scanner.nextInt();
	return id;
	
}
//public static Product updatescan() {
//	System.out.println("enter data to update");
//	System.out.println("enter product id");
//	int productid =ProductController.scanner.nextInt();
//	
//	System.out.println("enter product name");
//	String productname =ProductController.scanner.next();
//	
//	System.out.println("enter product price");
//	int productprice =ProductController.scanner.nextInt();
//	
//	System.out.println("enter product mfg date");
//	String productmfg =ProductController.scanner.next();
//	
//	Product product=new Product(productid, productname, productprice, productmfg);
//	
//	
//	return product;	
//}
}
