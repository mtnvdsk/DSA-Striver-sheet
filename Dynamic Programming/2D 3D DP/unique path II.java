import java.util.*;
public class Solution {
    static int rec(int n,int m,ArrayList<ArrayList<Integer>> mat,int[][] dp){
        int mod=1000000007;
        if(n==0 && m==0) return 1;
        if(dp[n][m]!=-1) return dp[n][m];
        int left=0,right=0;
        if(m>0 && mat.get(n).get(m-1)!=-1) left=rec(n,m-1,mat,dp)%mod;
        if(n>0 && mat.get(n-1).get(m)!=-1) right=rec(n-1,m,mat,dp)%mod;
        return dp[n][m]=(left+right)%mod;
    }
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        //memoization
        // int[][] dp=new int[n][m];
        // for(int[] i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return rec(n-1,m-1,mat,dp);
        
        
        //tabulation
        // int mod=1000000007;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(i==0 && j==0) dp[i][j]=1;
        //         else{
        //             int left=0,up=0;
        //             if(i>0 && mat.get(i-1).get(j)!=-1) up=dp[i-1][j]%mod;
        //             if(j>0 && mat.get(i).get(j-1)!=-1) left=dp[i][j-1]%mod;
        //             dp[i][j]=(left+up)%mod;
        //         }
        //     }
        // }
        // return dp[n-1][m-1]%mod;

        //space optimization

        int mod=1000000007;
        int[] prev=new int[m];
        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[j]=1;
                }
                else{
                    int left=0,up=0;
                    if(i>0 && mat.get(i-1).get(j)!=-1) up=prev[j]%mod;
                    if(j>0 && mat.get(i).get(j-1)!=-1) left=temp[j-1]%mod;
                    temp[j]=(left+up)%mod;
                }
            }
            prev=temp;
        }
        return prev[m-1];
    }

}
