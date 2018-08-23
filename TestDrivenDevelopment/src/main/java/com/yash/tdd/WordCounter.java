package com.yash.tdd;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.javafx.collections.MappingChange.Map;

public class WordCounter {

	public HashMap<String,Integer> getUnique(String input) {
		
		/*List<String> wordList = Arrays.asList(input.split(" "));
		
		wordList.stream().filter(i -> Collections.frequency(wordList, i) >1)
        	.collect(Collectors.toMap(i, Collections.frequency(wordList, i)));*/
		
		HashMap<String, Integer> output = new HashMap<>();
		
		for(String word: input.split(" ")){
			if(output.containsKey(word))
				output.put(word, output.get(word)+1);
			else
				output.put(word, 1);
		}
		
		return output;
	}

}
