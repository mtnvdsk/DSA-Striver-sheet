import java.util.* ;
import java.io.*; 
public class Solution {
	public static int rec(int []arr,int i,int tar,int [][]dp){
		if(i==0){
			if(tar==0 && arr[0]==0) return 2;
			if(tar==0 || arr[0]==tar) return 1;
			return 0;
		}
		if(dp[i][tar]!=-1) return dp[i][tar];
		int take=0;
		if(arr[i]<=tar) take=rec(arr,i-1,tar-arr[i],dp);
		int notake=rec(arr,i-1,tar,dp);
		return dp[i][tar]=(take+notake)%1000000007;
	}
	public static int countPartitions(int n, int d, int[] arr) {
		int sum=0;
		int mod=(int)1000000007;
		for(int i=0;i<n;i++){
			sum+=arr[i];
		}
		int subsetsum=0;
		if(sum-d>=0 && (sum-d)%2==0){
			subsetsum=(sum-d)/2;
		}
		else{
			return 0;
		}
		int [][]dp=new int[n][subsetsum+1];
		//for(int i[]:dp) Arrays.fill(i,-1);
		//return rec(arr,n-1,subsetsum,dp);
		if(arr[0]==0) dp[0][0]=2;
		else dp[0][0]=1;
		if(arr[0]!=0 && arr[0]<=subsetsum){
			dp[0][arr[0]]=1;
		}
		for(int i=1;i<n;i++){
			for(int j=0;j<=subsetsum;j++){
				int take=0;
				if(arr[i]<=j) take=dp[i-1][j-arr[i]];
				int notake=dp[i-1][j];
				dp[i][j]=(take+notake)%mod;
			}
		}
		return dp[n-1][subsetsum]%mod;
	}
}