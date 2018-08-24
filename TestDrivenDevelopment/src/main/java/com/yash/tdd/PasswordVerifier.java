package com.yash.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PasswordVerifier {

	List<String> errorList = null;

	public Boolean varify(String password) {

		errorList = new ArrayList<>();
		Boolean result;

		if (password != null) {
			errorList = verifyAtleastSingleLowerCase(password);
			errorList = verifyPasswordLength(password);
			errorList = verifyAtleastSingleUpperCase(password);
			errorList = verifyAtleastSingleNumber(password);

		} else {
			throw new RuntimeException("Password should not be null");
		}

		if (errorList.size() < 3) {
			result = true;
		} else {
			throw new RuntimeException(
					"Password is Invalid! Should satisfy atlest one of these conditions: " + errorList);
		}

		return result;
	}

	private List<String> verifyPasswordLength(String password) {

		if (password.length() <= 8) {
			errorList.add("Password should be greater than 8 numbers");
		}

		return errorList;
	}

	private List<String> verifyAtleastSingleLowerCase(String password) {

		Pattern lowerCasePattern = Pattern.compile("[a-z ]");

		if (!lowerCasePattern.matcher(password).find()) {
			throw new RuntimeException("Password should have atleast one lowercase character");
		}

		return errorList;
	}

	private List<String> verifyAtleastSingleUpperCase(String password) {

		Pattern upperCasePattern = Pattern.compile("[A-Z ]");

		if (!upperCasePattern.matcher(password).find()) {
			errorList.add("Password should have atleast one uppercase character");
		}

		return errorList;
	}

	private List<String> verifyAtleastSingleNumber(String password) {

		Pattern numberPattern = Pattern.compile("\\d");

		if (!numberPattern.matcher(password).find()) {
			errorList.add("Password should have atleast one number");
		}

		return errorList;
	}
}
