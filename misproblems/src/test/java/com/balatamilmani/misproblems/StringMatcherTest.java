/*
 * Copyright (c) 2019. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.misproblems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Balamurugan Tamilmani
 *
 */
public class StringMatcherTest {

	/**
	 * Both strings same length, replacing char matches
	 */
	@Test
	public void testReplacingCharMatches() {
		String source = "abc";
		String target = "acc";
		Assert.assertTrue(StringMatcher.matches(source, target));
	}

	/**
	 * Both strings same length, replacing char doesn't match
	 */
	@Test
	public void testReplacingCharNoMatch() {
		String source = "abc";
		String target = "axy";
		Assert.assertFalse(StringMatcher.matches(source, target));
	}
	
	/**
	 * Source shorter, inserting char matches
	 */
	@Test
	public void testInsertingCharMatches() {
		String source = "ac";
		String target = "acc";
		Assert.assertTrue(StringMatcher.matches(source, target));
	}
	/**
	 * Source shorter by one char, inserting char doesn't match
	 */
	@Test
	public void testInsertingCharNoMatch() {
		String source = "ac";
		String target = "axy";
		Assert.assertFalse(StringMatcher.matches(source, target));
	}
	
	/**
	 * Source longer by one char, deleting char matches
	 */
	@Test
	public void testDeletingCharMatches() {
		String source = "abc";
		String target = "ac";
		Assert.assertTrue(StringMatcher.matches(source, target));
	}
	
	/**
	 * Source longer by one char, deleting char doesn't match
	 */
	@Test
	public void testDeletingCharNoMatch() {
		String source = "abc";
		String target = "al";
		Assert.assertFalse(StringMatcher.matches(source, target));
	}
	/**
	 * Source is null, doesn't match
	 */
	@Test
	public void testSourceOrTargetNullNoMatch() {
		String source = null;
		String target = "ac";
		Assert.assertFalse(StringMatcher.matches(source, target));
	}
	
	/**
	 * Length differs by more than 1 char, doesn't match
	 */
	@Test
	public void testCharCountDiffersMoreThanOneNoMatch() {
		String source = "abcd";
		String target = "ac";
		Assert.assertFalse(StringMatcher.matches(source, target));
	}
}
