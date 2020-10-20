package com.alexander.task.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alexander.task.controller.command.ActionCommand;
import com.alexander.task.controller.command.ActionProvider;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
    public Controller() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ActionProvider provider = ActionProvider.getInstance();
		ActionCommand command = provider.defineCommand(request.getParameter("command"));
		command.execute(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}
