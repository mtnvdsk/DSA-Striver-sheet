
public class Solution{
    public static void dfs(int k,int j,char[][] matrix,int [][]vis,int []drow,int[] dcol){
        vis[k][j]=1;
        int n=matrix.length;
        int m=matrix[0].length;

        for(int i=0;i<4;i++){
            int row=k+drow[i];
            int col=j+dcol[i];
            if(row>=0 && row<n && col>=0 && col<m && vis[row][col]==0 && matrix[row][col]=='O'){
                dfs(row,col,matrix,vis,drow,dcol);
            }
        }
    }

    public static void replaceOWithX(char matrix[][]) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] vis=new int[n][m];

        int []drow={-1,0,+1,0};
        int []dcol={0,1,0,-1};
        for(int i=0;i<n;i++){
            if(vis[i][0]==0 && matrix[i][0]=='O'){
                dfs(i,0,matrix,vis,drow,dcol);
            }
            if(vis[i][m-1]==0 && matrix[i][m-1]=='O'){
                dfs(i,m-1,matrix,vis,drow,dcol);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[0][i]==0 && matrix[0][i]=='O'){
                dfs(0,i,matrix,vis,drow,dcol);
            }
            if(vis[n-1][i]==0 && matrix[n-1][i]=='O'){
                dfs(n-1,i,matrix,vis,drow,dcol);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && matrix[i][j]=='O'){
                    matrix[i][j]='X';
                }
            }
        }
    }
}