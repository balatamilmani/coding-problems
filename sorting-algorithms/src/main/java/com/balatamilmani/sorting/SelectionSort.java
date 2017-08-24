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
public class SelectionSort {

	public static void main(String[] args) {
		int unsortedArray[]={12,8,55,3,10,93};
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(unsortedArray));
		System.out.println("After sorting");
		System.out.println(Arrays.toString(sort(unsortedArray)));
	}
	
	/**
	 * Divide given array into sorted and unsorted, which initially has no element
	 * Initially consider 1st element in the sorted section, compare this with every other element in the array
	 * If any other element found to be smaller than 0th element exchange them
	 * The subsequent iteration considers 2nd element and so on
	 * @param a Given Integer array which needs to be sorted
	 * @return The sorted array
	 */
	public static int[] sort(int a[]){
		//Loop from second element upto last one
		for(int j=0; j<a.length-1; j++){
			//Jth element is considered the smallest
			int minIndex = j;
			for(int i=j+1; i<a.length; i++){
				//Any element is found smaller than Jth, update minIndex
				if(a[minIndex]>a[i]){
					minIndex = i;
				}
			}
			//Smallest element of this iteration is placed on Jth place
			if(j!=minIndex){
				int temp = a[minIndex];
				a[minIndex] = a[j];
				a[j] = temp;
			}
		}
		return a;
	}
}
