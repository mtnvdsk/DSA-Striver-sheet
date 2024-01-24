import java.util.*;
public class Solution {
	public static int rec(int i,int j,String s,String t,int[][] dp){
		if(i==0 || j==0){
			return 0;
		}
		if(dp[i][j]!=-1) return dp[i][j];
		if(s.charAt(i-1)==(t.charAt(j-1))) dp[i][j]=1+rec(i-1,j-1,s,t,dp);
		return dp[i][j]=Math.max(rec(i-1,j,s,t,dp),rec(i,j-1,s,t,dp));
	}

	public static int lcs(String s, String t) {
		int n=s.length();
		int m=t.length();
		int[][] dp=new int[n+1][m+1];
		//for(int[] i:dp) Arrays.fill(i,-1);
		//memoization
		//return rec(n,m,s,t,dp);

		//tabulation
		for(int i=0;i<=n;i++){
			dp[i][0]=0;
		}
		for(int i=0;i<=m;i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1)==(t.charAt(j-1))) dp[i][j]=1+dp[i-1][j-1];
				else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		//return dp[n][m];
		
		//space optimization
		int[] prev=new int[m+1];
		int[] curr=new int[m+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s.charAt(i-1)==(t.charAt(j-1))) curr[j]=1+prev[j-1];
				else curr[j]=Math.max(prev[j],curr[j-1]);
			}
			int[] temp=prev;
			prev=curr;
			curr=temp;
		}
		return prev[m];
    }
}