public class Solution {
    public static double myPow(double x, int n) {
        if(n < 0) return 1 / po(x, -1*n);
        return po(x, n);
    }

    static double po(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        double half = po(x, n/2);
        if(n % 2 == 0) {
            return half * half;
        }
        else {
            return x * half * half;
        }
    }
}