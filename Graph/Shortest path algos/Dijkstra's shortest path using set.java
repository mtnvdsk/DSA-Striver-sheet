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
        Set<pair> q = new HashSet<>();
        List<List<pair>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new pair(v, wt));
            adj.get(v).add(new pair(u, wt));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            ans.add(Integer.MAX_VALUE);
        }
        ans.set(source, 0);
        q.add(new pair(source, 0));

        while (!q.isEmpty()) {
            pair current = q.iterator().next();
            q.remove(current);

            int node = current.first;
            int wt = current.second;

            for (pair neighbor : adj.get(node)) {
                int w = neighbor.second;
                int t = neighbor.first;

                if (wt + w < ans.get(t)) {
                    if (ans.get(t) != Integer.MAX_VALUE) {
                        q.remove(new pair(t, ans.get(t)));
                    }
                    ans.set(t, wt + w);
                    q.add(new pair(t, ans.get(t)));
                }
            }
        }
        return ans;
    }
}
