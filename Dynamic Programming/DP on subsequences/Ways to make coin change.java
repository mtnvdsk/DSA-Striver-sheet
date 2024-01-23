import java.util.*;
public class Solution {
	public static long rec(int []arr,int tar,long [][]dp,int i){
		if(i==0){
			if(tar%arr[0]==0) return 1;
			return 0;
		}
		if(dp[i][tar]!=-1) return dp[i][tar];
		long take=0;
		if(arr[i]<=tar) take=rec(arr,tar-arr[i],dp,i);
		long notake=rec(arr,tar,dp,i-1);
		return dp[i][tar]=take+notake;
	}
	public static long countWaysToMakeChange(int denominations[], int value){
        int n=denominations.length;
		long[][] dp=new long[n][value+1];
		// for(long[] i:dp) Arrays.fill(i,-1);
		// return rec(denominations,value,dp,n-1);


		//tabulation
		// for(int i=0;i<=value;i++){
		// 	if(i%denominations[0]==0) dp[0][i]=1;
		// 	else dp[0][i]=0;
		// }
		// for(int i=1;i<n;i++){
		// 	for(int j=0;j<=value;j++){
		// 		long take=0;
		// 		if(denominations[i]<=j) take=dp[i][j-denominations[i]];
		// 		long notake=dp[i-1][j];
		// 		dp[i][j]=take+notake;
		// 	}
		// }
		// return dp[n-1][value];

		//space optimization
		long[] prev=new long[value+1];
		long[] curr=new long[value+1];
		for(int i=0;i<=value;i++){
			if(i%denominations[0]==0) prev[i]=1;
			else prev[i]=0;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<=value;j++){
				long take=0;
				if(denominations[i]<=j) take=curr[j-denominations[i]];
				long notake=prev[j];
				curr[j]=take+notake;
			}
			prev=curr;
		}
		return prev[value];
	}
}