import java.util.* ;
import java.io.*; 
public class Solution {
    public static int rec(int []num,int tar,int[][] dp,int i){
        if(i==0){
            if(tar%num[i]==0) return tar/num[i];
            return (int)1e9;
        }
        if(dp[i][tar]!=-1) return dp[i][tar];
        int take=(int)1e9;
        if(num[i]<=tar) take=1+rec(num,tar-num[i],dp,i);
        int notake=rec(num,tar,dp,i-1);
        return dp[i][tar]=Math.min(take,notake);
    }
    public static int minimumElements(int num[], int x) {
        int n=num.length;
        int[][] dp=new int[n][x+1];
        // for(int i[]:dp){
        //     Arrays.fill(i,-1);
        // }
        // int ans=rec(num,x,dp,n-1);
        // return ans!=(int)1e9?ans:-1;

        //tabulation
        for(int i=0;i<=x;i++){
            if(i%num[0]==0) dp[0][i]=i/num[0];
            else dp[0][i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=x;j++){
                int take=(int)1e9;
                if(num[i]<=j) take=1+dp[i][j-num[i]];
                int notake=dp[i-1][j];
                dp[i][j]=Math.min(take,notake);
            }
        }
        //return dp[n-1][x]!=(int)1e9?dp[n-1][x]:-1;

        //space optimization

        int[] prev=new int[x+1];
        int[] curr=new int[x+1];
        for(int i=0;i<=x;i++){
            if(i%num[0]==0) prev[i]=i/num[0];
            else prev[i]=(int)1e9;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<=x;j++){
                int take=(int)1e9;
                if(num[i]<=j) take=1+curr[j-num[i]];
                int notake=prev[j];
                curr[j]=Math.min(take,notake);
            }
            prev=curr;
        }
        return prev[x]!=(int)1e9?prev[x]:-1;
    }

}