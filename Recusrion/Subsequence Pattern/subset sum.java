//recusrion
public class Solution {
    public static boolean rec(int n,int k,int []a,int sum,int i){
        if(i==n){
            if(sum==k){
                return true;
            }
            return false;
        }
        if(rec(n,k,a,sum+a[i],i+1)) return true;
        if(rec(n,k,a,sum,i+1)) return true;
        return false;
    }
    public static boolean isSubsetPresent(int n, int k,int []a) {
        return rec(n,k,a,0,0);
    } 
}

//dp
import java.util.Arrays;

public class Solution {
    public static boolean rec(int n, int k, int[] a, int sum, int i, Boolean[][] dp) {
        if (i == n) {
            return sum == k;
        }
        if(sum>k) return false;
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        boolean include = rec(n, k, a, sum + a[i], i + 1, dp);
        boolean exclude = rec(n, k, a, sum, i + 1, dp);

        dp[i][sum] = include || exclude;

        return dp[i][sum];
    }

    public static boolean isSubsetPresent(int n, int k, int[] a) {
        Boolean[][] dp = new Boolean[n + 1][k + 1];
        return rec(n, k, a, 0, 0, dp);
    }
}
