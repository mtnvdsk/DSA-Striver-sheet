public class Solution {
    public static int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int l = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < l) {
                l = arr[mid];
            }
            if (arr[mid] < arr[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return l;
    }
}
