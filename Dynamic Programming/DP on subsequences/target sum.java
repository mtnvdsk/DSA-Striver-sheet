import java.util.* ;
import java.io.*; 
public class Solution {
    public static int rec(int i,int tar,int []arr,int[][] dp){
        if(i==0){
            if(tar==0 && arr[0]==0) return 2;
            if(tar==0 || tar==arr[0]) return 1;
            return 0;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int take=0;
        if(arr[i]<=tar) take=rec(i-1,tar-arr[i],arr,dp);
        int notake=rec(i-1,tar,arr,dp);
        return dp[i][tar]=take+notake;
    }
    public static int targetSum(int n, int tar, int[] arr) {
        int sum=0;
        for(int i=0;i<n;i++) sum+=arr[i];
        if((sum-tar)<0 || (sum-tar)%2!=0) return 0;
        int subsum=(sum-tar)/2;
        int[][] dp=new int[n][subsum+1];
        // for(int[] i: dp){
        //     Arrays.fill(i,-1);
        // }
    	//return rec(n-1,subsum,arr,dp);

        //tabulation
        if(arr[0]==0) dp[0][0]=2;
        else dp[0][0]=1;
        if(arr[0]!=0 && arr[0]<=subsum) dp[0][arr[0]]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<=subsum;j++){
                int take=0;
                if(arr[i]<=j) take=dp[i-1][j-arr[i]];
                int notake=dp[i-1][j];
                dp[i][j]=take+notake;
            }
        }
        return dp[n-1][subsum];
    }
}