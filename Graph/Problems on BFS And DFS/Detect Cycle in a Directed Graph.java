import java.util.ArrayList;
import java.util.List;
public class Solution 
{
    public static Boolean checkCycle(int r, int vis[], List<List<Integer>> adj){
        vis[r] = 1;
        for(int i : adj.get(r)){
            if(vis[i] == 1) return true;
            if(vis[i] == 0 && checkCycle(i, vis, adj) == true) return true;
        }
        vis[r] = 0;
        return false;      
}
    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        List<List<Integer>> adj = new ArrayList<>();     // adjaceny list
        int n = edges.length;
        int vis[] = new int[v];
        for(int i=0; i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            adj.get(x).add(y);
        }
        for(int i=0; i<v; i++){
           if( checkCycle(i, vis, adj) == true ) return true;
        }
        return false;
    }
} 