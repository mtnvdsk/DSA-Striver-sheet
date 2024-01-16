import java.util.*;

//memoization
public class Solution {
    public static int rec(int n,int k,int []height,int[] dp){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int msteps=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(n-i>=0){
                int l=rec(n-i,k,height,dp)+Math.abs(height[n]-height[n-i]);
                msteps=Math.min(msteps,l);
            }
        }
        return dp[n]=msteps;
    }
    public static int minimizeCost(int n, int k, int []height){
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return rec(n-1,k,height,dp);
        
    }
}

//tabulation
import java.util.*;
public class Solution {
    public static int minimizeCost(int n, int k, int []height){
        int []dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<n;i++){
            int m=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                    int l=dp[i-j]+Math.abs(height[i]-height[i-j]);
                    m=Math.min(m,l);
                }
            }
            dp[i]=m;
        }
        return dp[n-1];
        
    }
}