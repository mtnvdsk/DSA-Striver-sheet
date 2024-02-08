public class Solution {
    public static int bs(int[] a, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= target) {
                return bs(a, mid + 1, high, target);
            } else {
                return bs(a, low, mid - 1, target);
            }
        }
        return low;
    }
    public static int upperBound(int[] arr, int x, int n) {
        return bs(arr, 0, n - 1, x);
    }
}
