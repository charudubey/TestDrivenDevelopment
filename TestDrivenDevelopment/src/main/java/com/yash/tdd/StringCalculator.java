package com.yash.tdd;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StringCalculator {
	
	private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public Integer add(String input) {
		Integer sum = 0;

		if (input.length() != 0) {
			String delimiter =",|\\n";
			if(input.startsWith("//")){
				String[] split = input.split("\\n");
				delimiter = split[0].substring(2);
				input = split[1];
			}
			String[] numberList = input.split(delimiter);
			sum = Arrays.stream(numberList).map(s -> Integer.parseInt(s)).filter(n->n<=1000).collect(Collectors.reducing((n1,n2)-> n1+n2)).get();
		} 
		logger.info(sum.toString());
		return sum;
	}

}
