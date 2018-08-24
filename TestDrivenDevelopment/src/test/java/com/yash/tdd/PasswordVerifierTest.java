package com.yash.tdd;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordVerifierTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	PasswordVerifier passwordVerifier = new PasswordVerifier();
	
	@Test
	public void shouldReturnTrueWhenPasswordIsLargerThan8Characters() {
		
		Boolean actual = passwordVerifier.varify("yashtechnologies");
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldThrowExceptionWhenPasswordIsNull() {
		
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password should not be null");
		passwordVerifier.varify(null);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordHasAtleastOneLowerCaseCharacter() {
		
		Boolean actual = passwordVerifier.varify("yashtechnologies");
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordHasAtleastOneUpperCase() {
		
		Boolean actual = passwordVerifier.varify("YashTechno");
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordHasAtleastOneNumber() {
		
		Boolean actual = passwordVerifier.varify("YashTechnologies1");
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordFulfillsAtleast3Conditions() {
		
		Boolean actual = passwordVerifier.varify("YashTech");
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotFulfillAtleast3Conditions() {
		List<String> expected = new ArrayList<String>();
		expected.add("Password should be greater than 8 numbers");
		expected.add("Password should have atleast one uppercase character");
		expected.add("Password should have atleast one number");
		
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is Invalid! Should satisfy atlest one of these conditions: " + expected);
		
		passwordVerifier.varify("yash");
	}
	
	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase() {
		
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password should have atleast one lowercase character");
		
		passwordVerifier.varify("YASH12345");
	}
	
	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotSatisfyAtlestThreeConditions() {
		List<String> expected = new ArrayList<String>();
		expected.add("Password should be greater than 8 numbers");
		expected.add("Password should have atleast one uppercase character");
		expected.add("Password should have atleast one number");
		
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is Invalid! Should satisfy atlest one of these conditions: " + expected);
		
		passwordVerifier.varify("yash");
		
	}
	

}
