import java.util.LinkedList;
import java.util.Queue;

class pair{
	int i,j,t;
	pair(int i,int j,int t){
		this.i=i;
		this.j=j;
		this.t=t;
	}
}
public class Solution {
	public static int minTimeToRot(int[][] grid, int n, int m) {
		int [][]vis=new int[n][m];
		int c=0;
		Queue<pair> temp=new LinkedList<pair>();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==2){
					temp.add(new pair(i,j,0));
					vis[i][j]=2;
				}
				else{
					vis[i][j]=0;
				}
				if(grid[i][j]==1) c++;
			}
		}
		int cn=0;
		int drow[]={-1,0,+1,0};
		int dcol[]={0,+1,0,-1};
		int ans=0;
		while(!temp.isEmpty()){
			int row=temp.peek().i;
			int col=temp.peek().j;
			int t=temp.peek().t;
			ans=Math.max(ans,t);
			temp.remove();

			for(int i=0;i<4;i++){
				int nrow=row+drow[i];
				int ncol=col+dcol[i];
				if(nrow>=0 &&nrow<n && ncol<m && ncol>=0 && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
					temp.add(new pair(nrow,ncol,t+1));
					vis[nrow][ncol]=2;
					cn++;
				}
			}
		}
		if(cn!=c) return -1;
		return ans;
	}

}