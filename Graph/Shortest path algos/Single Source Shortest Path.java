import java.util.*;
public class Solution {
    public static int[] shortestPath(int n, int [][]edges, int src) {
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> stac=new LinkedList<>();
        dist[src]=0;
        stac.add(src);
        while(!stac.isEmpty()){
            int node=stac.poll();
            for(int i:adj.get(node)){
                if(dist[node]+1<dist[i]){
                    dist[i]=dist[node]+1;
                    stac.add(i);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }
        return dist;
    }
}