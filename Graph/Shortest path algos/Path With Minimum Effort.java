import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class pair{
    int i,j,k;
    pair(int i,int j,int k){
        this.i=i;
        this.j=j;
        this.k=k;
    }
}
public class Solution {
    public static int minimumTimeTakingPath(int[][] heights){
        Queue<pair> q=new PriorityQueue<>((x,y)->x.k-y.k);
        int n=heights.length;
        int m=heights[0].length;
        int[][] ans=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[i][j]=Integer.MAX_VALUE;
            }
        }
        ans[0][0]=0;
        int[] drow={-1,0,+1,0};
        int[] dcol={0,+1,0,-1};
        q.add(new pair(0,0,0));
        while(!q.isEmpty()){
            int row=q.peek().i;
            int col=q.peek().j;
            int wt=q.peek().k;
            q.remove();
            if(row==n-1 && col==m-1) return wt;
            for(int i=0;i<4;i++){
                int r=row+drow[i];
                int c=col+dcol[i];
                if(r>=0 && r<n && c>=0 && c<m){
                    int t=Math.max(Math.abs(heights[row][col]-heights[r][c]),wt);
                    if(t<ans[r][c]){
                        ans[r][c]=t;
                        q.add(new pair(r,c,t));
                    }
                }
            }
        }
        return 0;
    }
}
