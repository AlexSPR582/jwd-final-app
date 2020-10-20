package com.alexander.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alexander.task.controller.command.ActionCommand;
import com.alexander.task.exception.ServiceException;
import com.alexander.task.service.UserService;
import com.alexander.task.service.impl.UserServiceImpl;

public class RegistrationCommand implements ActionCommand {
	private static final String FIRST_NAME = "fname";
	private static final String LAST_NAME = "lname";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	private static final String WELCOME_PAGE_URL = "/WelcomePage.html";
	private static final String ERROR_PAGE_URL = "/ErrorPage.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		UserService service = new UserServiceImpl();
		String firstName = request.getParameter(FIRST_NAME);
		String lastName = request.getParameter(LAST_NAME);
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		
		ServletContext servletContext = request.getServletContext();
        RequestDispatcher requestDispatcher;
		try {
			if (service.registration(firstName, lastName, email, password)) {
				requestDispatcher = servletContext.getRequestDispatcher(WELCOME_PAGE_URL);
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = servletContext.getRequestDispatcher(ERROR_PAGE_URL);
				requestDispatcher.forward(request, response);
			}
		} catch (ServiceException e) {
			//logging
		} catch (ServletException e) {
			//logging
		} catch (IOException e) {
			//logging
		}	
	}
}
