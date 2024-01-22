import java.util.*;
import java.io.*;

public class Solution {
    public static int rec(int[] num,int tar,int i,int[][] dp){
        if(tar==0) return 1;
        if(i==0){
            if(tar==num[0]) return 1;
            return 0;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int nottake=rec(num,tar,i-1,dp);
        int pick=0;
        if(num[i]<=tar){
            pick=rec(num,tar-num[i],i-1,dp);
        }
        return dp[i][tar]=pick+nottake;
    }
    public static int findWays(int num[], int tar) {
        int n=num.length;
        int mod=1000000007;
        int[][] dp=new int[n][tar+1];
        // for(int i[]:dp){
        //     Arrays.fill(i,-1);
        // }
        //return rec(num,tar,n-1,dp);
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        if(num[0]<=tar){
            dp[0][num[0]]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=tar;j++){
                int pick=0;
                if(num[i]<=j){
                    pick=dp[i-1][j-num[i]];
                }
                int notpick=dp[i-1][j];
                dp[i][j]=(pick+notpick)%mod;
            }
        }
        return dp[n-1][tar]%mod;
    }
}