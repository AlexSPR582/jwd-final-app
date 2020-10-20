package com.alexander.task.controller.command;

import com.alexander.task.controller.command.impl.RegistrationCommand;
import com.alexander.task.controller.command.impl.AuthorizationCommand;

public enum CommandType {
	REGISTRATION (new RegistrationCommand()),
	SIGN_IN (new AuthorizationCommand());	
	
	private ActionCommand command;
	
	private CommandType(ActionCommand command) {
		this.command = command;
	}
	
	public ActionCommand getCommand() {
		return command;
	}
}
