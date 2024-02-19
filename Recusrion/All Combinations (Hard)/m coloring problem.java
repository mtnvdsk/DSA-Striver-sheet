import java.util.*;
public class Solution {
    public static String graphColoring(int[][] mat, int m) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = mat.length;
        int color[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
            color[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        if (solve(0, adj, color, n, m) == true)
            return "YES";
        return "NO";
    }
    public static boolean solve(int node, HashMap<Integer, ArrayList<Integer>> adj, int[] color, int n, int m) {
        if (node == n)
            return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(node, adj, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, adj, color, n, m) == true)
                    return true;
                color[node] = -1;
            }
        }
        return false;
    }
    public static boolean isSafe(int node, HashMap<Integer, ArrayList<Integer>> adj, int[] color, int n, int colour) {
        for (int it : adj.get(node)) {
            if (color[it] == colour)
                return false;
        }
        return true;
    }
}