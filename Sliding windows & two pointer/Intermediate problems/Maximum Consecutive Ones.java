import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		int l = 0;
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (arr.get(right) == 0) {
                count++;
            }
            while (count > k) {
                if (arr.get(left) == 0) {
                    count--;
                }
                left++;
            }
            l = Math.max(l, right - left + 1);
        }
        return l;
	}
}