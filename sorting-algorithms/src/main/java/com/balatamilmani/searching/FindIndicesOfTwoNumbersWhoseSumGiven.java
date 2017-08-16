package com.balatamilmani.searching;

/**
 * Problem: In the given sorted int array, find indices of Two numbers whose sum is given
 * */
public class FindIndicesOfTwoNumbersWhoseSumGiven {

	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int x = 17;// The indices are 7, 8
		int y = 18; // The numbers are not found
		findIndices(a, x);
		findIndices(a, y);
	}
	
	/**
	 * @param a The int array
	 * @param x The given number for which find indices of two numbers whose sum is given 
	 */
	private static void findIndices(int a[], int x){
		int sum = 0;
		int lowerBound = 0;
		int upperBound = a.length-1;
		
		//Stop when all numbers are scanned
		while(lowerBound < upperBound){
			//Find sum of first and last element in the array
			sum = a[lowerBound] + a[upperBound];
			if(sum == x){
				//sum is given x, print the indices
				System.out.println("The indices are "+lowerBound+","+upperBound);
				return;
			} else if(sum > x){
				//Reduce the upper bound by 1
				upperBound = upperBound -1;
			} else {
				//sum is less than x, increase lower bound by 1
				lowerBound = lowerBound +1;
			}
		}
		System.out.println("There are no two numbers in the array whose sum is given");
	}
}
