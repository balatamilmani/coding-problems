/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.deduplicateutility;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import com.balatamilmani.deduplicateutility.DeDup;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for DeDuplication code
 */
public class DeDupTest extends TestCase {

	/**
	 * Tests all +ve values are deDuplicated
	 */
	public void testDeDuplicateWithPositveValues() {
		int input[] = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3,
				20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6, 19, 13, 5,
				11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };
		int deDuplicated[] = {};
		try {
			deDuplicated = DeDup.removeDuplicates(input);
		} catch (Exception e) {
			Assert.fail();
		}
		
		//Expected
		Set<Integer> deDuplicatedInputDataSet = new TreeSet<>();
		//Add input elements to set to eliminate Duplicate and compare with deDuplicated
		for(int i:input){
			deDuplicatedInputDataSet.add(i);
		}
		
		//Actual
		//Convert deDuplicated values into Set to compare
		Set<Integer> deDuplicatedActualDataSet = new TreeSet<>();
		for(int i:deDuplicated){
			deDuplicatedActualDataSet.add(i);
		}
		
		//Compare the code has eliminated the Duplicates
		Assert.assertEquals(deDuplicatedInputDataSet, deDuplicatedActualDataSet);
	}

	/**
	 * Tests deDuplication with -ve values
	 */
	public void testDeDuplicateWithNegativeValues() {
		int inputWithNegatives[] = {100, 0, -1, 10, 1, 10, 1, -1};
		int deDuplicated[] = {};
		try {
			deDuplicated = DeDup.removeDuplicates(inputWithNegatives);
		} catch (Exception e) {
			Assert.fail();
		}

		//Expected
		Set<Integer> deDuplicatedInputDataSet = new TreeSet<>();
		//Add input elements to set to eliminate Duplicate and compare with deDuplicated
		for(int i:inputWithNegatives){
			deDuplicatedInputDataSet.add(i);
		}
		
		//Actual
		//Convert deDuplicated values into Set to compare
		Set<Integer> deDuplicatedActualDataSet = new TreeSet<>();
		for(int i:deDuplicated){
			deDuplicatedActualDataSet.add(i);
		}
		
		//Compare the code has eliminated the Duplicates
		Assert.assertEquals(deDuplicatedInputDataSet, deDuplicatedActualDataSet);
	}
	
	/**
	 * Tests deDuplication with -ve values
	 */
	public void testDeDuplicateWithSingleValue() {
		int inputJustOneValue[] = {100};
		int deDuplicated[] = {};
		try {
			deDuplicated = DeDup.removeDuplicates(inputJustOneValue);
		} catch (Exception e) {
			Assert.fail();
		}

		//Expected
		Set<Integer> deDuplicatedInputDataSet = new TreeSet<>();
		//Add input elements to set to eliminate Duplicate and compare with deDuplicated
		for(int i:inputJustOneValue){
			deDuplicatedInputDataSet.add(i);
		}
		
		//Actual
		//Convert deDuplicated values into Set to compare
		Set<Integer> deDuplicatedActualDataSet = new TreeSet<>();
		for(int i:deDuplicated){
			deDuplicatedActualDataSet.add(i);
		}
		
		//Compare the code has eliminated the Duplicates
		Assert.assertEquals(deDuplicatedInputDataSet, deDuplicatedActualDataSet);
	}	
	/**
	 * Tests deDuplication with -ve values, order Preserved
	 */
	public void testDeDuplicatePreserveOrder() {
		int inputWithNegatives[] = {100, 0, -1, 10, 1, 10, 1, -1};
		int deDuplicated[] = {};
		try {
			deDuplicated = DeDup.removeDuplicatesKeepOrder(inputWithNegatives);
		} catch (Exception e) {
			Assert.fail();
		}
		
		//Expected
		String expectedResult = "[100, 0, -1, 10, 1]";
		
		//Compare the code has eliminated the Duplicates
		Assert.assertEquals(expectedResult, Arrays.toString(deDuplicated));
	}
	
	/**
	 * Tests deDuplication with empty values
	 */
	public void testDeDuplicateEmptyValuesExpectException() {
		int inputEmptyArray[] = {};
		int deDuplicated[] = {};
		try {
			deDuplicated = DeDup.removeDuplicates(inputEmptyArray);
			Assert.fail();
		} catch (Exception e) {
			
		}
	}

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public DeDupTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(DeDupTest.class);
	}
}
