package com.alexander.task.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
	private static final UserValidator instance = new UserValidator();
	
	private static final String EMAIL_REGEX = "";
	private static final String NAME_REGEX = "";
	
	private static final int MIN_PASSWORD_LENGTH = 8;
	private static final int MAX_PASSWORD_LENGTH = 100;
	
	private UserValidator() {}
	
	public static UserValidator getInstance() {
		return instance;
	}
	
	public boolean emailValidation(String email) {
		if (email == null || email.isBlank()) {
			return false;
		}
		boolean isValid = false;
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		if (matcher.find()) {
			isValid = true;
		}
		return isValid;		
	}
	
	public boolean passwordValidation(String password) {
		if (password == null || password.isBlank()) {
			return false;
		}
		return password.length() >= MIN_PASSWORD_LENGTH && 
				password.length() <= MAX_PASSWORD_LENGTH;	
	}
	
	public boolean nameValidation(String name) {
		if (name == null || name.isBlank()) {
			return false;
		}
		boolean isValid = false;
		Pattern pattern = Pattern.compile(NAME_REGEX);
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			isValid = true;
		}
		return isValid;	
	}
}
