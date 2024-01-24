import java.util.*;

class pair{
	int i,j,step;
	pair(int i,int j,int step){
		this.i=i;
		this.j=j;
		this.step=step;
	}
}
public class Solution {
	public static ArrayList<ArrayList<Integer>> nearest(ArrayList<ArrayList<Integer>> mat, int n, int m) {
		int[][] vis=new int[n][m];
		ArrayList<ArrayList<Integer>> dist=mat;
		
		Queue<pair> a=new LinkedList<pair>();
		
		//got all the 1's places
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat.get(i).get(j)==1){
					a.add(new pair(i,j,0));
					vis[i][j]=1;
				}
			}
		}

		//perform loop with step 1

		int drow[]={-1,0,+1,0};
		int dcol[]={0,+1,0,-1};

		while(!a.isEmpty()){
			int row=a.peek().i;
			int col=a.peek().j;
			int step=a.peek().step;
			a.remove();
			dist.get(row).set(col,step);
			for(int i=0;i<4;i++){
				int nrow=row+drow[i];
				int ncol=col+dcol[i];
				if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && dist.get(nrow).get(ncol)==0 && vis[nrow][ncol]!=1){
					a.add(new pair(nrow,ncol,step+1));
					vis[nrow][ncol]=1;
				}
			}
		}
		return dist;
	}
}
