import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
        n = arr.length;
        long  ms = Integer.MIN_VALUE;
        long  cs = 0;
        for (int i = 0; i < n; i++) {
            cs = cs + arr[i]; 
            if(cs < 0)
            {
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }
        return ms;
    }

}
