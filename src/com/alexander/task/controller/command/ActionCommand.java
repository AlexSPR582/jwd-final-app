package com.alexander.task.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
