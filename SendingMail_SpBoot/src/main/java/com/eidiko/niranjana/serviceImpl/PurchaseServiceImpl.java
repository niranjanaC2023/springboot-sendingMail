package com.eidiko.niranjana.serviceImpl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.eidiko.niranjana.entity.Product;
import com.eidiko.niranjana.service.IPurchase;

import jakarta.mail.internet.MimeMessage;
@Service
public class PurchaseServiceImpl implements IPurchase{
	
	@Autowired
	private  JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private  String fromEmail;

	private String sendMail(String msg, String[] toEmails)throws Exception {
		MimeMessage message=sender.createMimeMessage();	 //empty email message
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Order Details");
		helper.setSentDate(new Date());
		helper.setText(msg);
		//helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));  //place nit.jpg file src/main/resource folder
		helper.addAttachment("Demo.pdf", new ClassPathResource("Demo.pdf"));
		sender.send(message);
		System.out.println("Mail Send Successfully...........");
		return "Mail Sent";
	}
	
	@Override
	public String purchase(String[] items, double[] prices, String[] toEmails)throws Exception {
	     //calculate the  bill amount
		double billAmt=0.0;
		  for(double p:prices) 
		  {
			  billAmt=billAmt+p;
		  }
		  String msg=Arrays.toString(items)+" with prices"+Arrays.toString(prices)+" are purchsed with Bill Amount "+billAmt;
		  //send mail
		  String status=sendMail(msg, toEmails);
		return msg+"---->"+status;
	}
	
	
//=======================================================================================================================
	
	@Override
	public String purchases(String[] items, double[] prices, String[] emails) throws Exception {
		 //calculate the  bill amount
		double billAmt=0.0;
		  for(double p:prices) 
		  {
			  billAmt=billAmt+p;
		  }
		  String msg=Arrays.toString(items)+" with prices"+Arrays.toString(prices)+" are purchsed with Bill Amount "+billAmt;
		  //send mail
		  String status=sendMail(msg, emails);
		return msg+"---->"+status;
	}
//=====================================================================================================
	@Override
	public List<Product> purchaseList(String[] items, double[] prices, String[] emails) throws Exception {
		List<Product> listProductt = null;
		//calculate the  bill amount
				double billAmt=0.0;
				  for(double p:prices) 
				  {
					  billAmt=billAmt+p;
				  }
				  String msg=Arrays.toString(items)+" with prices"+Arrays.toString(prices)+" are purchsed with Bill Amount "+billAmt;
				  //send mail
				  listProductt=sendMails(msg, emails);
				return listProductt;
	}
	
	private List<Product>  sendMails(String msg, String[] toEmails)throws Exception {
		List<Product> listProductt = null;
		MimeMessage message=sender.createMimeMessage();	 //empty email message
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Order Details");
		helper.setSentDate(new Date());
		helper.setText(msg);
		//helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));  //place nit.jpg file src/main/resource folder
		helper.addAttachment("Demo.pdf", new ClassPathResource("Demo.pdf"));
		sender.send(message);
		System.out.println("Mail Send Successfully...........");
		return listProductt;
	}
//===============================================================
	private String sendMailing(String msg, String toEmails)throws Exception {
		MimeMessage message=sender.createMimeMessage();	 //empty email message
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		helper.setFrom(fromEmail);
		helper.setCc(toEmails);
		helper.setSubject("Order Details");
		helper.setSentDate(new Date());
		helper.setText(msg);
		//helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));  //place nit.jpg file src/main/resource folder
		helper.addAttachment("Demo.pdf", new ClassPathResource("Demo.pdf"));
		sender.send(message);
		System.out.println("Mail Send Successfully...........");
		return "Mail Sent";
	}
	@Override
	public String purchageProduct(String items, double price, String emails) throws Exception {
		 //calculate the  bill amount
		double billAmt=0.0;
		 double p=price;
		 
			  billAmt=billAmt+p;
		  
		  String msg="Items "+items+" with prices"+"prices "+price+" are purchsed with Bill Amount "+billAmt;
		  //send mail
		  String status=sendMailing(msg, emails);
		return msg+"---->"+status;
	}

}
