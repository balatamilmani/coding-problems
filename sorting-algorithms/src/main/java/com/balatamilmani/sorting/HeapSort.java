package com.balatamilmani.sorting;

import java.util.Arrays;

import com.balatamilmani.model.Heap;

/**
 * @author btamilma
 *
 */
public class HeapSort {

	
	/**
	 * Runtime for a Node which has height h is O(h)
	 * Method enforces the Heap with Root at Index 'index' comply with Max Heap property
	 * Max Heap Property : for except root A[Parent of i] >= A[i]
	 * @param Heap heap
	 * @param index From this index downward the Max heap property to be enforced
	 */
	public void maxHeapify(Heap heap, int index) {
		int leftIndex = getLeftIndex(index);
		int rightIndex = getRightIndex(index);
		int largestIndex = index;
		//Check Left Child is greater
		if(leftIndex <heap.heapSize() && heap.getArray()[leftIndex]>heap.getArray()[index]) {
			largestIndex = leftIndex;
		}
		//Check Right child is greater
		if(rightIndex<heap.heapSize() && heap.getArray()[rightIndex]>heap.getArray()[largestIndex]) {
			//Right child is greater
			largestIndex = rightIndex;
		}
		if(index != largestIndex) {
			//Swap, either Right/Left child is greater than a[index]
			swap(heap, index, largestIndex);
			//Recursively call
			maxHeapify(heap, largestIndex);
		}
	}

	/**
	 * Runtime for a Node which has height h is O(h)
	 * Method enforces the Heap with Root at Index 'index' comply with Min Heap property
	 * Min Heap Property : for except root A[Parent of i] <= A[i]
	 * @param Heap heap
	 * @param index From this index downward the Min heap property to be enforced
	 */
	public void minHeapify(Heap heap, int index) {
		int leftIndex = getLeftIndex(index);
		int rightIndex = getRightIndex(index);
		int largestIndex = index;
		//Check Left Child is greater
		if(leftIndex <heap.heapSize() && heap.getArray()[leftIndex]<heap.getArray()[index]) {
			largestIndex = leftIndex;
		}
		if(rightIndex<heap.heapSize() && heap.getArray()[rightIndex]<heap.getArray()[largestIndex]) {
			largestIndex = rightIndex;
		}
		if(index != largestIndex) {
			//Swap
			swap(heap, index, largestIndex);
			minHeapify(heap, largestIndex);
		}
	}
	
	public void heapSort(Heap heap) {
		//Heapify
		buildMaxHeap(heap);
		int counter = heap.heapSize()-1;//last Index of Heap Array
		for(int i=heap.heapSize()-1; i>=1; i--) {
			swap(heap, 0, heap.heapSize()-(counter--));
			maxHeapify(heap, 0);
		}
	}
	public void buildMaxHeap(Heap heap) {
		for(int i=(heap.heapSize()/2)-1; i>=0;i--) {
			System.out.println(String.format("i=%d, value=%d", i, heap.getArray()[i]));
			maxHeapify(heap,i);
		}
	}
	public void swap(Heap heap, int from, int to) {
		int temp = heap.getArray()[from];
		heap.getArray()[from] = heap.getArray()[to];
		heap.getArray()[to] = temp;
	}
	public int getLeftIndex(int index) {
		return 2*index+1;
	}
	
	public int getRightIndex(int index) {
		return 2*index+2;
	}
}
