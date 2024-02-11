public class Solution {
    public static int bs(int[] a, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                return bs(a, mid + 1, high, target);
            } else {
                return bs(a, low, mid - 1, target);
            }
        }
        return low; // Return low instead of high
    }
    public static int searchInsert(int [] arr, int m){
        return bs(arr,0,arr.length-1,m);
    }
}