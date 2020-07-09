package com.balatamilmani.model;

public class Heap {

	private int array[];
	private int heapSize;
	
	
	public Heap(int length) {
		super();
		this.array = new int[length];
		this.heapSize = 0;
	}

	public int length() {
		return array.length;
	}
	
	public int heapSize() {
		return heapSize;
	}
	

	/**
	 * @return the a
	 */
	public int[] getArray() {
		return array;
	}

	/**
	 * @param a the a to set
	 * @throws Exception 
	 */
	public void setArray(int[] a) throws Exception {
		//a's length should be <= Heap.a
		if(this.length()<a.length) {
			throw new Exception(String.format("Arrays's length must be within %d", this.length()));
		}
		for(int i=0; i<a.length; i++) {
			this.array[i] = a[i];
		}
		this.heapSize = a.length;
	}
	
	
}
