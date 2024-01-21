import java.util.Arrays;

public class Solution {
    public static boolean rec(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (i == 0) return arr[0] == target;
        if (dp[i][target] != -1) return (dp[i][target]==0)?false:true;
        boolean take = false;
        if (arr[i] <= target)
            take = rec(i - 1, target - arr[i], arr, dp);
        boolean nottake = rec(i - 1, target, arr, dp);
        dp[i][target] = (take || nottake) ? 1 : 0;
        return take || nottake;
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {
        int[][] dp = new int[n][k + 1];
        // for (int i[] : dp) {
        //     Arrays.fill(i, -1);
        // }
        //memoization
        //return rec(n - 1, k, arr, dp);

        //tabulation

        for (int i = 0; i <n; i++) {
            dp[i][0] = 1;
        }
        if(arr[0]<=k)
            dp[0][arr[0]]=1;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) { 
                boolean take = false;
                if (arr[i] <= j) {
                    take = (dp[i - 1][j - arr[i]] == 1); 
                }
                boolean nottake = (dp[i - 1][j] == 1);
                dp[i][j] = (take || nottake) ? 1 : 0;
            }
        }
        return dp[n - 1][k] == 1;

    }
}
