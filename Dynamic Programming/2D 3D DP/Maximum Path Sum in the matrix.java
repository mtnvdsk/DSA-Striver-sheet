import java.util.*;
import java.io.*;

public class Solution {
    public static int getMaxUtil(int i, int j, int m, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= m)
            return (int) Math.pow(-10, 9);
        if (i == 0)
            return matrix[0][j];

        if (dp[i][j] != -1)
            return dp[i][j];
        int up = matrix[i][j] + getMaxUtil(i - 1, j, m, matrix, dp);
        int leftDiagonal = matrix[i][j] + getMaxUtil(i - 1, j - 1, m, matrix, dp);
        int rightDiagonal = matrix[i][j] + getMaxUtil(i - 1, j + 1, m, matrix, dp);
        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }

		public static int getMaxPathSum(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		// for (int[] row : dp) {
		// 	Arrays.fill(row, -1);
		// }
		
		//memoization
		// int max = Integer.MIN_VALUE;
		// for (int i = 0; i < m; i++) {
		// 	max = Math.max(max, getMaxUtil(n - 1, i, m, matrix, dp));
		// }
		//return max;

		//tabulation
		for(int i=0;i<m;i++) dp[0][i]=matrix[0][i];
		for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(-10, 9);
                }
                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
	}
}
