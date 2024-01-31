import java.util.*;
public class Solution {
    public static int rec(int i, String str, int n,int[] dp) {
        if (i == n) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i]!=-1) return dp[i];
        for (int j = i; j <n; j++) {
            if (isPalindrome(i,j,str)) {
                int cost = 1 + rec(j+1, str, n,dp);
                min = Math.min(min, cost);
            }
        }
        return dp[i]=min;
    }

    public static boolean isPalindrome(int left,int right,String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }

    public static int palindromePartitioning(String str) {
        int n=str.length();
        int[] dp=new int[n+1];
        // Arrays.fill(dp,-1);
        // return rec(0, str, str.length(),dp)-1;

        //tabulation
        for(int i=n-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for (int j = i; j <n; j++) {
                if (isPalindrome(i,j,str)) {
                    int cost = 1 +dp[j+1];
                    min = Math.min(min, cost);
                }
            }
            dp[i]=min;
        }

        return dp[0]-1;
    }
}
