public class Solution {
    public static int longestSubarrayWithSumK(int[] a, long k) {
        int n = a.length;
        int max = 0;
        long sum = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {
            sum += a[j];

            while (sum > k) {
                sum -= a[i];
                i++;
            }
            if (sum == k) {
                max = Math.max(max, j - i + 1);
            }
        }

        return max;
    }
}
