package Learning;
import java.util.*;
public class Solution {
    public static void dfs(ArrayList<ArrayList<Integer>> adjMatrix, ArrayList<Integer> ds, boolean visited[], int node){
        visited[node] = true;
        ds.add(node);
        for(int i : adjMatrix.get(node)){
            if(!visited[i]){
                dfs(adjMatrix, ds, visited, i);
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjMatrix = new ArrayList<>();
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            adjMatrix.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int first = edges.get(i).get(0);
            int second = edges.get(i).get(1);
            adjMatrix.get(first).add(second);
            adjMatrix.get(second).add(first);
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> ds = new ArrayList<>();
                dfs(adjMatrix, ds, visited, i);
                ans.add(ds);
            }
        }
        return ans;
    }
}

