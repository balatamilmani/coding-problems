package com.balatamilmani.dynamic;

import java.util.HashMap;
import java.util.Map;


/**
 * @author btamilma
 *
 * Find the number of Sub Sets of a given Set whose elements sum is equal to given Total
 * E.g. {2,4,6,10} is the Set and Total 16
 * Sub Sets are {}, {10}, {6,10}, {4,6,10}, {2,6,10}, {2,4,6,10}, {4,10}, {2,4,10} etc
 * Among these SubSets only {6,10}, {2,4,10} will have sum equal to Total 16
 * The answer should be 2
 */
public class SubSetsWithGivenSum {

	public int count(int a[], int total, int lastIndex) {
		// Base cases
		if (total == 0) {
			// Number of ways to get Total '0' is '1'
			return 1;
		} else if (total < 0 || lastIndex < 0) {
			// total can't be -ve, lastIndex can't be less than '0'
			return 0;
		}

		if (total < a[lastIndex]) {
			// Current Index number can't be part of Sum
			return count(a, total, lastIndex - 1);
		} else {
			// Number of ways including current number + Number of ways excluding current
			// number
			return count(a, total - a[lastIndex], lastIndex - 1) + count(a, total, lastIndex - 1);
		}
	}

	
	public int countUsingMemoized(int a[], int total) {
		Map<String, Integer> memo = new HashMap<>();
		return countMemoized(a, total, a.length - 1, memo);
	}

	/**
	 * Recursive function using Memoization to find number of sub sets whose sum is total
	 * @param a Set to calculate sum
	 * @param total Subset whose total should be equal to
	 * @param lastIndex Last Index of the Array to be considered
	 * @param memo For Memoization
	 * @return Number of subsets whose sum equal to Total
	 */
	public int countMemoized(int a[], int total, int lastIndex, Map<String, Integer> memo) {
		String key = total + ":" + lastIndex;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		// Base cases
		if (total == 0) {
			// Number of ways to get Total '0' is '1'
			return 1;
		} else if (total < 0 || lastIndex < 0) {
			// total can't be -ve, lastIndex can't be less than '0'
			return 0;
		}
		
		int result = 0;
		if (total < a[lastIndex]) {
			// Current Index number can't be part of Sum
			result = count(a, total, lastIndex - 1);
		} else {
			// Number of ways including current number + Number of ways excluding current
			// number
			result = count(a, total - a[lastIndex], lastIndex - 1) + count(a, total, lastIndex - 1);
		}
		memo.put(key, result);
		return result;

	}
}
