import java.util.* ;
import java.io.*; 
public class Solution {

    public static int rec(int[][] triangle, int i,int j,int n,int[][] dp){
        if(i==n-1) return triangle[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down=triangle[i][j]+rec(triangle,i+1,j,n,dp) ;
        int diag=triangle[i][j]+rec(triangle,i+1,j+1,n,dp);
        return dp[i][j]=Math.min(down,diag);
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        int [][]dp=new int[n][n];
        for(int []i:dp){
            Arrays.fill(i,-1);
        }
        // memoization
        //return rec(triangle,0,0,n,dp);

        //tabulation
        // for(int i=0;i<n;i++){
        //     dp[n-1][i]=triangle[n-1][i];
        // }
        // for(int i=n-2;i>=0;i--){
        //     for(int j=i;j>=0;j--){
        //         int diag=triangle[i][j]+dp[i+1][j+1];
        //         int down=triangle[i][j]+dp[i+1][j];
        //         dp[i][j]=Math.min(down,diag);
        //     }
        // }
        // return dp[0][0];

        //space optimization
        int prev[]=new int[n];
        for(int i=0;i<n;i++){
            prev[i]=triangle[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            int curr[]=new int[n];
            for(int j=i;j>=0;j--){
                int diag=triangle[i][j]+prev[j+1];
                int down=triangle[i][j]+prev[j];
                curr[j]=Math.min(diag,down);
            }
            prev=curr;
        }
        return prev[0];

    }
}