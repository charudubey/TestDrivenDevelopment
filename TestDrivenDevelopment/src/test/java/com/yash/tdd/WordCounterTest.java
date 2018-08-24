package com.yash.tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yash.tdd.WordCounter;

public class WordCounterTest {

	WordCounter wordCounter = new WordCounter();
	
	@Test
	public void shouldReturnCollectionOfUniqueWordsWhenStringContainsSpaceAsDelimiter() {
		Map<String,Long> expected = new HashMap<String,Long>();
		
		Map<String,Long> actual = wordCounter.getUnique("boom bang boom");
		expected.put("boom", 2L);
		expected.put("bang", 1L);

		assertEquals(expected, actual);
	}
	
}
