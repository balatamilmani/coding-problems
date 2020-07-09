package com.balatamilmani;

import org.junit.Assert;
import org.junit.Test;

import com.balatamilmani.dynamic.LongestCommonSubsequence;

public class LongestCommonSubsequenceTest {

	private LongestCommonSubsequence lcs = new LongestCommonSubsequence();
	
	/**
	 * 'BC' Common, length is 2
	 */
	@Test
	public void test1() {
		String p = "ABC";
		String q = "LMNBC";
		int expected = 2;
		
		int actual = lcs.lenLongCmnSubseqRec(p, q);
		Assert.assertEquals(expected, actual);
	}

	/**
	 * 'ABC' Common, length is 3
	 */
	@Test
	public void test2() {
		String p = "ABC";
		String q = "ABC";
		int expected = 3;
		
		int actual = lcs.lenLongCmnSubseqRec(p, q);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * No Common, length is 0
	 */
	@Test
	public void test3() {
		String p = "ABC";
		String q = "LMN";
		int expected = 0;
		
		int actual = lcs.lenLongCmnSubseqRec(p, q);
		Assert.assertEquals(expected, actual);
	}
	
	//Test for Memoization solution
	/**
	 * 'BC' Common, length is 2
	 */
	@Test
	public void test4() {
		String p = "ABC";
		String q = "LMNBC";
		int expected = 2;
		
		int actual = lcs.lenLongCmnSubseqMemoization(p, q);
		Assert.assertEquals(expected, actual);
	}

	/**
	 * 'ABC' Common, length is 3
	 */
	@Test
	public void test5() {
		String p = "ABC";
		String q = "ABC";
		int expected = 3;
		
		int actual = lcs.lenLongCmnSubseqMemoization(p, q);
		Assert.assertEquals(expected, actual);
	}
	
	/**
	 * No Common, length is 0
	 */
	@Test
	public void test6() {
		String p = "ABC";
		String q = "LMN";
		int expected = 0;
		
		int actual = lcs.lenLongCmnSubseqMemoization(p, q);
		Assert.assertEquals(expected, actual);
	}
}
