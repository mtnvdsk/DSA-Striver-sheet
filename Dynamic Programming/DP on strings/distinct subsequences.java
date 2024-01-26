import java.util.*;
public class Solution {
    public static int rec(String s1,String s2,int i,int j,int [][]dp){
        int mod=1000000007;
        if(j==0) return 1;
        if(i==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=(rec(s1,s2,i-1,j-1,dp)+rec(s1,s2,i-1,j,dp))%mod;
        return dp[i][j]=rec(s1,s2,i-1,j,dp)%mod;
    }
    public static int distinctSubsequences(String str, String sub) {
        int n=str.length();
        int m=sub.length();
        int mod=1000000007;
        int[][] dp=new int[n+1][m+1];
        // for(int []i:dp){
        //     Arrays.fill(i,-1);
        // }
        // return rec(str,sub,n,m,dp);

        //tabulation
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i-1)==sub.charAt(j-1)) dp[i][j]=(dp[i-1][j]+dp[i-1][j-1])%mod;
                else dp[i][j]=dp[i-1][j]%mod;
            }
        }
        //return dp[n][m];

        //space optimization
        int[] prev=new int[m+1];
        prev[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(str.charAt(i-1)==sub.charAt(j-1)) prev[j]=(prev[j]+prev[j-1])%mod;
            }
        }
        return prev[m];
    }
}