package com.alexander.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alexander.task.controller.command.ActionCommand;
import com.alexander.task.entity.User;
import com.alexander.task.exception.ServiceException;
import com.alexander.task.service.ServiceFactory;
import com.alexander.task.service.UserService;
import com.alexander.task.service.impl.UserServiceImpl;

public class AuthorizationCommand implements ActionCommand {
	private static final String ID = "id";
	private static final String FIRST_NAME = "fname";
	private static final String LAST_NAME = "lname";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String ERROR_MESSAGE = "error_message";
	
	private static final String WELCOME_PAGE_URL = "/WelcomePage.html";
	private static final String USER_PAGE_URL = "/UserPage.jsp";
	private static final String ERROR_PAGE_URL = "/ErrorPage.jsp";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService service = factory.getUserService();
		
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		
		ServletContext servletContext = request.getServletContext();
        RequestDispatcher requestDispatcher;
		
		User user;
		
		try {
			user = service.authorization(email, password);
			if (user != null) {
				session.setAttribute(ID, user.getId());
				
				request.setAttribute(FIRST_NAME, user.getFirstName());
				request.setAttribute(LAST_NAME, user.getSecondName());
				requestDispatcher = servletContext.getRequestDispatcher(USER_PAGE_URL);
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = servletContext.getRequestDispatcher(WELCOME_PAGE_URL);
				requestDispatcher.forward(request, response);
			}
		} catch (ServiceException e1) {
			requestDispatcher = servletContext.getRequestDispatcher(ERROR_PAGE_URL);
			try {
				request.setAttribute(ERROR_MESSAGE, "Sorry, something go wrong");
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				//logging
			} catch (IOException e) {
				//logging
			}
		} catch (ServletException e) {
			//logging
		} catch (IOException e) {
			//logging
		}	
	}
}
