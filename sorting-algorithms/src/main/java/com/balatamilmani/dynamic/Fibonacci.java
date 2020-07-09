package com.balatamilmani.dynamic;

public class Fibonacci {

	private static int F[] = new int[100];

	static {
		F[0] = 0;
		F[1] = 1;
	}
	public int fib(int n) {
		// Without Memoization
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public int fibMemoization(int n) {
		// With Memoization
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		F[n] = fibMemoization(n - 1) + fibMemoization(n - 2);
		return F[n];
	}
	public int fibIterativeWithMemoization(int n) {
		// With Memoization, just using two variables
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		for(int i=2; i<n; i++) {
			F[i] = F[i-1] + F[i-2];
		}
		return F[n-1];
	}
	public int fibIterative(int n) {
		// With Memoization, just using two variables
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		
		int pre = 0;
		int cur = 1;
		for(int i=2; i<n; i++) {
			int next = pre + cur;
			pre = cur;
			cur = next;
		}
		return cur;
	}
}
