import java.util.*;
public class Solution {
    public static int rec(int[] prices, int i, int n, int buy, int[][] dp) {
        if (i >= n)
            return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(-prices[i] + rec(prices, i + 1, n, 1, dp), rec(prices, i + 1, n, 0, dp));
        } else {
            profit = Math.max(prices[i] + rec(prices, i + 2, n, 0, dp), rec(prices, i + 1, n, 1, dp));
        }
        return dp[i][buy] = profit;
    }
    public static int stockProfit(int[] prices) {
        int n = prices.length;
        //int[][] dp = new int[n][2];
        // for (int[] i : dp)
        //     Arrays.fill(i, -1);
        //return rec(prices, 0, n, 0, dp);

        //tabulation
        int[][] dp = new int[n + 2][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    dp[i][buy] = Math.max(-prices[i] + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    dp[i][buy] = Math.max(prices[i] + dp[i + 2][0], dp[i + 1][1]);
                }
            }
        }
        //return dp[0][0];

        //space complexity
        int[] f1=new int[2];
        int[] curr=new int[2];
        int[] f2=new int[2];
        for (int i = n - 1; i >= 0; i--) {
            curr[1] = Math.max(-prices[i] + f1[0], f1[1]);
            curr[0] = Math.max(prices[i] + f2[1], f1[0]);
            System.arraycopy(f1, 0, f2, 0, 2);
            System.arraycopy(curr, 0, f1, 0, 2);
        }
        return curr[1];
    }
}
