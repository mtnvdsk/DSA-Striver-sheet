import java.util.* ;
import java.io.*; 
public class Solution {
    //Memorization
    // public static int rec(int n,int[] heights,int []dp){
    //     if(n==0) return 0;
    //     if(dp[n]!=-1) return dp[n];
    //     int left=rec(n-1,heights,dp)+Math.abs(heights[n]-heights[n-1]);
    //     int right=Integer.MAX_VALUE;
    //     if(n>1){
    //         right=rec(n-2,heights,dp)+Math.abs(heights[n]-heights[n-2]);
    //     }
    //     return dp[n]=Math.min(left,right);
    // }
    //tabulation
    public static int frogJump(int n, int heights[]) {
        // int[] dp=new int[n];
        // Arrays.fill(dp,0);
        // dp[0]=0;
        // for(int i=1;i<n;i++){
        //     int left=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
        //     int right=Integer.MAX_VALUE;
        //     if(i>1){
        //         right=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
        //     }
        //     dp[i]=Math.min(left,right);
        // }
        // return dp[n-1];
        //return rec(n-1,heights,dp);
        
        
        //tabulation with memory optimized
        int prev=0,prev2=0;
        for(int i=1;i<n;i++){
            int left=prev+Math.abs(heights[i]-heights[i-1]);
            int right=Integer.MAX_VALUE;
            if(i>1){
                right=prev2+Math.abs(heights[i]-heights[i-2]);
            }
            int curr=Math.min(left,right);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }

}