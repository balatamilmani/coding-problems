package com.balatamilmani.sorting;

import java.util.Arrays;

public class BubbleSorting {

	public static void main(String[] args) {
		int unsortedArray[]={12,8,55,3,10,93};
		System.out.println("Before sorting");
		System.out.println(Arrays.toString(unsortedArray));
		System.out.println("After sorting");
		System.out.println(Arrays.toString(sort(unsortedArray)));
	}
	
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
