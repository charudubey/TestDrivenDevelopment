package com.yash.tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.sun.javafx.collections.MappingChange.Map;
import com.yash.tdd.WordCounter;

public class WordCounterTest {

	WordCounter wordCounter = new WordCounter();
	
	@Test
	public void shouldReturnCollectionOfUniqueWordsWhenStringContainsSpaceAsDelimiter() {
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		
		HashMap<String,Integer> actual = wordCounter.getUnique("boom bang boom");
		expected.put("boom", 2);
		expected.put("bang", 1);

		assertEquals(expected, actual);
	}
	
	/*@Test
	public void shouldReturnCollectionOfUniqueWordsWhenStringContainsCommaAsDelimiter() {
		HashMap<String,Integer> expected = new HashMap<String,Integer>();
		
		HashMap<String,Integer> actual = wordCounter.getUnique("boom, bang, boom");
		expected.put("boom", 2);
		expected.put("bang", 1);

		assertEquals(expected, actual);
	}*/

}
