public class Solution {
    public static int subarrayWithSum(int []arr, int k) {
        int res = 0;
        int cnt = 0;
        int []prefix = new int[arr.length + 1];
        prefix[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            cnt += arr[i];
            if (cnt >= k) {
                res += prefix[cnt - k];
            }
            prefix[cnt]++;
        }

        return res;
    }
}
