import java.util.Arrays;

public class Solution {
    static int mod = 1000000007;

    public static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] dp) {
        // Base case 1: When the start index is greater than the end index, no ways to evaluate.
        if (i > j) {
            return 0;
        }
        // Base case 2: When the start and end indices are the same.
        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        if (dp[i][j][isTrue] != null) {
            return dp[i][j][isTrue];
        }

        long ways = 0;
        for (int ind = i + 1; ind <= j - 1; ind += 2) {
            long lT = evaluateExpressionWays(exp, i, ind - 1, 1, dp);
            long lF = evaluateExpressionWays(exp, i, ind - 1, 0, dp);
            long rT = evaluateExpressionWays(exp, ind + 1, j, 1, dp);
            long rF = evaluateExpressionWays(exp, ind + 1, j, 0, dp);

            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % mod) % mod;
                } else {
                    ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) % mod) % mod;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lT * rT) % mod) % mod;
                } else {
                    ways = (ways + (lF * rF) % mod) % mod;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % mod + (lT * rF) % mod) % mod;
                } else {
                    ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
                }
            }
        }

        dp[i][j][isTrue] = ways;
        return ways;
    }

    public static int evaluateExp(String exp) {
        int n = exp.length();
        long[][][] dp = new long[n][n][2];
        //return (int) evaluateExpressionWays(exp, 0, n - 1, 1, dp);


        //tabulation
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                if (i > j) continue;
                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    // Base case 1:
                    if (i == j) {
                        if (isTrue == 1) dp[i][j][isTrue] = exp.charAt(i) == 'T' ? 1 : 0;
                        else dp[i][j][isTrue] = exp.charAt(i) == 'F' ? 1 : 0;
                        continue;
                    }

                    // Recurrence logic:
                    long ways = 0;
                    for (int ind = i + 1; ind <= j - 1; ind += 2) {
                        long lT = dp[i][ind - 1][1];
                        long lF = dp[i][ind - 1][0];
                        long rT = dp[ind + 1][j][1];
                        long rF = dp[ind + 1][j][0];

                        char operator = exp.charAt(ind);
                        if (operator == '&') {
                            if (isTrue == 1) ways = (ways + (lT * rT) % mod) % mod;
                            else ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lF * rF) % mod) % mod;
                        } else if (operator == '|') {
                            if (isTrue == 1) ways = (ways + (lF * rT) % mod + (lT * rF) % mod + (lT * rT) % mod) % mod;
                            else ways = (ways + (lF * rF) % mod) % mod;
                        } else {
                            if (isTrue == 1) ways = (ways + (lF * rT) % mod + (lT * rF) % mod) % mod;
                            else ways = (ways + (lF * rF) % mod + (lT * rT) % mod) % mod;
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return (int)dp[0][n - 1][1];
    }
}
