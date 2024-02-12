import java.util.ArrayList;

public class Solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                // If the current element is greater than the next element, a peak exists to the left.
                high = mid;
            } else {
                // If the current element is not greater than the next element, a peak exists to the right.
                low = mid + 1;
            }
        }
        return low;
    }
}