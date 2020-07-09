package com.balatamilmani;

import org.junit.Assert;
import org.junit.Test;

import com.balatamilmani.dynamic.SubSetsWithGivenSum;


public class SubSetsWithGivenSumTest {

	private static SubSetsWithGivenSum sss = new SubSetsWithGivenSum();
	
	@Test
	public void waysMustBeTwoTest() {
		int a[] = {2,4,6,10};
		int count = sss.count(a, 16, a.length-1); 
		Assert.assertEquals(2, count);

	}
	@Test
	public void waysMustBeTwoCountUsingMemoizedTest() {
		int a[] = {2,4,6,10};
		int count = sss.countUsingMemoized(a, 16); 
		Assert.assertEquals(2, count);
		
	}
	

}
