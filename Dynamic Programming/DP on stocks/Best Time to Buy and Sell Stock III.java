import java.util.Arrays;

public class Solution {
    static int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {
        if (ind == n || cap == 0)
            return 0;
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        int profit = 0;
        if (buy == 0) {
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 0, cap, dp),
                    -Arr[ind] + getAns(Arr, n, ind + 1, 1, cap, dp));
        }
        if (buy == 1) {
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 1, cap, dp),
                    Arr[ind] + getAns(Arr, n, ind + 1, 0, cap - 1, dp));
        }
        return dp[ind][buy][cap] = profit;
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j < 2; j++) {
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        //return getAns(prices, n, 0, 0, 2, dp);

        //tabulation
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][1][cap],-prices[ind] + dp[ind + 1][0][cap]);
                    }
                    else{
                        dp[ind][buy][cap] = Math.max(dp[ind + 1][0][cap],prices[ind] + dp[ind + 1][1][cap - 1]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
