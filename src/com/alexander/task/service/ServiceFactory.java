package com.alexander.task.service;

import com.alexander.task.service.impl.HotelSerivceImpl;
import com.alexander.task.service.impl.UserServiceImpl;

public class ServiceFactory {
	private final static ServiceFactory instance = new ServiceFactory();
	
	private ServiceFactory() {
		
	}
	
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	public UserService getUserService() {
		return new UserServiceImpl();
	}
	
	public HotelService getHotelService() {
		return new HotelSerivceImpl();
	}
}
