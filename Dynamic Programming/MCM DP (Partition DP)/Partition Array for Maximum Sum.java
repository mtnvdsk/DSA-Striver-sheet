import java.util.*;

public class Solution {
    public static int rec(int i, int k, int[] arr, int n, int[] dp) {
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int max = Integer.MIN_VALUE;
        int len = 0, maxans = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(n, i + k); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = (len * max) + rec(j + 1, k, arr, n, dp);
            maxans = Math.max(maxans, sum);
        }
        return dp[i] = maxans;
    }

    public static int maximumSubarray(int arr[], int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        //Arrays.fill(dp, -1);
        //return rec(0, k, arr, n, dp);

        //tabulation
        for(int i=n-1;i>=0;i--){
            int max = Integer.MIN_VALUE;
            int len = 0, maxans = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                max = Math.max(max, arr[j]);
                int sum = (len * max) + dp[j + 1];
                maxans = Math.max(maxans, sum);
            }
            dp[i] = maxans;
        }
        return dp[0];
    }
}
