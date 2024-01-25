public class Solution {
    public static int lcs(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        //int ans=0;
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(str1.charAt(i-1)==str2.charAt(j-1)){
        //             dp[i][j]=1+dp[i-1][j-1];
        //             ans=Math.max(ans,dp[i][j]);
        //         } 
        //         else dp[i][j]=0;
        //     }
        // }
        //return ans;

        //space optimization
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                    ans=Math.max(ans,curr[j]);
                } 
                else curr[j]=0;
            }
            int[] temp=prev;
            prev=curr;
            curr=temp;
        }
        return ans;
    }
}
