import java.util.* ;
public class Solution {
     static boolean check(String a,String b){
        int n = a.length();
        int m = b.length();
        if(Math.abs(n-m)!=1) return false;
           if(n>m){
                int i=0,j=0;
                while(i<n && j<m){
                    if(a.charAt(i)==b.charAt(j)){
                        i++;
                        j++;
                    }
                    else{
                        i++;
                    }
                }
                if((i==n && j==m) || (i+1==n && j==m)) return true;
           }
           return false;
    }
    public static int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int [] dp = new int[n];
        int maxi = 0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(check(words[i],words[j])){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                    }
                }
            }
            maxi = Math.max(dp[i],maxi);
        }
        return maxi;
    }
}