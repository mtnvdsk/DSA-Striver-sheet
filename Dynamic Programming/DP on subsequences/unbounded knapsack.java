import java.util.*;
public class Solution {
    public static int rec(int i,int w,int []profit,int[] wt,int [][]dp){
        if(i==0){
            return (w/wt[0])*profit[0];
        }
        if(dp[i][w]!=-1) return dp[i][w];
        int take=Integer.MIN_VALUE;
        if(wt[i]<=w) take=profit[i]+rec(i,w-wt[i],profit,wt,dp);
        int notake=rec(i-1,w,profit,wt,dp);
        return dp[i][w]=Math.max(take,notake);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];
        // for(int []i:dp) Arrays.fill(i,-1);
        // return rec(n-1,w,profit,weight,dp);

        //tabulation

        for(int i=weight[0];i<=w;i++){
            dp[0][i]=(i/weight[0])*profit[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                int take=Integer.MIN_VALUE;
                if(weight[i]<=j) take=profit[i]+dp[i][j-weight[i]];
                int notake=dp[i-1][j];
                dp[i][j]=Math.max(take,notake);
            }
        }
        //return dp[n-1][w];

        //space optimization
        int[] prev=new int[w+1];
        int[] curr=new int[w+1];

        for(int i=weight[0];i<=w;i++){
            prev[i]=(i/weight[0])*profit[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=w;j++){
                int take=Integer.MIN_VALUE;
                if(weight[i]<=j) take=profit[i]+curr[j-weight[i]];
                int notake=prev[j];
                curr[j]=Math.max(take,notake);
            }
            prev=curr;
        }
        return prev[w];
    }
}
