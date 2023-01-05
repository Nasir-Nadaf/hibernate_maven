package com.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.comtroller.entity.Product;
import com.comtroller.entity.ProductUtility;
import com.comtroller.service.ProductService;
import com.controller.CustEcxeptions.ProductNotfoundEcxeption;

public class ProductController {
	public static Scanner scanner=new Scanner(System.in);
	
public static void main(String[] args)  {
	ProductService service=new ProductService();
	
	char repeate;
	do {
		System.out.println("***************************session********************************");
		System.out.println("to save product press 1");
		System.out.println("to delete product press 2");
		System.out.println("to update product press 3");
		System.out.println("to get product press 4");
		System.out.println("************************criteria********************************");
		System.out.println("to get all product press 5");
		System.out.println("to get paginate product list press 6");
		System.out.println("to get order list by price press 9");
		System.out.println("*********************restrictions*******************************");
		System.out.println("to get product by name press 7 ");
		System.out.println("to get product price is greterthan 500 press 8");
		System.out.println("to get product by restriction alleq method 10");
		System.out.println("to get product by restrictions and,or method 11");
		System.out.println("**********************Projection********************************");
		System.out.println("get sum of all product price 12");
		System.out.println("get max price product 13");//combination of projection and restriction
		System.out.println("get count of product 14");
		
		
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:{
			System.out.println("manual"); 
			Product product1=ProductUtility.scan();
			String msg=service.saveProduct(product1);
			System.out.println(msg);
			break;}
		case 2:{
			int id=ProductUtility.delete();
			String msg1=service.deleteProduct(id);
			System.out.println(msg1);
			break;}
			
		case 3:{
			System.out.println("enter product details");
			Product product2=ProductUtility.scan();
			String msg2=service.updateProduct(product2);
			System.out.println(msg2);
			break;}
		case 4:{
			int id1=ProductUtility.get();
			Product product=null;
			try {
				product = service.getproductByid(id1);
			} catch (ProductNotfoundEcxeption e) {
				// TODO Auto-generated catch block
				System.out.println(e.errormsg);
			}
			System.out.println(product);
			break;}
		case 5:{
			List<Product> list=service.getAllProduct();
			if(!list.isEmpty()) {
				for (Product product3 : list) {
					System.out.println(product3);		
				}
			}
			break;}
		case 6:{
			System.out.println("enter how many record you want to see from first record");
			int limit=scanner.nextInt();
			List<Product> list1=service.getLimitedProduct(limit);
			if(!list1.isEmpty()) {
				for (Product product3 : list1) {
					System.out.println(product3);		
				}
			}
			break;}
		case 7:{
			System.out.println("enter product name to get product record");
			String fetchByName=scanner.next();
			List<Product> list2= service.getproductByName(fetchByName);
			if(!list2.isEmpty()) {
				for (Product product3 : list2) {
					System.out.println(product3);		
				}
			}
			break;}
			
		case 8:{
			List<Product> list5 =service.greaterThan();
			if(!list5.isEmpty()) {
				for (Product product3 : list5) {
					System.out.println(product3);
				}
			}
			break;}
		case 9:{
			List<Product> list4=service.orderList();
			if(!list4.isEmpty()) {
			for (Product product3 : list4) {
				System.out.println(product3);
			}
			}
			break;}
		case 10:{
			List<Product> list=service.alleqmethod();
			if(!list.isEmpty()) {
				for (Product product2 : list) {
					System.out.println(product2);
				}
			}
			break;
		}
		case 11:{
			List<Product> list=service.andOr();
			if(!list.isEmpty()) {
				for (Product product2 : list) {
					System.out.println(product2);
				}
			}
			break;
		}
		
		case 12:{
			double sum=service.sumPrice();
			System.out.println(sum);
			break;
		}
		case 13:{
			List<Product> list=service.maxProduct();
			for (Product product : list) {
				System.out.println(product);
			}
		}
		case 14:{
			long count=service.countProduct();
			System.out.println("total products are "+count);
			break;
		}
			
		default:{
			System.out.println("invalide choice...");
			break;}
		}
		
		System.out.println("for continue type y/n");
		repeate=scanner.next().charAt(0);
	} while (repeate=='y'||repeate=='Y');
}
}
