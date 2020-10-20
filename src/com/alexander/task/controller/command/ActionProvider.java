package com.alexander.task.controller.command;

public class ActionProvider {
	private static ActionProvider provider;
	
	private ActionProvider() {}
	
	public static ActionProvider getInstance() {
		if (provider == null) {
			provider = new ActionProvider();
		}
		return provider;
	}
	
	public ActionCommand defineCommand(String command) {
		if (command == null || command.isBlank()) {
            //throw new CommandException("Invalid Command");
        }
        ActionCommand commandType = null;
        try {
            commandType = CommandType.valueOf(command).getCommand();
        } catch (IllegalArgumentException e) {
            //throw new CommandException("No such command", e);
        }
        return commandType;
	}

}
