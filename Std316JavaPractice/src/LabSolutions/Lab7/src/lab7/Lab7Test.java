package lab7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

/**
 * JUnit 5 Test class for Lab7
 * Tests are ordered by method name (test01, test02, test03, etc.)
 * 
 * @author Sukhwant Sagar
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class Lab7Test {

	// ========== Tests for findCommonElements() ==========
	
	@Test
	public void test01_findCommonElements_basicCase() {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 5));
		ArrayList<Integer> result = Lab7.findCommonElements(list1, list2);
		
		assertEquals(expected, result, "Should find common elements [3, 4, 5]");
	}
	
	@Test
	public void test02_findCommonElements_noCommon() {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(10, 20, 30));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(40, 50, 60));
		ArrayList<Integer> expected = new ArrayList<>();
		ArrayList<Integer> result = Lab7.findCommonElements(list1, list2);
		
		assertEquals(expected, result, "Should return empty list when no common elements");
	}
	
	@Test
	public void test03_findCommonElements_withDuplicates() {
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 2, 3, 3));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3));
		ArrayList<Integer> result = Lab7.findCommonElements(list1, list2);
		
		assertEquals(expected, result, "Should return [2, 3] without duplicates");
	}
	
	// ========== Tests for removeDuplicates() ==========
	
	@Test
	public void test06_removeDuplicates_basicCase() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana"));
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
		ArrayList<String> result = Lab7.removeDuplicates(list);
		
		assertEquals(expected, result, "Should remove duplicates preserving first occurrence");
	}
	
	@Test
	public void test07_removeDuplicates_noDuplicates() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
		ArrayList<String> result = Lab7.removeDuplicates(list);
		
		assertEquals(expected, result, "Should return same list when no duplicates");
	}
	
	@Test
	public void test08_removeDuplicates_caseSensitive() {
		ArrayList<String> list = new ArrayList<>(Arrays.asList("test", "Test", "TEST"));
		ArrayList<String> expected = new ArrayList<>(Arrays.asList("test", "Test", "TEST"));
		ArrayList<String> result = Lab7.removeDuplicates(list);
		
		assertEquals(expected, result, "Should be case-sensitive");
	}
	
	// ========== Tests for rotateLeft() ==========
	
	@Test
	public void test11_rotateLeft_basicCase() {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2));
		ArrayList<Integer> result = Lab7.rotateLeft(list, 2);
		
		assertEquals(expected, result, "Should rotate left by 2 positions");
		assertSame(list, result, "Should return the same list reference");
	}
	
	@Test
	public void test12_rotateLeft_singleRotation() {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(20, 30, 10));
		ArrayList<Integer> result = Lab7.rotateLeft(list, 1);
		
		assertEquals(expected, result, "Should rotate left by 1 position");
	}
	
	@Test
	public void test13_rotateLeft_wrapAround() {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4, 1));
		ArrayList<Integer> result = Lab7.rotateLeft(list, 5);
		
		assertEquals(expected, result, "Should wrap around when k > size");
	}
	
	// ========== Tests for findMostFrequent() ==========
	
	@Test
	public void test17_findMostFrequent_basicCase() {
		int[] arr = {1, 2, 2, 3, 3, 3, 4};
		int expected = 3;
		int result = Lab7.findMostFrequent(arr);
		
		assertEquals(expected, result, "Should return 3 as it appears most frequently");
	}
	
	@Test
	public void test18_findMostFrequent_firstOccurrenceOnTie() {
		int[] arr = {5, 5, 10, 10, 15};
		int expected = 5;
		int result = Lab7.findMostFrequent(arr);
		
		assertEquals(expected, result, "Should return first occurrence when frequencies are equal");
	}
	
	@Test
	public void test19_findMostFrequent_singleElement() {
		int[] arr = {7};
		int expected = 7;
		int result = Lab7.findMostFrequent(arr);
		
		assertEquals(expected, result, "Should return the only element");
	}
		
	// ========== Tests for groupByLength() ==========
	
	@Test
	public void test23_groupByLength_basicCase() {
		String[] words = {"cat", "dog", "bird", "fish"};
		HashMap<Integer, ArrayList<String>> result = Lab7.groupByLength(words);
		
		assertEquals(2, result.size(), "Should have 2 different lengths");
		assertTrue(result.containsKey(3), "Should have key 3");
		assertTrue(result.containsKey(4), "Should have key 4");
		assertEquals(Arrays.asList("cat", "dog"), result.get(3), "Length 3 should have [cat, dog]");
		assertEquals(Arrays.asList("bird", "fish"), result.get(4), "Length 4 should have [bird, fish]");
	}
	
	@Test
	public void test24_groupByLength_variousLengths() {
		String[] words = {"a", "is", "the", "and"};
		HashMap<Integer, ArrayList<String>> result = Lab7.groupByLength(words);
		
		assertEquals(3, result.size(), "Should have 3 different lengths");
		assertEquals(Arrays.asList("a"), result.get(1), "Length 1 should have [a]");
		assertEquals(Arrays.asList("is"), result.get(2), "Length 2 should have [is]");
		assertEquals(Arrays.asList("the", "and"), result.get(3), "Length 3 should have [the, and]");
	}
	
	// ========== Tests for areAnagrams() ==========
	
	@Test
	public void test28_areAnagrams_basicCase() {
		boolean result = Lab7.areAnagrams("listen", "silent");
		assertTrue(result, "listen and silent should be anagrams");
	}
	
	@Test
	public void test29_areAnagrams_caseInsensitive() {
		boolean result = Lab7.areAnagrams("Hello", "hello");
		assertTrue(result, "Should be case-insensitive");
	}
	
	@Test
	public void test30_areAnagrams_withSpaces() {
		boolean result = Lab7.areAnagrams("a gentleman", "elegant man");
		assertTrue(result, "Should ignore spaces");
	}
	
	@Test
	public void test31_areAnagrams_notAnagrams() {
		boolean result = Lab7.areAnagrams("hello", "world");
		assertFalse(result, "hello and world should not be anagrams");
	}	
	
}