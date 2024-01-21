import java.util.* ;
import java.io.*; 
public class Solution {
	public static int rec(int i,int j1,int j2,int r,int c,int[][][] dp,int [][]grid){
		if(j1<0 || j2<0 || j1>=c || j2>=c) return (int)-1e8;
		if(i==r-1){
			if(j1==j2) return grid[i][j1];
			else return grid[i][j1]+grid[i][j2];
		}
		if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
		int max=(int)-1e8;
		for(int k=-1;k<=1;k++){
			for(int l=-1;l<=1;l++){
				int value=0;
				if(j1==j2) value=grid[i][j1];
				else value=grid[i][j1]+grid[i][j2];
				value+=rec(i+1,j1+k,j2+l,r,c,dp,grid);
				max=Math.max(max,value);
			}
		}
		return dp[i][j1][j2]=max;
	}
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// int[][][] dp=new int[r][c][c];
		// for(int [][] i:dp){
		// 	for(int []j:i){
		// 		Arrays.fill(j,-1);
		// 	}
		// }
		//memoization
		//return rec(0,0,c-1,r,c,dp,grid);

		//tabulation
		int n=r,m=c;
		int[][][] dp = new int[n][m][m];
            for(int j1=0; j1<m; j1++){
                for(int j2=0; j2<m; j2++){
                    if(j1==j2) dp[n-1][j1][j2] = grid[n-1][j1];
                    else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
                }
            }
            for(int row = n-2; row>=0; row--){
                for(int j1=0; j1<m; j1++){
                    for(int j2=0; j2<m; j2++){
                        int maximumChocolates = (int)-1e8;
                        for(int di=-1; di<=1; di++){
                            for(int dj=-1; dj<=1; dj++){
                                int sum = 0;
                                if(j1==j2){
                                    sum = grid[row][j1];
                                    if(j1+di>=0 && j1+di<m && j2+dj>=0 && j2+dj<m){
                                        sum += dp[row+1][j1+di][j2+dj];
                                    }else{
                                        sum += (int)-1e8;
                                    }
                                }else{
                                    sum = grid[row][j1] + grid[row][j2];
                                    if(j1+di>=0 && j1+di<m && j2+dj>=0 && j2+dj<m){
                                        sum += dp[row+1][j1+di][j2+dj];
                                    }else{
                                        sum += (int)-1e8;
                                    }
                                }
                                maximumChocolates = Math.max(maximumChocolates, sum);
                            }
                        }                    
                        dp[row][j1][j2] = maximumChocolates;
                    }
                }
            }
            return dp[0][0][m-1];
	}
}