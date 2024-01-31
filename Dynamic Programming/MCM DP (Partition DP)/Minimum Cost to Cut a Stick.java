import java.util.Arrays;

class Solution {
    public int rec(int i, int j, int[] cuts, int[][] memo) {
        if (i + 1 == j) return 0;

        if (memo[i][j] != 0) return memo[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = cuts[j] - cuts[i] + rec(i, k, cuts, memo) + rec(k, j, cuts, memo);
            min = Math.min(min, cost);
        }

        memo[i][j] = min;
        return min;
    }

    public int minCost(int n, int[] cuts) {
        // Arrays.sort(cuts);
        // int[] extendedCuts = new int[cuts.length + 2];
        // System.arraycopy(cuts, 0, extendedCuts, 1, cuts.length);
        // extendedCuts[0] = 0;
        // extendedCuts[extendedCuts.length - 1] = n;

        //int[][] memo = new int[extendedCuts.length][extendedCuts.length];

        //return rec(0, extendedCuts.length - 1, extendedCuts, memo);

        //trabulation
        Arrays.sort(cuts);
        int[] tmp = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, tmp, 1, cuts.length);
        tmp[0] = 0;
        tmp[tmp.length - 1] = n;
        n = tmp.length;
        int dp[][] = new int[n + 1][n + 1];

        for (int i = n - 2; i >= 1; i--) {
            for (int j = i; j <= n-2 ; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    mini = Math.min(mini, tmp[j + 1] - tmp[i - 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n - 2];
    }
}
