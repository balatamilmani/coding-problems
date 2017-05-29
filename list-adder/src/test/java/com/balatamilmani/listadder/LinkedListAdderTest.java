/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.listadder;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author Balamurugan Tamilmani
 * Test code for Linked List adder
 */
public class LinkedListAdderTest {

	/**
	 * Both the Lists are null, Expect Exception
	 */
	@Test
	public void testAddAllNullNotAllowedThrowsException() {
		List<Integer> listOne = null;
		List<Integer> listTwo = null;
		try {
			LinkedListAdder.add(listOne, listTwo);
		} catch (Exception e) {
			Assert.assertTrue(e.toString().contains("Both lists can't be Null"));
		}
	}

	/**
	 * One List is Empty and other Null, Except Exception
	 */
	@Test
	public void testAddOneListMustContainValueThrowsException() {
		List<Integer> listOne = new LinkedList<>();
		List<Integer> listTwo = null;
		try {
			LinkedListAdder.add(listOne, listTwo);
		} catch (Exception e) {
			Assert.assertTrue(e.toString().contains("The list(s) can't be empty. At least one list must have value"));
		}
	}

	/**
	 * Both Lists are not Null, however Empty, Expect Exception
	 */
	@Test
	public void testAddBothNotNullListNoValuesThrowsException() {
		List<Integer> listOne = new LinkedList<>();
		List<Integer> listTwo = new LinkedList<>();
		try {
			LinkedListAdder.add(listOne, listTwo);
		} catch (Exception e) {
			Assert.assertTrue(e.toString().contains("The list(s) can't be empty. At least one list must have value"));
		}
	}
	
	/**
	 * First List has values, second List is null, Expect simply First List returned
	 * 
	 */
	@Test
	public void testAddFirstListValuesSecondNullExpectFirstList() {
		List<Integer> listOne = new LinkedList<>();
		List<Integer> listTwo = null;
		List<Integer> listResult = null;
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals(listOne, listResult);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * Second List has values, First List is null, Expect simply Second List returned
	 * 
	 */
	@Test
	public void testAddSecondListValuesFirstNullExpectSecondList() {
		List<Integer> listOne = null;
		List<Integer> listTwo = new LinkedList<>();
		List<Integer> listResult = null;
		listTwo.add(1);
		listTwo.add(2);
		listTwo.add(3);
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals(listTwo, listResult);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * First List has values, second List is not null but Empty, Expect simply First List returned
	 */
	@Test
	public void testAddFirstListValuesSecondNonNullEmptyExpectFirstList() {
		List<Integer> listOne = new LinkedList<>();
		List<Integer> listTwo = new LinkedList<>();
		List<Integer> listResult = null;
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals(listOne, listResult);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	/**
	 * Second List has values, First List is not null but Empty, Expect simply Second List returned
	 */
	@Test
	public void testAddSecondListValuesFirstNonNullEmptyExpectSecondList() {
		List<Integer> listOne = new LinkedList<>();
		List<Integer> listTwo = new LinkedList<>();
		List<Integer> listResult = null;
		listTwo.add(1);
		listTwo.add(2);
		listTwo.add(3);
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals(listTwo, listResult);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	/**
	 * Both Lists are not null, expect its sum returned
	 */
	@Test
	public void testAddBothListHasValueNoCarryOver() {
		List<Integer> listOne = new LinkedList<Integer>();
		List<Integer> listTwo = new LinkedList<Integer>();
		List<Integer> listExpected = new LinkedList<Integer>();
		List<Integer> listResult = null;
		
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		
		listTwo.add(5);
		listTwo.add(6);
		
		listExpected.add(1);
		listExpected.add(7);
		listExpected.add(9);
		
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals("[1, 7, 9]", listResult.toString());
			Assert.assertEquals(listExpected, listResult);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	/**
	 * The reminder is carried over
	 */
	@Test
	public void testAddBothListHasValueWithCarryOver() {
		List<Integer> listOne = new LinkedList<Integer>();
		List<Integer> listTwo = new LinkedList<Integer>();
		List<Integer> listExpected = new LinkedList<Integer>();
		List<Integer> listResult = null;
		
		listOne.add(6);
		listOne.add(7);
		listOne.add(8);
		
		listTwo.add(9);
		listTwo.add(8);
		
		listExpected.add(7);
		listExpected.add(7);
		listExpected.add(6);
		
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals("[7, 7, 6]", listResult.toString());
			Assert.assertEquals(listExpected, listResult);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	/**
	 * The reminder is carried over. Both Lists same size
	 */
	@Test
	public void testAddBothListHasValueSameSizeWithCarryOver() {
		List<Integer> listOne = new LinkedList<Integer>();
		List<Integer> listTwo = new LinkedList<Integer>();
		List<Integer> listExpected = new LinkedList<Integer>();
		List<Integer> listResult = null;
		
		listOne.add(6);
		listOne.add(7);
		listOne.add(8);
		
		listTwo.add(5);
		listTwo.add(6);
		listTwo.add(7);
		
		listExpected.add(1);
		listExpected.add(2);
		listExpected.add(4);
		listExpected.add(5);
		
		try {
			listResult = LinkedListAdder.add(listOne, listTwo);
			Assert.assertEquals("[1, 2, 4, 5]", listResult.toString());
			Assert.assertEquals(listExpected, listResult);
		} catch (Exception e) {
			Assert.fail();
		}
	}
}
