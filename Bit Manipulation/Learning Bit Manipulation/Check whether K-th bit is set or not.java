public class Solution {
    static boolean isKthBitSet(int n, int k) {
        int a = n & (1 << (k - 1));
        return a != 0;
    }
}
