

import java.util.*;
public class Solution {
    public static List< List < Integer > > subarraysWithSumK(int []a, long k) {
        int n = a.length;
        List< List< Integer > > ans = new ArrayList<>();
        int start = 0, end = -1;
        long currentSum = 0l;
        while (start < n) {
            while ((end + 1 < n) && (currentSum + a[end + 1] <= k)) {
                currentSum += a[end + 1];
                ++end;
            }
            if (currentSum == k) {
                List< Integer > temp = new ArrayList<>();

                for(int i = start; i <= end; ++i) {
                    temp.add(a[i]);
                }
                ans.add(new ArrayList<>(temp));
            }
            currentSum -= a[start];
            ++start;
        }

        return ans;
    }
}