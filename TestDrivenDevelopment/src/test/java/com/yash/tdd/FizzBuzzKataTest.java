package com.yash.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzKataTest {

	FizzBuzzKata fizzBuzzKata = new FizzBuzzKata();
	
	@Test
	public void shouldReturnFizzIfNumberIsDivisibleByThree() {
	
		String actual = fizzBuzzKata.divide(9);
		
		assertEquals("Fizz", actual);
	}
	
	@Test
	public void shouldReturnBuzzIfNumberIsDivisibleByFive() {
	
		String actual = fizzBuzzKata.divide(25);
		
		assertEquals("Buzz", actual);
	}
	
	@Test
	public void shouldReturnFizzBuzzIfNumberIsDivisibleByThreeAndFive() {
	
		String actual = fizzBuzzKata.divide(15);
		
		assertEquals("FizzBuzz", actual);
	}
	
	@Test
	public void shouldReturnFizzBuzzIfNumberIsNotDivisibleByThreeOrFive() {
	
		String actual = fizzBuzzKata.divide(14);
		
		assertEquals("14", actual);
	}

}
