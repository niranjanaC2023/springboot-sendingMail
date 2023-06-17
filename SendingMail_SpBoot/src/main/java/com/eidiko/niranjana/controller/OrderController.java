package com.eidiko.niranjana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.niranjana.entity.Product;
import com.eidiko.niranjana.entity.Product2;
import com.eidiko.niranjana.entity.ProductList;
import com.eidiko.niranjana.service.IFlipKartOrderService;
import com.eidiko.niranjana.service.IPurchase;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class OrderController {
	
	@Autowired
	private IPurchase orderServiceCont;
	@Autowired
	private IFlipKartOrderService flpKartOrderServ;
	
	@PostMapping("/orderData") 
	public String orderController( Product product) {
		String data =null;
		try {
			data = orderServiceCont.purchase(product.getItems(),product.getPrice(),product.getEmails()); //data passing using postman form-unlencoded
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		return data;		
	}
	
	@PostMapping("/orderDetails") 
	public String orderControllerDetails(@RequestBody Product product) {
		
		try {
			orderServiceCont.purchase(product.getItems(),product.getPrice(),product.getEmails()); //data passing using  postman Request body
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		return "order sent";		
	}
	
	@PostMapping("/listOfOrder")
	public List<Product> orderControllers(@RequestBody Product product) {
		List<Product> listOfProduct = null;
		try {
			System.out.println("mmmmmmmmm"+orderServiceCont.purchaseList(product.getItems(), product.getPrice(),product.getEmails()));//null
			System.out.println("List of Order Details after: "+listOfProduct);
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		//System.out.println("List of Order Details: "+listOfProduct);
		return listOfProduct;		
	}
	
	@PostMapping("/listOfOrderAs")
	public String orderControllersAs(@RequestBody Product2 product2) {
		String listOfProduct = null;
		try {
			listOfProduct = orderServiceCont.purchageProduct(product2.getItems(),product2.getPrice(),product2.getEmails());
			System.out.println("List of Order Details after: "+listOfProduct);
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		//System.out.println("List of Order Details: "+listOfProduct);
		return listOfProduct;		
	}
	
	
	@PostMapping("/sendOrder")
	public String orderSendController(@RequestBody ProductList productList) {
		String listOfProduct = null;
		try {
			listOfProduct = flpKartOrderServ.orderService(productList.getItems(), productList.getPrices(), productList.getEmails());
		} catch (Exception e) {
			log.info("Problems with order sending");
			e.printStackTrace();
		}
		System.out.println("List of Order Details: "+listOfProduct);
		return listOfProduct;		
	}
	
}
