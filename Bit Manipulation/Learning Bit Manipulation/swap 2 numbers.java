public class Solution{
    public static void swapNumber(int []a, int []b) {
        a[0]=a[0]^b[0];
        b[0]=b[0]^a[0];
        a[0]=a[0]^b[0];
    }
}