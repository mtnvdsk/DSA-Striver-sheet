package Learning;
public class Solution {
    public static int countingGraphs(int N) {
        int a=(N*(N-1))/2;
        return (int)Math.pow(2,a);
    }
}