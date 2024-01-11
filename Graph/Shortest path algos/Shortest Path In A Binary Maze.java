import java.util.*;

/*************************************

Following is the Point Class structure

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

**************************************/
class pair{
	int i,j,wt;
	pair(int i,int j,int wt){
		this.i=i;
		this.j=j;
		this.wt=wt;
	}
}
public class Solution {
	public static int shortestPathBinaryMatrix(int[][] matrix, Point src, Point dest) {
		if(matrix[src.x][src.y]==0 || matrix[dest.x][dest.y]==0) return -1;
		if(src.x==dest.x && src.y==dest.y) return 0;
		Queue<pair> q=new LinkedList<>();
		int n=matrix.length;
		int m=matrix[0].length;

		int[][] dist=new int[n][m];

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				dist[i][j]=Integer.MAX_VALUE;
			}
		}
		dist[src.x][src.y]=0;
		int[] drow={-1,0,+1,0};
		int[] dcol={0,+1,0,-1};

		q.add(new pair(src.x,src.y,0));
		while(!q.isEmpty()){
			int row=q.peek().i;
			int col=q.peek().j;
			int wt=q.peek().wt;
			q.remove();
			for(int i=0;i<4;i++){
				int r=row+drow[i];
				int c=col+dcol[i];
				if(r>=0 && r<n && c>=0 && c<m && matrix[r][c]==1){
					if(wt+1<dist[r][c]){
						dist[r][c]=wt+1;
						if(dest.x==r && dest.y==c){
							return wt+1;
						}
						q.add(new pair(r,c,wt+1));
					}
				}
			}
		}
		return -1;
	}
}


// If given 8 directions

class tuple{
    int a;
    int b;
    int c;
    tuple(int _a,int _b,int _c){
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
     int n = grid.length;
     int m = grid[0].length;
     if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
     if(n-1 == 0) return 1;
     int[][] dis = new int[n][m];
     Queue<tuple> queue = new LinkedList<>();
     for(int[] i:dis){
         Arrays.fill(i,(int)1e9);
     }
     dis[0][0] = 1;
     queue.add(new tuple(1,0,0));
     int[] dr = {0,1,-1,0,1,-1,1,-1};
     int[] dc = {1,0,0,-1,1,1,-1,-1};
     while(!queue.isEmpty()){
         tuple it = queue.poll();
         int d = it.a;
         int r = it.b;
         int c = it.c;
         for(int i=0; i<8; i++){
             int nrow = r + dr[i];
             int ncol = c + dc[i];
             if(nrow >=0 && nrow <n && ncol >=0 && ncol < m && grid[nrow][ncol] == 0 && d+1 < dis[nrow][ncol]){
                 dis[nrow][ncol] = 1 + d;
                 if(nrow == n-1 && ncol == n-1) return d + 1;
                 queue.add(new tuple(d+1,nrow,ncol));
             }
         }
     }
     return -1;
    }
}