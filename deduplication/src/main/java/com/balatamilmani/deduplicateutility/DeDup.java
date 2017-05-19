/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.deduplicateutility;

import java.util.Arrays;

/**
 * @author Balamurugan Tamilmani
 *
 */
public class DeDup {

	private static int input[] = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19,
			1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	private static final int BUCKET_ARRAY_LENGTH = 10;
	private static int deduplicatedRetainingOrder[] = {};

	/**
	 * @param args Arguments to VM
	 * @throws Exception Exception thrown if anything went wrong
	 */
	public static void main(String[] args) throws Exception {
		//Testing
		int noDupArray[];

		noDupArray = removeDuplicates(input);
		System.out.println("The duplicate removed values->" + Arrays.toString(noDupArray));
		System.out.println("Order preserved::" + Arrays.toString(deduplicatedRetainingOrder));
	}

	/**
	 * This method removes the duplicate values in the given int array
	 * The order preserved values is stored in the static variable
	 * @param input The int array that needs to be deDuplicated
	 * @return int Array which is deDuplicated
	 * @throws Exception Throws Exception if the given array is null or empty
	 */
	public static int[] removeDuplicates(int input[]) throws Exception {
		int[][] hashArray;// Holds unique elements in Hash based Array
		int[] noDupArray;// The deduplicated elements

		// Given Array shouldn't be Null or Empty
		validate(input);

		// Get given input placed on Hash based array
		hashArray = getHashedArray(input);

		// Consolidated the elements from HashArray
		noDupArray = consolidate(hashArray);
		return noDupArray;
	}

	/**
	 * This method return the deDuplicated int array that has elements in the same order as the input
	 * @param inputArray The int array that needs to be deDuplicated
	 * @return int Array which is deDuplicated which has the values in the order as input 
	 * @throws Exception Throws Exception if the given array is null or empty
	 */
	public static int[] removeDuplicatesKeepOrder(int inputArray[]) throws Exception {
		//Reinitialize static variable
		deduplicatedRetainingOrder = new int[0];
		removeDuplicates(inputArray);
		return deduplicatedRetainingOrder;
	}
	
	/**
	 * @param hashArray The Hash Array which contain the given input across Buckets based on its hash value
	 * @return int array which is deDuplicated
	 */ 
	private static int[] consolidate(int hashArray[][]) {
		//Initialize deDuplicated Array
		int noDupArray[] = {};
		int target[] = {};
		for (int i = 0; i < hashArray.length; i++) {
			int intList[] = hashArray[i];
			if (intList != null && intList.length > 0) {
				//There are elements under this Hash Bucket, add to result
				//Copy current result and make room for this Bucket values
				target = Arrays.copyOf(noDupArray, noDupArray.length + intList.length);
				//Copy this Bucket values at the end of the Array
				for (int j = target.length - 1; j > noDupArray.length - 1; j--) {
					target[j] = intList[j - noDupArray.length];
				}
				//Reassign the expanded Array into result
				noDupArray = target;
			}
		}
		return noDupArray;
	}

	/**
	 * This method places the unique input values across hash buckets based on its Hash value
	 * @param input inputArray The int array that needs to be deDuplicated
	 * @return hashArray The Hash Array which contain the given input across Buckets based on its hash value
	 */
	private static int[][] getHashedArray(int input[]) {
		// Hash Array is initialized with Length of Bucket
		int hashArray[][] = new int[BUCKET_ARRAY_LENGTH][];

		// Loop the input and push to corresponding Hash Bucket if not exists
		// already
		for (int i = 0; i < input.length; i++) {
			// Find the Hash value to identity Bucket for this element
			// -ve Hash Values will be converted into its corresponding +ve hash
			// value
			int hashValue = Math.abs(new Integer(input[i]).hashCode() % BUCKET_ARRAY_LENGTH);
			// Retrieve the Array to which this element needs to be pushed
			int oneDimArray[] = hashArray[hashValue];
			// Get the element pushed to Array if not duplicate
			int valueAddedArray[] = pushUniqueValues(input[i], oneDimArray);
			// Keep the Hash Bucked updated
			hashArray[hashValue] = valueAddedArray;
		}
		return hashArray;
	}

	/**
	 * @param valueToAdd The value to be added
	 * @param oneDimArray The array to which the value needs to be added in case not already exists
	 * @return int array for a particular hash value
	 */
	private static int[] pushUniqueValues(int valueToAdd, int[] oneDimArray) {
		// Temp Array, with order, to expand and add if this value doesn't exist
		// already
		int orderPreservedTargetAr[] = deduplicatedRetainingOrder;
		// Temp Array to expand and add if this value doesn't exist already,
		// initialize with given array
		int targetArray[] = oneDimArray;

		boolean isAlreadyExists = false;
		if (oneDimArray == null || oneDimArray.length == 0) {
			// This is the first element to be added in this Bucket
			targetArray = new int[1];
			targetArray[0] = valueToAdd;

			// Add the value in the Order preserved Array too
			orderPreservedTargetAr = Arrays.copyOf(deduplicatedRetainingOrder, deduplicatedRetainingOrder.length + 1);
			orderPreservedTargetAr[orderPreservedTargetAr.length - 1] = valueToAdd;
		} else {
			// loop, if not found add
			for (int i = 0; i < oneDimArray.length; i++) {
				if (valueToAdd == oneDimArray[i]) {
					// This element already exists
					isAlreadyExists = true;
					break;
				}
			}
			if (!isAlreadyExists) {
				// Expand the Array and add new value at the end
				targetArray = Arrays.copyOf(oneDimArray, oneDimArray.length + 1);
				targetArray[targetArray.length - 1] = valueToAdd;

				// Add the value in the Order preserved Array too
				orderPreservedTargetAr = Arrays.copyOf(deduplicatedRetainingOrder,
						deduplicatedRetainingOrder.length + 1);
				orderPreservedTargetAr[orderPreservedTargetAr.length - 1] = valueToAdd;
			}
		}
		deduplicatedRetainingOrder = orderPreservedTargetAr;
		return targetArray;
	}


	
	/**
	 * @param input inputArray The int array that needs to be deDuplicated 
	 * @throws Exception Throws Exception if the given array is null or empty
	 */
	private static void validate(int input[]) throws Exception {
		if (input == null || input.length == 0) {
			throw new Exception("The Array can't be null or empty");
		}
	}
}
