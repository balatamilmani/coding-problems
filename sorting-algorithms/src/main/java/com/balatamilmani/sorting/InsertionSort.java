/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.sorting;

import java.util.Arrays;

public class InsertionSort { 
	public static void main(String[] args) {
		int unsortedArray[]={12,8,55,3,10,93};
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(unsortedArray));
		System.out.println("After sorting");
		System.out.println(Arrays.toString(sort(unsortedArray)));
	}
	
	public static int[] sort(int a[]){
		//Loop from second element upto last one
		for(int j=1; j<a.length; j++){
			int val = a[j]; //Everything below j is sorted
			//compare a[j] with all elements starting from a[j-1] until a[0]
			int i=j-1;
			while(i>=0 && a[i]>val){
				a[i+1] = a[i]; //keep moving the value to right until end or a smaller value is found
				i=i-1;
			}
			a[i+1] = val;
		}
		return a;
	}
}
