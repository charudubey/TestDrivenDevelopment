package com.yash.tdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {

	public Map<String,Long> getUnique(String input) {
		
		List<String> inputList = Arrays.asList(input.split(" "));
		Map<String, Long> output = new HashMap<>();
		
		output =  inputList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		return output;
	}

}
