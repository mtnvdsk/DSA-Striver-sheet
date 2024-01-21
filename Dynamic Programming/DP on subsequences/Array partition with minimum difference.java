import java.util.*;
public class Solution {
    public static int minSubsetSumDifference(int []arr, int n) {
		int sum=0;
		for(int i=0;i<n;i++){
			sum+=arr[i];
		}
		int[][] dp=new int[n][sum+1];
		for(int[] i:dp){
			Arrays.fill(i,-1);
		}

		//tabulation
		for(int i=0;i<n;i++){
			dp[i][0]=1;
		}
		if(arr[0]<=sum){
			dp[0][arr[0]]=1;
		}
		for(int i=1;i<n;i++){
			for(int target=1;target<=sum;target++){
				boolean take=false;
				if(arr[i]<=target){
					take=(dp[i-1][target-arr[i]]==1);
				}
				boolean nottake=(dp[i-1][target]==1);
				dp[i][target]=(take||nottake)?1:0;
			}
		}
		int min=(int)1e9;
		for(int i=0;i<=sum/2;i++){
			if(dp[n-1][i]==1){
				min=Math.min(min,Math.abs((sum-i)-i));
			}
		}
		return min;
    }
}