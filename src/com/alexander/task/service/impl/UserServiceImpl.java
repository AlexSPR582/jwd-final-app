package com.alexander.task.service.impl;

import com.alexander.task.dao.UserDao;
import com.alexander.task.entity.User;
import com.alexander.task.exception.DaoException;
import com.alexander.task.exception.ServiceException;
import com.alexander.task.dao.DaoFactory;
import com.alexander.task.service.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public boolean registration(String firstName, String lastName, String email, String password) 
			throws ServiceException {		
		int hashPassword = password.hashCode();		
		boolean isAdded = false;
		DaoFactory factory = DaoFactory.getInstance();
		UserDao dao = factory.getUserDao();
		try {
			isAdded = dao.addUser(firstName, lastName, email, hashPassword);			
		} catch (DaoException e) {
			throw new ServiceException("service exception", e);
		}
		return isAdded;
	}

	@Override
	public User authorization(String email, String password) throws ServiceException { 
		int hashPassword = password.hashCode();	
		User user = null;
		
		DaoFactory factory = DaoFactory.getInstance();
		UserDao dao = factory.getUserDao();
		try {
			user = dao.findUserByEmailPassword(email, hashPassword);
		} catch (DaoException e) {
			throw new ServiceException("service exception", e);
		}
		return user;
	}
}
