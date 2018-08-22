package com.yash.tdd;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.tdd.StringCalculator;

@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

	@Mock
	Logger logger;
	
	@InjectMocks
	StringCalculator stringCalculatorInstance; 
	
	//StringCalculator stringCalculator = new StringCalculator();
	
	@Test
	public void shouldReturnZeroWhenInputisEmpty() {
		
		int actual = stringCalculatorInstance.add("");
		
		Assert.assertEquals(0, actual);
	}
	
	@Test
	public void shouldReturnSingleIntegerWhenInputIsSingleNumber(){

		int actual = stringCalculatorInstance.add("-1");
		
		Assert.assertEquals(-1, actual);
	}
	
	@Test
	public void shouldReturnSumOfTwoIntegersWhenInputIsTwoNumbersSeperatedByComma(){

		int actual = stringCalculatorInstance.add("1,2");
		
		Assert.assertEquals(3, actual);
	}
	
	@Test
	public void shouldReturnSumOfIntegersWhenInputIsMoreThanTwoNumbersSeperatedByComma(){

		int actual = stringCalculatorInstance.add("1,-2,3,4");
		
		Assert.assertEquals(6, actual);
	}
	
	@Test
	public void shouldReturnSumOfIntegersWhenInputIsSeperatedByCommaAndNewLine(){

		int actual = stringCalculatorInstance.add("2\n2\n3,4");
		
		Assert.assertEquals(11, actual);
	}
	
	
	@Test
	public void shouldReturnSumOfIntegersWhenInputSpecifiesSupportedDelimiterByUsingDoubleSlash(){

		int actual = stringCalculatorInstance.add("//'\n1'5'98'45");
		
		Assert.assertEquals(149, actual);
	}
	
	@Test
	public void shouldReturnSumOfIntegersAndSkipNumbersGreaterThanOneThousand(){

		int actual = stringCalculatorInstance.add("//'\n1'1005'8'45");
		
		Assert.assertEquals(54, actual);
	}
	
	@Test
	public void shouldLogTheSum(){
		Mockito.doNothing().when(logger).info("3");
		int actual = stringCalculatorInstance.add("1,2");
		verify(logger).info("3");
	}
	

}
