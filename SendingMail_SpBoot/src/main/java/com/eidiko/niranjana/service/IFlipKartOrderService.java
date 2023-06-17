package com.eidiko.niranjana.service;

public interface IFlipKartOrderService {
	
	public String orderService(String[] items,Double[] prices,String[] emails)throws Exception;

}
