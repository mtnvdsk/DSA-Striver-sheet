public class Solution {
    public static int subarrayWithMaxProduct(int []arr){
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int neg = 1, pos = 1;

        // Iterating over the ending points of subarrays of 'Arr'.
        for(int i = 0; i < n; ++i){
            int temp = pos;

            // Most positive product subarray ending at 'i'.
            pos = Math.max(Math.max(pos * arr[i], neg * arr[i]), arr[i]);

            // Most negative product subarray ending at 'i'.
            neg = Math.min(Math.min(temp * arr[i], neg * arr[i]), arr[i]);

            // Comparing the best product ending at 'i', with the best product found so far.
            ans = Math.max(ans, pos);
        }
        return ans;
    }
}

//solution2
public class Solution {
    public static int subarrayWithMaxProduct(int []arr){
        int n = arr.length; //size of array.

        int pre = 1, suff = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pre == 0) pre = 1;
            if (suff == 0) suff = 1;
            pre *= arr[i];
            suff *= arr[n - i - 1];
            ans = Math.max(ans, Math.max(pre, suff));
        }
        return ans;
	}
}