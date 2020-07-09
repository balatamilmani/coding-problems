package com.balatamilmani;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.balatamilmani.model.Heap;
import com.balatamilmani.sorting.HeapSort;


public class HeapSortTest {

	private static HeapSort heapSort = new HeapSort();
	
	@Test
	public void test1() {
		int a[] = {4,1,3,2,16,9,10,14,8,7};
		Heap heap = new Heap(a.length);
		try {
			heap.setArray(a);
			heapSort.heapSort(heap);
		} catch (Exception e) {
			Assert.fail();
		}
		System.out.println(Arrays.toString(heap.getArray()));
	}
}
