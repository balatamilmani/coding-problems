package com.balatamilmani;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.balatamilmani.sorting.MergeSort;


public class MergeSortTest {

	private static MergeSort ms = new MergeSort();
	
	@Test
	public void mergeSort1() {
		int a[] = {2,1};
		int expected[] = {1,2};
		ms.sort(a, 0, a.length-1);
		Assert.assertEquals(Arrays.toString(expected), Arrays.toString(a));
	}
	
	@Test
	public void mergeSort12() {
		int a[] = {2,1,9,5,8,3};
		int expected[] = {1,2,3,5,8,9};
		ms.sort(a, 0, a.length-1);
		Assert.assertEquals(Arrays.toString(expected), Arrays.toString(a));
	}

	@Test
	public void mergeSortTestOddNumberInput() {
		int a[] = {2,1,9,5,8,3,4};
		int expected[] = {1,2,3,4,5,8,9};
		ms.sort(a, 0, a.length-1);
		Assert.assertEquals(Arrays.toString(expected), Arrays.toString(a));
	}
}
