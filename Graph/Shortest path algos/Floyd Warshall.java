import java.util.*;

public class Solution {
  static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
    int dis[][]=new int[n+1][n+1];
    for(int[] a:dis) Arrays.fill(a,(int)(1e9));
    for(int i=0;i<edges.size();i++){
        int u=edges.get(i).get(0), v=edges.get(i).get(1),w=edges.get(i).get(2);
        dis[u][v]=w;
        dis[u][u]=0;
        dis[v][v]=0;
    }
    for(int k=1;k<=n;k++){
      for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
          if(dis[i][k]!=(int)(1e9) && dis[k][j]!=(int)(1e9)){
            dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
          }
        }
      }
    }

    return dis[src][dest];
  }

}
