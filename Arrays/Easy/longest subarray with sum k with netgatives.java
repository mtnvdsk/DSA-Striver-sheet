import java.util.*;
public class Solution {

    public static int getLongestSubarray(int []nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int ans = 0;
        int sum = 0;
        prefixSumMap.put(0,-1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (prefixSumMap.containsKey(sum-k)) {
                ans = Math.max(ans, i - prefixSumMap.get(sum - k));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum,i);
            }
        }
        return ans;
    }
}
