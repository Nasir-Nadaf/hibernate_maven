package com.comtroller.service;

import java.security.Provider.Service;
import java.util.List;

import com.comtroller.dao.ProductDao;
import com.comtroller.entity.Product;
import com.controller.CustEcxeptions.ProductNotfoundEcxeption;

public class ProductService {
	ProductDao dao=new ProductDao();
	public String saveProduct(Product product) {
		String msg=dao.saveProduct(product); 
		return msg;
		
	}
	public String deleteProduct(int id) {
		String msg=dao.deleteProduct(id);
		return msg;
	}
	public Product getproductByid(int id) throws ProductNotfoundEcxeption {
		Product product=dao.getproductByid(id);
		return product;
	}
	public String updateProduct(Product product) {
		String msg=dao.updateProduct(product);
		return msg;
	}
	public List<Product> getAllProduct() {
		
		return dao.getAllProduct();
	}
	public List<Product> getLimitedProduct(int limit) {
		// TODO Auto-generated method stub
		return dao.getLimitedProduct(limit);
	}
	public List<Product> getproductByName(String fetchByName) {
		List<Product> list=dao.getproductByName(fetchByName);
		return list;
	}
	public List<Product> orderList() {
		
		return dao.orderList();
	}
	public List<Product> greaterThan() {
		
		return dao.greaterThan();
	}
	public List<Product> alleqmethod() {
		// TODO Auto-generated method stub
		return dao.alleqmethod();
	}
	public List<Product> andOr() {
		// TODO Auto-generated method stub
		return dao.andOr();
	}
	public double sumPrice() {
		// TODO Auto-generated method stub
		return dao.sumPrice();
	}
	public List<Product> maxProduct() {
		// TODO Auto-generated method stub
		return dao.maxProduct();
	}
	public long countProduct() {
		// TODO Auto-generated method stub
		return dao.countProduct();
	}
}
