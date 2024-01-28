import java.util.*;

public class Solution {
    static int getAns(int[] Arr, int n, int ind, int k, int cap, int[][] dp) {
        if (ind == n || cap == 2 * k)
            return 0;
        if (dp[ind][cap] != -1)
            return dp[ind][cap];
        
        int profit = 0;
        
        if (cap % 2 == 0) {
            profit = Math.max(0 + getAns(Arr, n, ind + 1, k, cap, dp),
                    -Arr[ind] + getAns(Arr, n, ind + 1, k, cap + 1, dp));
        } else {
            profit = Math.max(0 + getAns(Arr, n, ind + 1, k, cap, dp),
                    Arr[ind] + getAns(Arr, n, ind + 1, k, cap + 1, dp));
        }
        
        return dp[ind][cap] = profit;
    }

    public static int maximumProfit(int[] prices, int n, int k) {
        int[][] dp = new int[n+1][2*k+1];
        // for (int i = 0; i <= n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        //memoization
        //return getAns(prices, n, 0, k, 0, dp);

        //tabulation
        for (int i = n - 1; i >= 0; i--) {
        for (int cap = 2 * k - 1; cap >= 0; cap--) {
            if (cap % 2 == 0) {
                dp[i][cap] = Math.max(-prices[i] + dp[i + 1][cap+1], dp[i + 1][cap]);
            } else {
                dp[i][cap] = Math.max(prices[i] + dp[i + 1][cap+1], dp[i + 1][cap]);
                }
            }
        }

        //return dp[0][0];

        //space optimization
        int[] prev=new int[2*k+1];
        for (int i = n - 1; i >= 0; i--) {
            int[] curr=new int[2*k+1];
        for (int cap = 2 * k - 1; cap >= 0; cap--) {
            if (cap % 2 == 0) {
                curr[cap] = Math.max(-prices[i] + prev[cap+1], prev[cap]);
            } else {
                curr[cap] = Math.max(prices[i] + prev[cap+1], prev[cap]);
                }
            }
            prev=curr;
        }
        return prev[0];
    }

}
