import java.util.*;
public class Solution {
	public static int rec(int[] p,int i,int j,int[][] dp){
		if(i==j) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int min=(int)1e9;
		for(int k=i;k<j;k++){
			int steps=(p[i-1]*p[k]*p[j])+rec(p,i,k,dp)+rec(p,k+1,j,dp);
			min=Math.min(min,steps);
		}
		return dp[i][j]=min;
	}
	public static int mcm(int[] p){
		int n=p.length;
		int[][] dp=new int[n][n];
		//for(int[] i:dp) Arrays.fill(i,-1);
		//memoization
		//return rec(p,1,n-1,dp);

		//tabulation
		for(int i=n-1;i>=1;i--){
			for(int j=i+1;j<n;j++){
				int min=(int)1e9;
				for(int k=i;k<j;k++){
					int steps=(p[i-1]*p[k]*p[j])+dp[i][k]+dp[k+1][j];
					min=Math.min(min,steps);
				}
				dp[i][j]=min;
			}
		}
		return dp[1][n-1];
	}
}