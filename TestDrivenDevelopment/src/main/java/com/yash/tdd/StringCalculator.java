package com.yash.tdd;
import java.util.Arrays;
import java.util.List;
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
			List<String> negatives = Arrays.stream(numberList).filter(n->Integer.valueOf(n)<0).collect(Collectors.toList());
			if(negatives.size()>0)
				throw new RuntimeException("Negatives not allowed! Negative values passed are: " + negatives);
					
			sum = Arrays.stream(numberList).map(s -> Integer.parseInt(s)).filter(n->n<=1000).collect(Collectors.reducing((n1,n2)-> n1+n2)).get();
		} 
		logger.info(sum.toString());
		return sum;
	}


}
