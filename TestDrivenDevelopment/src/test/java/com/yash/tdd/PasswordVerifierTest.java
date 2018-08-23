package com.yash.tdd;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordVerifierTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	PasswordVerifier passwordVerifier = new PasswordVerifier();
	
	@Test
	@Ignore
	public void shouldReturnFalseWhenPasswordIsNotLargerThan8Characters() {
		
		Boolean actual = passwordVerifier.varify("PASS");
		
		assertFalse(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordIsLargerThan8Characters() {
		
		Boolean actual = passwordVerifier.varify("yashtechnologies");
		
		assertTrue(actual);
	}
	
	@Test
	public void shouldThrowExceptionWhenPasswordIsNull() {
		
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password should not be null");
		Boolean actual = passwordVerifier.varify(null);
	}
	
	@Test
	@Ignore
	public void shouldReturnFalseWhenPasswordDoesNotHaveAtleastOneLowerCase() {
		
		Boolean actual = passwordVerifier.varify("YASHTECHNO");
		
		assertFalse(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordHasAtleastOneLowerCase() {
		
		Boolean actual = passwordVerifier.varify("yashtechnologies");
		
		assertTrue(actual);
	}
	
	@Test
	@Ignore
	public void shouldReturnFalseWhenPasswordDoesNotHaveAtleastOneUpperCase() {
		
		Boolean actual = passwordVerifier.varify("yashtech");
		
		assertFalse(actual);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordHasAtleastOneUpperCase() {
		
		Boolean actual = passwordVerifier.varify("YashTechno");
		
		assertTrue(actual);
	}
	
	@Test
	@Ignore
	public void shouldReturnFalseWhenPasswordDoesNotHaveAtleastOneNumber() {
		
		Boolean actual = passwordVerifier.varify("YASHTECH");
		
		assertFalse(actual);
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
		
		expectedEx.expect(RuntimeException.class);
		//expectedEx.expectMessage("Conditions not satisfied are: ");
		
		Boolean actual = passwordVerifier.varify("yash");
	}
	
	
	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotSatisfyAtlestThreeConditions() {
		
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Conditions not satisfied are: ");
		
		Boolean actual = passwordVerifier.varify("YASH");
		
	}
	

}
