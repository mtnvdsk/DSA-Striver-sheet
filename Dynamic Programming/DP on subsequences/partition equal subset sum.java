import java.util.*;
public class Solution {
	public static boolean rec(int[] arr,int n,int[][] dp,int target){
		if(target==0) return true;
		if(n==0){
			return target==arr[0];
		}
		if(dp[n][target]!=-1) return dp[n][target]==1;
		boolean take=false;
		if(arr[n]<=target){
			take=rec(arr,n-1,dp,target-arr[n]);
		}
		boolean nottake=rec(arr,n-1,dp,target);
		dp[n][target]=(take||nottake)?1:0;
		return take||nottake;
	}
	public static boolean canPartition(int[] arr, int n) {
		
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=arr[i];
		}
		if(sum%2!=0) return false;
		int[][] dp=new int[n][sum/2+1];
		for(int[] i:dp){
			Arrays.fill(i,-1);
		}
		//memoization
		//return rec(arr,n-1,dp,sum/2);

		//tabulation
		for(int i=0;i<n;i++){
			dp[i][0]=1;
		}
		if(arr[0]<=sum/2){
			dp[0][arr[0]]=1;
		}
		for(int i=1;i<n;i++){
			for(int target=1;target<=sum/2;target++){
				boolean take=false;
				if(arr[i]<=target){
					take=(dp[i-1][target-arr[i]]==1);
				}
				boolean nottake=(dp[i-1][target]==1);
				dp[i][target]=(take||nottake)?1:0;
			}
		}
		return dp[n-1][sum/2]==1;
	}
}