import java.util.* ;
import java.io.*; 

public class Solution{
    public static int rec(int[] val,int []wt,int i,int w,int[][] dp){
        if(i==0){
            if(wt[0]<=w) return val[i];
            return 0;
        }
        if(dp[i][w]!=-1) return dp[i][w];
        int take=Integer.MIN_VALUE;
        if(wt[i]<=w) take=val[i]+rec(val,wt,i-1,w-wt[i],dp);
        int notake=rec(val,wt,i-1,w,dp);
        return dp[i][w]=Math.max(take,notake);
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp=new int[n][maxWeight+1];
        // for(int i[]:dp){
        //     Arrays.fill(i,-1);
        // }
        //memoization
        //return rec(value,weight,n-1,maxWeight,dp);

        //tabulation
        // for(int i=weight[0];i<=maxWeight;i++){
        //     dp[0][i]=value[0];
        // }
        // for(int i=1;i<n;i++){
        //     for(int j=0;j<=maxWeight;j++){
        //         int take=Integer.MIN_VALUE;
        //         if(weight[i]<=j) take=value[i]+dp[i-1][j-weight[i]];
        //         int notake=dp[i-1][j];
        //         dp[i][j]=Math.max(take,notake);
        //     }
        // }
        // return dp[n-1][maxWeight];

        //space optimization using 2 arrays
        // int[] prev=new int[maxWeight+1];
        
        // for(int i=weight[0];i<=maxWeight;i++){
        //     prev[i]=value[0];
        // }
        // for(int i=1;i<n;i++){
        //     int[] curr=new int[maxWeight+1];
        //     for(int j=0;j<=maxWeight;j++){
        //         int take=Integer.MIN_VALUE;
        //         if(weight[i]<=j) take=value[i]+prev[j-weight[i]];
        //         int notake=prev[j];
        //         curr[j]=Math.max(take,notake);
        //     }
        //     prev=curr;
        // }
        // return prev[maxWeight];

        //space optimization using 1array
        int[] prev=new int[maxWeight+1];
        
        for(int i=weight[0];i<=maxWeight;i++){
            prev[i]=value[0];
        }
        for(int i=1;i<n;i++){
            for(int j=maxWeight;j>=0;j--){
                int take=Integer.MIN_VALUE;
                if(weight[i]<=j) take=value[i]+prev[j-weight[i]];
                int notake=prev[j];
                prev[j]=Math.max(take,notake);
            }
        }
        return prev[maxWeight];
    }
}