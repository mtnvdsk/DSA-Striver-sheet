import java.util.*;
public class Solution {
    public static long rec(int i, int n, long[] values, long[][] dp, int buy) {
        if (i == n) return 0;
        if (dp[i][buy] != -1) return dp[i][buy];

        if (buy == 0) {
            return dp[i][buy] = Math.max(-values[i] + rec(i + 1, n, values, dp, 1), rec(i + 1, n, values, dp, 0));
        } else {
            return dp[i][buy] = Math.max(values[i] + rec(i + 1, n, values, dp, 0), rec(i + 1, n, values, dp, 1));
        }
    }

    public static long getMaximumProfit(int n, long[] values) {
        //long[][] dp = new long[n][2];
        // for (long[] i : dp) Arrays.fill(i, -1);
        // return rec(0, n, values, dp, 0);

        //tabulation
        long[][] dp = new long[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                long profit=0;
                if (buy==1) {
                    profit = Math.max(-values[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    profit = Math.max(values[i] + dp[i + 1][1], dp[i + 1][0]);
                }
                dp[i][buy]=profit;
            }
        }
        //return dp[0][1];

        //space optimization
        long[] ahead=new long[2];
        ahead[0]=ahead[1]=0;
        for (int i = n - 1; i >= 0; i--) {
            long[] curr=new long[2];
            for (int buy = 0; buy <= 1; buy++) {
                long profit=0;
                if (buy==1) {
                    profit = Math.max(-values[i] + ahead[0], ahead[1]);
                } else {
                    profit = Math.max(values[i] + ahead[1], ahead[0]);
                }
                curr[buy]=profit;
            }
            ahead=curr;
        }
        return ahead[1];
    }
}
