class Solution {
    public int rec(String s1,String s2,int i,int j,int[][] dp){
        if(j==0) return i;
        if(i==0) return j;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1)) return dp[i][j]=rec(s1,s2,i-1,j-1,dp);
        int update=1+rec(s1,s2,i-1,j-1,dp);
        int delete=1+rec(s1,s2,i-1,j,dp);
        int insert=1+rec(s1,s2,i,j-1,dp);
        return dp[i][j]=Math.min(insert,Math.min(delete,update));
    }
    public int minDistance(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        //return rec(s1,s2,n-1,m-1,dp);

        //tabulation
        // for(int i=1;i<=n;i++){
        //     dp[i][0]=i;
        // }
        // for(int j=0;j<=m;j++){
        //     dp[0][j]=j;
        // }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(s1.charAt(i-1)==s2.charAt(j-1)){
        //             dp[i][j]=dp[i-1][j-1];
        //         }
        //         else{
        //             int update=1+dp[i-1][j-1];
        //             int delete=1+dp[i-1][j];
        //             int insert=1+dp[i][j-1];
        //             dp[i][j]=Math.min(insert,Math.min(update,delete));
        //         }
        //     }
        // }
        // return dp[n][m];


        int[] prev=new int[m+1];
        for(int i=0;i<=m;i++) prev[i]=i;
        
        for(int i=1;i<=n;i++){
            int[] curr=new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }
                else{
                    int update=1+prev[j-1];
                    int delete=1+prev[j];
                    int insert=1+curr[j-1];
                    curr[j]=Math.min(insert,Math.min(update,delete));
            }
        }
        prev=curr;
    }
    return prev[m];
}
}