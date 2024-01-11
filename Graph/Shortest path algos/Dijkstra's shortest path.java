import java.util.*;

class pair{
    int first,second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
public class Solution {
    public static List<Integer> dijkstra(int[][] edges,int vertices, int edge,int source){
        Queue<pair> q=new PriorityQueue<pair>((x,y)->x.second-y.second);

        List<List<pair>> adj=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new pair(v,wt));
            adj.get(v).add(new pair(u,wt));
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            ans.add(Integer.MAX_VALUE);
        }
        ans.set(source,0);
        q.add(new pair(source,0));

        while(!q.isEmpty()){
            int node=q.peek().first;
            int wt=q.peek().second;
            q.remove();
            for(int i=0;i<adj.get(node).size();i++){
                int w=adj.get(node).get(i).second;
                int t=adj.get(node).get(i).first;
                if(wt+w<ans.get(t)){
                    ans.set(t,wt+w);
                    q.offer(new pair(t,ans.get(t)));
                }
            }
        }
        return ans;
    }
}
