package com.eidiko.niranjana;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendingMailSpBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendingMailSpBootApplication.class, args);
		/*
		//get IOC container
				ApplicationContext ctx=SpringApplication.run(SendingMailSpBootApplication.class, args);
				// get Serivce class object ref
				IPurchaseOrder order=ctx.getBean("purchaseService",IPurchaseOrder.class);
				//invoke method
				try {
				String msg=order.purchase(new String[] {"shirt","trouser","watch"},
		                                           new double[] {5000,6000,7000},
		                                           new String[] {"chartyniranjana2016@gmail.com","premchand9704@gmail.com"});
				System.out.println(msg);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				//close container
				((ConfigurableApplicationContext) ctx).close();
				*/
	}

}
