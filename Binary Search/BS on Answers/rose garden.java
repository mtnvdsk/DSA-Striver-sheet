public class Solution {
    public static int max(int[] a) {
        int h = Integer.MIN_VALUE;
        for (int i : a) {
            h = Math.max(h, i);
        }
        return h;
    }

    public static boolean verify(int[] bloomDay, int m, int k, int mid) {
        int count = 0;
        int consecutiveCount = 0;

        for (int day : bloomDay) {
            if (day <= mid) {
                consecutiveCount++;
                if (consecutiveCount == k) {
                    count++;
                    consecutiveCount = 0;
                }
            } else {
                consecutiveCount = 0;
            }
        }

        return count >= m;
    }

    public static int bs(int[] a, int k, int b) {
        if (b*k > a.length) {
            return -1; 
        }
        int low = 1;
        int high = max(a);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (verify(a,b,k,mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int roseGarden(int[] arr, int r, int b) {
        return bs(arr, r, b);
    }
}
