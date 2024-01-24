import java.util.*;
public class Solution {
	public static int rec(int price[],int i,int n,int [][]dp){
		if(i==0){
			return n*price[0];
		}
		if(dp[i][n]!=-1) return dp[i][n];
		int take=Integer.MIN_VALUE;
		int rodlength=i+1;
		if(rodlength<=n) take=price[i]+rec(price,i,n-rodlength,dp);
		int notake=rec(price,i-1,n,dp);
		return dp[i][n]=Math.max(take,notake);
	}
	public static int cutRod(int price[], int n) {
		int[][] dp=new int[n][n+1];
		for(int i[]:dp){
			Arrays.fill(i,-1);
		}
		//return rec(price,n-1,n,dp);

		//tabulation
		for(int i=0;i<=n;i++){
			dp[0][i]=price[0]*i;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<=n;j++){
				int take=Integer.MIN_VALUE;
				int rod=i+1;
				if(rod<=j) take=price[i]+dp[i][j-rod];
				int notake=dp[i-1][j];
				dp[i][j]=Math.max(take,notake);
			}
		}
		//return dp[n-1][n];

		//space optimization
		int []prev=new int[n+1];
		int []curr=new int[n+1];
		for(int i=0;i<=n;i++){
			prev[i]=i*price[0];
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<=n;j++){
				int take=Integer.MIN_VALUE;
				int rod=i+1;
				if(rod<=j) take=price[i]+curr[j-rod];
				int notake=prev[j];
				curr[j]=Math.max(take,notake);
			}
			prev=curr;
		}
		return prev[n];
	}
}