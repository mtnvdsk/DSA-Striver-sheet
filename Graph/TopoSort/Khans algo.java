import java.util.*;

public class Solution {
    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();

        int[] inde=new int[v];
        
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        for(int i=0;i<v;i++){
            for(int j:adj.get(i)){
                inde[j]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inde[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int temp=q.poll();
            ans.add(temp);
            for(int j:adj.get(temp)){
                inde[j]--;
                if(inde[j]==0){
                    q.add(j);
                }
            }
        }
        return ans;
    }
}