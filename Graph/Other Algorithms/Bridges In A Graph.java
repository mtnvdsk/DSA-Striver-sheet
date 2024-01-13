import java.util.*;

public class Solution {
    public static int timer=1;
    public static void dfs(int i,int parent,int []vis,List<List<Integer>> adj,int []tin,int []low,List<List<Integer>> bridges){
        vis[i]=1;
        tin[i]=low[i]=timer;
        timer++;
        for(Integer j:adj.get(i)){
            if(j==parent) continue;
            if(vis[j]==0){
                dfs(j,i,vis,adj,tin,low,bridges);
                low[i]=Math.min(low[i],low[j]);
                if(low[j]>tin[i]){
                    bridges.add(Arrays.asList(j,i));
                }
            }
            else{
                low[i]=Math.min(low[i],low[j]);
            }
        }
    }

    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int []vis=new int[v];
        int []low=new int[v];
        int []tin=new int[v];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
        return bridges;
    }
}