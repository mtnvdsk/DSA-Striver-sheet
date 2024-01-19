import java.util.* ;
import java.io.*; 
public class Solution {
    public static int rec(int n,int m,int [][]grid,int [][]dp){
        if(n==0 && m==0) return grid[n][m];
        if(n<0 || m<0) return Integer.MAX_VALUE;
        if(dp[n][m]!=-1) return dp[n][m];
        dp[n][m]=grid[n][m]+Math.min(rec(n-1,m,grid,dp),rec(n,m-1,grid,dp));
        return dp[n][m];
    }
    public static int minSumPath(int[][] grid) {
    	int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }

        //memoization
        //return rec(n-1,m-1,grid,dp);


        //tabulation
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         dp[i][j]=grid[i][j];
        //         if(i>0 && j>0){
        //             dp[i][j]+=Math.min(dp[i-1][j],dp[i][j-1]);
        //         }
        //         else if(i>0 && j<=0){
        //             dp[i][j]+=dp[i-1][j];
        //         }
        //         else if(j>0 && i<=0){
        //             dp[i][j]+=dp[i][j-1];
        //         }
        //     }
        // }
        // return dp[n-1][m-1];

        //space optimization
        int prev[]=new int[m];
        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                temp[j]=grid[i][j];
                if(i>0 && j>0){
                    temp[j]+=Math.min(prev[j],temp[j-1]);
                }
                else if(i>0 && j<=0){
                    temp[j]+=prev[j];
                }
                else if(j>0 && i<=0){
                    temp[j]+=temp[j-1];
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }
}