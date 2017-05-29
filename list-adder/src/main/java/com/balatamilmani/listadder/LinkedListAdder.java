/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.listadder;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Balamurugan Tamilmani
 * Given Two Linked List's of Integers, this class's static method returns its sum as Linked List
 * For e.g. [1,2,3], [5,6] will result in [1,7,9]
 */
public class LinkedListAdder {

	/**
	 * Given Two Linked List's of Integers, this method returns its sum as Linked List
	 * For e.g. [1,2,3], [5,6] will result in [1,7,9]
	 * @param listOne The first value to be added
	 * @param listTwo The second value to be added
	 * @return List contain the sum of the values
	 * @throws Exception If both the Lists are Null 
	 * or when one of the List is null the other is empty 
	 * or both Lists are empty 
	 */
	public static List<Integer> add(List<Integer> listOne, List<Integer> listTwo) throws Exception {
		//Validate input
		validate(listOne, listTwo);

		List<Integer> listResult = new LinkedList<Integer>();
		List<Integer> longerList = null;
		List<Integer> shorterList = null;
		ListIterator<Integer> longListIt = null;
		ListIterator<Integer> shortListIt = null;
		
		int firstValue, secondValue, sum=0, reminder=0, quotient=0;
		
		if(listOne == null || !(listOne.size()>0)){
			//First List is null the result is just the Second List
			listResult = new LinkedList<>(listTwo);
		} else if(listTwo == null || !(listTwo.size()>0)) {
			//Second List is null the result is just the First List
			listResult = new LinkedList<>(listOne);
		} else {
			//Both Lists non empty
			if(listOne.size()>listTwo.size()){
				longerList = new LinkedList<>(listOne);
				shorterList = new LinkedList<>(listTwo);
			} else {
				//Both Lists same size also second List will be considered as Long List
				longerList = new LinkedList<>(listTwo);
				shorterList = new LinkedList<>(listOne);
			}
			
			longListIt = longerList.listIterator(longerList.size());
			shortListIt = shorterList.listIterator(shorterList.size());
			
			while(longListIt.hasPrevious()) {
				reminder = 0;
				secondValue = 0;
				firstValue = longListIt.previous();
				if(shortListIt.hasPrevious()){
					secondValue = shortListIt.previous();
				}
				sum = firstValue + secondValue + quotient;
				quotient = sum/10;
				reminder = sum%10;
				//Reminder added to Result, quotient will be carried over to 
				listResult.add(0,reminder);
			}
			if(sum>=10){
				listResult.add(0, quotient);
			}
		}
		return listResult;
	}

	/**
	 * @param listOne List containing the Int values
	 * @param listTwo List containing the Int values
	 * @throws Exception If both the Lists are Null 
	 * or when one of the List is null the other is empty 
	 * or both Lists are empty  
	 */
	private static void validate(List<Integer> listOne, List<Integer> listTwo) throws Exception {
		//Both lists can't be null
		if(		(listOne == null && listTwo == null)	){
			throw new Exception("Both lists can't be Null");
		}
		//One of the list should have values
		if(		(listOne == null && !(listTwo.size()>0)) || 
				(listTwo == null && !(listOne.size()>0)) ||
				((listOne != null && listTwo != null) && !(listOne.size()>0) && !(listTwo.size()>0))
				){
			throw new Exception("The list(s) can't be empty. At least one list must have value");
		}
	}
}
