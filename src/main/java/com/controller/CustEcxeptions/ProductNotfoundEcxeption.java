package com.controller.CustEcxeptions;

public class ProductNotfoundEcxeption extends Exception {
	public String errormsg;
	public ProductNotfoundEcxeption(String errormsg){
		
		super();
		this.errormsg=errormsg;
	}
}
