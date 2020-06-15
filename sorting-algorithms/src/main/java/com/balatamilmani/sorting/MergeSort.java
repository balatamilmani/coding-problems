package com.balatamilmani.sorting;

public class MergeSort {
	
	public void sort(int a[], int start, int end) {
		if(start<end) {
			int mid = start+(end-start)/2;
			sort(a, start, mid);
			sort(a, mid+1, end);
			merge(a, start, mid, end);
		}
	}

	private void merge(int[] a, int start, int mid, int end) {
		int n1 = mid-start+1;
		int n2 = end - mid;
		
		int left[] = new int[n1+1];
		int right[] = new int[n2+1];
		
		//copy into Left & right array
		for(int i=0; i<n1; i++) {
			left[i] = a[start+i];
		}
		left[n1] = Integer.MAX_VALUE;
		for(int i=0; i<n2; i++) {
			right[i] = a[mid+1+i];
		}
		right[n2] = Integer.MAX_VALUE;
		
		//merge left and right array into original array
		int i=0;
		int j=0;
		for(int k=start; k<=end; k++) {
			if(left[i]<right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
		}
		
	}
}
