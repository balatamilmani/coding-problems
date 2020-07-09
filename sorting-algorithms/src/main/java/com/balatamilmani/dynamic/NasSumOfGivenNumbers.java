package com.balatamilmani.dynamic;

public class NasSumOfGivenNumbers {

	/*
	 * Problem: given n, find the number of different ways to write
n as the sum of 1, 3, 4
Implemented using Dynamic Programming
	 * */
	
	private static int D[] = new int[100];
	
	public static void main(String[] args) {
		NasSumOfGivenNumbers ns = new NasSumOfGivenNumbers();
		int ways = ns.nAsSumOfNumbers(5);
		System.out.println(ways);
	}
	static {
		//Number of ways to write 0 as sum of 1,3,4
		D[0] = 1; //Should this be 0?
		//Number of ways to write 1 as sum of 1,3,4 and so on
		D[1] = 1;
		D[2] = 1;
		D[3] = 2;//3 and 1+1+1
		//D[4] = 2; //1+3 and 3+1
	}
	
	//Dn - Number of ways to write n as sum of 1,3,4
	//Solution: Dn = X1+X2+......X(m-1)+Xm
	//If Xm = 1, the rest of the sum should be (n-1) i.e. from X1 ... X(m-1)
	//the possible solutions are 1+1+1+1+(1), 1+3+(1), 3+1+(1), 4+(1)
	//That's if last value is 1, the number of ways to write n as sum of 1,3,4 is D(n-1)
	//If Xm =3, rest of the sum should be (n-3), i.e. D(n-3)
	//If Xm =4, rest of the sum should be (n-4), i.e. D(n-4)
	//In all, the number of different ways to write n as sum of 1,3,4 Dn = D(n-1)+D(n-3)+D(n-4)
	
	public int nAsSumOfNumbers(int n) {
		//Base cases
		if(n<0) {
			return 0;
		}
		if(n<=3) {
			return D[n];
		}
		D[n] = nAsSumOfNumbers(n-1) + nAsSumOfNumbers(n-3) + nAsSumOfNumbers(n-4);
		return D[n];
	}
}
