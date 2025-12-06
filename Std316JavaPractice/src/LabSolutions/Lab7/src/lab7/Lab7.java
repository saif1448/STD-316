package lab7;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Lab 5: ArrayList and HashMap Operations
 * 
 * This class contains utility methods for working with ArrayList and HashMap
 * data structures in Java.
 * 
 * @author Sukhwant Sagar
 */
public class Lab7 {

	/**
	 * Finds common elements between two ArrayLists of integers.
	 * Returns a new ArrayList containing only the elements that appear in both
	 * input lists. Each common element appears only once in the result, even if
	 * it appears multiple times in either input list. The order of elements is
	 * maintained as they first appear in list1.
	 * 
	 * @param list1 the first ArrayList of integers
	 * @param list2 the second ArrayList of integers
	 * @return a new ArrayList containing common elements without duplicates
	 */
	public static ArrayList<Integer> findCommonElements(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		//Fill in the code here	
		return null;
	}

	/**
	 * Removes duplicate elements from an ArrayList of strings.
	 * Returns a new ArrayList containing only unique elements from the input list,
	 * preserving the order of their first occurrence. The comparison is case-sensitive.
	 * 
	 * @param list the ArrayList of strings to process
	 * @return a new ArrayList with duplicates removed
	 */
	public static ArrayList<String> removeDuplicates(ArrayList<String> list) {
		//Fill in the code here	
				return null;
	}

	/**
	 * Rotates the elements in an ArrayList k positions to the left.
	 * The rotation modifies the original list and also returns it.
	 * If k is greater than the list size, it wraps around.
	 * 
	 * @param list the ArrayList to rotate
	 * @param k the number of positions to rotate left
	 * @return the rotated ArrayList (same reference as input)
	 */
	public static ArrayList<Integer> rotateLeft(ArrayList<Integer> list, int k) {
		//Fill in the code here	
				return null;
	}

	/**
	 * Finds the most frequently occurring element in an array using a HashMap.
	 * If there are multiple elements with the same highest frequency, returns
	 * the one that appears first in the array. Returns 0 if the array is empty.
	 * 
	 * @param arr the array of integers to analyze
	 * @return the most frequent element, or 0 if array is empty
	 */
	public static int findMostFrequent(int[] arr) {
		//Fill in the code here	
				return 0;
		
	}

	/**
	 * Groups strings by their length using a HashMap.
	 * The keys are the lengths (integers), and the values are ArrayLists
	 * containing all strings of that length. Empty strings are grouped under key 0.
	 * 
	 * @param words the array of strings to group
	 * @return a HashMap with lengths as keys and ArrayLists of strings as values
	 */
	public static HashMap<Integer, ArrayList<String>> groupByLength(String[] words) {
		//Fill in the code here	
				return null;
	}

	/**
	 * Determines if two strings are anagrams using a HashMap.
	 * An anagram means both strings contain the same characters with the same
	 * frequencies. The comparison is case-insensitive and ignores spaces.
	 * 
	 * @param str1 the first string
	 * @param str2 the second string
	 * @return true if the strings are anagrams, false otherwise
	 */
	public static boolean areAnagrams(String str1, String str2) {
		//Fill in the code here	
				return false;
	}
}