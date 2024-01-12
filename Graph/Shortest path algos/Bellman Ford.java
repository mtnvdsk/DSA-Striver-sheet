import java.util.List;

public class Solution {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] dis = new int[n+1];
        for(int i=1; i<=n; i++){        
            dis[i]=(int)(1e8);
        }
        dis[src]=0;
        for(int j =0; j<n-1; j++){
            for(int i=0; i<m; i++){ 
                int u = edges.get(i).get(0);
                int v = edges.get(i).get(1);
                int weight = edges.get(i).get(2);
                if( dis[u]+weight<dis[v]){
                    dis[v]=dis[u]+weight;
                }
            }
        }
        return dis;
    }
}

