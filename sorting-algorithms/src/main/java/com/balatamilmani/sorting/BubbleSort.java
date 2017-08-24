/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.sorting;

import java.util.Arrays;

/**
 * @author Balamurugan Tamilmani
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int unsortedArray[]={12,8,55,3,10,93};
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(unsortedArray));
		System.out.println("After sorting");
		System.out.println(Arrays.toString(sort(unsortedArray)));
	}
	
	/**
	 * Compare First element with Second and Second with Third etc
	 * Lower index element higher than upper index element exchange them
	 * First Iteration leaves the highest element in the right most index
	 * Each subsequent iteration ignore one left most element from being compared
	 * @param a Given Integer array which needs to be sorted
	 * @return The sorted array
	 */
	private static int[] sort(int a[]){
		//Loop from second element up to last one
		boolean swapped = true;
		//For each iteration one element is placed at right position starting at right most place
		for(int j=a.length-1; (j>0 && swapped); j--){
			swapped = false;
			//End of this for loop an element is placed at the right position
			//No element swapped indicates, the elements are in ascending order
			for(int i=0; i<j; i++){
				if(a[i]>a[i+1]){
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
					swapped = true;
				}
			}	
		}
		return a;
	}
}
