package com.eidiko.niranjana.service;

import java.util.List;

import com.eidiko.niranjana.entity.Product;

public interface IPurchase {
	
	 public  String  purchase(String[] items, double[] price,String[] emails)throws Exception;
	   
	   public  String purchases(String []items, double[] prices,String[] emails)throws Exception;
	   
	   public  List<Product>  purchaseList(String []items, double[] prices,String[] emails)throws Exception;
	   
	   
	   public String purchageProduct(String items, double price, String emails)throws Exception ;
		

}
