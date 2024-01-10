import java.util.*;

public class Solution {

    public static void dfs(int i,int[] vis,List<List<Integer>> adj,Stack<Integer> stac){
        vis[i]=1;
        for(int j:adj.get(i)){
            if(vis[j]==0){
                dfs(j,vis,adj,stac);
            }
        }
        stac.push(i);
    }
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        int[] vis=new int[v];
        Stack<Integer> stac=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,vis,adj,stac);
            }
        }

        while(stac.isEmpty()){
            ans.add(stac.pop());
        }

        return stac;
    }

}