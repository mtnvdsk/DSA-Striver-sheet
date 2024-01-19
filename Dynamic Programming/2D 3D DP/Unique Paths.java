import java.util.* ;
import java.io.*; 
public class Solution {
	public static int rec(int i,int j,int [][]dp){
		if(i==0 && j==0) return 1;
		if(i<0 || j<0) return 0;
		if(dp[i][j]!=-1) return dp[i][j];
		int up=rec(i-1,j,dp);
		int left=rec(i,j-1,dp);
		return dp[i][j]=left+up;
	}
	public static int uniquePaths(int m, int n) {
		int[][] dp=new int[m][n];
		for(int[] i:dp){
			Arrays.fill(i,-1);
		}
		// memoization
		// return rec(m-1,n-1,dp);

		//tabulation
		// dp[0][0]=1;
		// for(int i=0;i<m;i++){
		// 	for(int j=0;j<n;j++){
		// 		if(i==0 && j==0) dp[i][j]=1;
		// 		else{
		// 			int left=0,up=0;
		// 			if(i>0) up=dp[i-1][j];
		// 			if(j>0) left=dp[i][j-1];
		// 			dp[i][j]=left+up;
		// 		}
		// 	}
		// }
		// return dp[m-1][n-1];

		//space optimization
		int prev[]=new int[m];
		for(int i=0;i<m;i++){
			int []temp=new int[n];
			for(int j=0;j<n;j++){
				if(i==0 &&j==0){
					temp[j]=1;
					continue;
				}
				int left=0,up=0;
				if(i>0) up=prev[j];
				if(j>0) left=temp[j-1];
				temp[j]=left+up;

			}
			prev=temp;
		}
		return prev[n-1];

	}
}