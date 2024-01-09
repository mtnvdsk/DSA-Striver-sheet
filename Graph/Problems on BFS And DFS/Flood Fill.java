public class Solution {
    public static void dfs(int [][]image,int[][] ans,int sr,int sc,int newcolor,int incolor,int[] delrow,int[] delcol){
        ans[sr][sc]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=sr+delrow[i];
            int ncol=sc+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==incolor && ans[nrow][ncol]!=newcolor){
                dfs(image,ans,nrow,ncol,newcolor,incolor,delrow,delcol);
            }
        }
    }
    public static int[][] floodFill(int[][] image,int n,int m,int sr, int sc, int newColor)
    {
        int [][]ans=image;
        int incolor=image[sr][sc];
        int []delrow={-1,0,+1,0};
        int []delcol={0,+1,0,-1};
        dfs(image,ans,sr,sc,newColor,incolor,delrow,delcol);
        return ans;
    }
}