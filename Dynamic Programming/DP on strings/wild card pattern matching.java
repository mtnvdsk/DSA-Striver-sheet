public class Solution {
	public static boolean rec(String s1,String s2,int i,int j,boolean[][] dp){
		if(i==0 && j==0) return true;
		if(i>0 && j==0){
			for(int k=1;k<=i;k++){
				if(s1.charAt(k-1)!='*') return false;
			}
			return true;
		}
		if(j>0 && i==0) return false;
		if(dp[i][j]) return dp[i][j];
		if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
			return dp[i][j]=rec(s1,s2,i-1,j-1,dp);
		}
		else if(s1.charAt(i-1)=='*'){
			return dp[i][j]=rec(s1,s2,i-1,j,dp) || rec(s1,s2,i,j-1,dp);
		}
		return dp[i][j]=false;
	}
	public static boolean wildcardMatching(String s1, String s2) {
		int n=s1.length();
		int m=s2.length();

		boolean[][] dp=new boolean[n+1][m+1];
		//return rec(s1,s2,n,m,dp);

		//tabulation
		dp[0][0]=true;
		for(int i=1;i<m;i++){
			dp[0][i]=false;
		}
		for(int i=1;i<=n;i++){
			boolean flag=true;
			for(int k=1;k<=i;k++){
				if(s1.charAt(k-1)!='*') flag=false;
			}
			dp[i][0]=flag;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
					dp[i][j]=dp[i-1][j-1];
				}
				else if(s1.charAt(i-1)=='*'){
					dp[i][j]=dp[i-1][j] || dp[i][j-1];
				}
				else dp[i][j]=false;
			}
		}
		//return dp[n][m];

		//space optimization
		boolean[] prev=new boolean[m+1];
		prev[0]=true;
		for(int i=1;i<m;i++){
			prev[i]=false;
		}
		for(int i=1;i<=n;i++){
			boolean[] curr=new boolean[m+1];
			boolean flag=true;
			for(int k=1;k<=i;k++){
				if(s1.charAt(k-1)!='*'){
					flag=false;
					break;
				}
			}
			curr[0]=flag;
			for(int j=1;j<=m;j++){
				if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
					curr[j]=prev[j-1];
				}
				else if(s1.charAt(i-1)=='*'){
					curr[j]=prev[j] || curr[j-1];
				}
				else curr[j]=false;
			}
			prev=curr;
		}
		return prev[m];
	}
}
