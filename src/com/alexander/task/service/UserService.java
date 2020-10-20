package com.alexander.task.service;

import com.alexander.task.entity.User;
import com.alexander.task.exception.ServiceException;

public interface UserService {
	public boolean registration(String firstName, String secondName, String email, String password) 
			throws ServiceException;
	public User authorization(String email, String password) throws ServiceException;
}
