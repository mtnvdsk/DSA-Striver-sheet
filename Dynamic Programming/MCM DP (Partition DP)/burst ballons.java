import java.util.*;
public class Solution {
    public static int rec(int i,int j,int []arr,int[][] dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max=(int)-1e9;
        for(int k=i;k<=j;k++){
            int cost=(arr[i-1]*arr[k]*arr[j+1])+rec(i,k-1,arr,dp)+rec(k+1,j,arr,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
    public static int burstBalloons(int []arr){
        int n=arr.length;
        int[] tmp=new int[n+2];
        System.arraycopy(arr,0,tmp,1,n);
        tmp[0]=1;
        tmp[tmp.length-1]=1;
        int[][] dp=new int[n+2][n+2];
        // for(int[] i:dp) Arrays.fill(i,-1);
        // return rec(1,n,tmp,dp);

        //tabulation
        n=tmp.length;
        for(int i=n-2;i>=1;i--){
            for(int j=1;j<=n-2;j++){
                if(i>j) continue;
                int max=(int)-1e9;
                for(int k=i;k<=j;k++){
                    int cost=(tmp[i-1]*tmp[k]*tmp[j+1])+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(max,cost);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n-2];
    }
}