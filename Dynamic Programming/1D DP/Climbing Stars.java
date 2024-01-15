import java.util.* ;
import java.io.*; 

//Memoization
public class Solution {
    public static int rec(int n,long s,int[] dp){
        if(n>s) return 0;
        if(dp[n]!=-1) return dp[n];
        if(n==s) return 1;

        int l=rec(n+1,s,dp);
        int r=rec(n+2,s,dp);
        dp[n]=(l+r)%1000000007;
        return dp[n];
    }
	public static int countDistinctWayToClimbStair(long nStairs) {
        int []dp=new int[(int)nStairs+1];
        Arrays.fill(dp,-1);
		return rec(0,nStairs,dp);
	}
}

//Dynamic programming
 public class Solution {
	public static final int MOD = 1000000007;
	public static long countDistinctWayToClimbStair(long nStairs) {
		if (nStairs == 0 || nStairs == 1)
			return 1;
		long dp[] = new long[(int) (nStairs + 1)];
		dp[0] = 1;
		dp[1] = 1;
		for (int currStep = 2; currStep <= nStairs; currStep++) {
			dp[currStep] = (dp[currStep - 1] + dp[currStep - 2]) % MOD;
		}
		return dp[(int) nStairs];
	}
}