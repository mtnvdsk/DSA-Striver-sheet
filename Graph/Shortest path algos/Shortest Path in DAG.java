import java.util.*;
public class Solution {
    public static class pair {
        int first, second;
        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void dfs(int node, Stack<Integer> stk, ArrayList<ArrayList<pair>> adj,
            int[] vis) {
        vis[node] = 1;
        for (pair it : adj.get(node)) {
            if (vis[it.first] == 0) {
                dfs(it.first, stk, adj, vis);
            }
        }
        stk.push(node);
    }
    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        int vis[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            int z = edges[i][2];
            adj.get(x).add(new pair(y, z));
        }
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, stk, adj, vis);
            }
        }
        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
        dist[i] = (int)(1e9);
        }

        dist[0] = 0;
        while (!stk.isEmpty()) {
        int node = stk.peek();
        stk.pop();

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            int wt = adj.get(node).get(i).second;

            if (dist[node] + wt < dist[v]) {
            dist[v] = wt + dist[node];
            }
        }
        }

        for (int i = 0; i < n; i++) {
        if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}