package com.balatamilmani.dynamic;

public class LongestCommonSubsequence {

	public int lenLongCmnSubseqRec(String p, String q) {
		return lcsRec(p,q, p.length()-1, q.length()-1);
	}
	//Recursive solution, without memoization
	public int lcsRec(String p, String q, int m, int n) {
		//Base case
		if(m < 0 || n<0) {
			return 0;
		}
		if(p.charAt(m) == q.charAt(n)) {
			return 1+lcsRec(p,q,m-1, n-1);
		} else {
			return Math.max(lcsRec(p,q,m-1, n), lcsRec(p,q,m,n-1));
		}
	}

	public int lenLongCmnSubseqMemoization(String p, String q) {
		int[][] dp = new int[p.length()][q.length()];
		//initialize with -1
		for(int i=0; i<p.length(); i++) {
			for(int j=0; j<q.length(); j++) {
				dp[i][j] = -1;
			}
		}
		return lcsRecWithMemoization(p,q, p.length()-1, q.length()-1, dp );
	}
	
	//Recursive solution, with memoization
	public int lcsRecWithMemoization(String p, String q, int m, int n, int dp[][]) {
		//Base case
		if(m < 0 || n<0) {
			return 0;
		}
		if(dp[m][n] <0) {
			if(p.charAt(m) == q.charAt(n)) {
				dp[m][n] =  1+lcsRec(p,q,m-1, n-1);
			} else {
				dp[m][n] =  Math.max(lcsRec(p,q,m-1, n), lcsRec(p,q,m,n-1));
			}
		}
		return dp[m][n];
	}
}
